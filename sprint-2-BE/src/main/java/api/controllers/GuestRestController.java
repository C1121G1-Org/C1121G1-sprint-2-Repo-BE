package api.controllers;
import api.dto.ChangePassword;
import api.dto.ExtraInforDto;
import api.dto.GuestDto;
import api.dto.Top100Dto;
import api.models.*;
import api.security.JwtFilter;
import api.security.JwtUtility;
import api.services.*;
import api.services.impl.PassEncTech1;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/guest")
public class GuestRestController {
    @Autowired
    PassEncTech1 passEncTech1;

    @Autowired
    IGuestService iGuestService;

    @Autowired
    IGuestTargetService iGuestTargetService;

    @Autowired
    IAccountService iAccountService;

    @Autowired
    IAccountRoleService iAccountRoleService;

    @Autowired
    ITargetService iTargetService;

    @Autowired
    IFavoriteService iFavoriteService;
    @Autowired
    private JwtFilter jwtFilter;

    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtility jwtUtility;

    @GetMapping(value = "/list")
    public String listGuest() {
        return null;
    }

    /*
        Created by khoaVC
        Role: GUEST
        Time: 20:00 16/06/2022
        Function: createPerson() = create Person
        @Transactional(rollbackForClassName = {"Exception.class"}): to roll back in case throw exception
    */
    // You can use @Transactional without (rollbackForClassName = {"Exception.class"}) and try...catch => it also auto rollback for you
    @Transactional(rollbackFor = Exception.class)
    @PostMapping(value = "/create")
    public ResponseEntity<ResponseObject> createGuest(@Valid @RequestBody GuestDto guestDto, BindingResult bindingResult) {
        guestDto.validate(guestDto, bindingResult);
        // Validate duplicate userName
        if (getGuestByUserName(guestDto.getUserName()) != null) {
            bindingResult.rejectValue("userName", "", "Tên đăng nhập đã tồn tại.");
        }
        // Validate duplicate email
        if (getGuestByEmail(guestDto.getEmail()) != null) {
            bindingResult.rejectValue("email", "", "Email đã tồn tại.");
        }
        // Mapping all errors into a map to send to Angular
        Map<String, String> errorMap = new HashMap<>();
        bindingResult
                .getFieldErrors()
                .forEach(
                        fieldError -> {
                            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
                        });
        // Print log errors
        if (bindingResult.hasErrors()) {
            for (Map.Entry<String, String> entry : errorMap.entrySet()) {
                System.out.printf("%s: %s\n", entry.getKey(), entry.getValue());
            }
        }

        if (!bindingResult.hasErrors()) {
            try {
                // Add new Account
                Account account = new Account();
                mappingAccount(guestDto, account);
                iAccountService.create(account);

                // Find Account by userName (because account id = null), then Add new AccountRole, set role = 2
                Account as = iAccountService.getAccountByUserName(account.getUserName());
                if (as != null) {
                    iAccountRoleService.create(as, 2L);
                } else {
                    throw new Exception();
                }

                // Add new Person
                Guest guest = new Guest();
                BeanUtils.copyProperties(guestDto, guest);
                guest.setAccount(as);
                iGuestService.create(guest);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return new ResponseEntity<>(new ResponseObject<>(false, "FAILED", errorMap, new ArrayList<>()), HttpStatus.BAD_REQUEST);
    }

    /*
        Created by khoaVC
        Role: MEMBER
        Time: 23:00 15/06/2022
        Function: updatePerson() = update Person
    */
    // If input id = String datatype or other datatype => Error 404??? How to resolve???
    // If "targetList": [1,7] => Error 500??? => DQ error => How to resolve???
    // You can use @Transactional without (rollbackForClassName = {"Exception.class"}) and try...catch => it also auto rollback for you
    @Transactional(rollbackFor = Exception.class)
    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<ResponseObject> updateGuest(@PathVariable Long id, @RequestBody ExtraInforDto extraInforDto) {
        try {
            // Case null or empty data
            if ((extraInforDto.getImage() == null || extraInforDto.getImage().trim().equals(""))
                    && extraInforDto.getMaritalStatus() == null
                    && extraInforDto.getTargetList().size() == 0
                    && (extraInforDto.getFavorite() == null || extraInforDto.getFavorite().trim().equals(""))) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                Guest guest = iGuestService.findGuestById(id);
                if (guest != null) {
                    // Case null or empty data
//                if ((extraInforDto.getImage() == null || extraInforDto.getImage().trim().equals(""))
//                        && extraInforDto.getMaritalStatus() == null
//                        && extraInforDto.getTargetList().size() == 0) {
//                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//                } else {
                    // Update image and maritalStatus for person
                    iGuestService.updateGuestById(id, extraInforDto);

                    // Add target list into table person_target
                    if (extraInforDto.getTargetList().size() > 0) {
                        List<Integer> targetList = extraInforDto.getTargetList();
                        for (Integer i : targetList) {
                            iGuestTargetService.create(id, i);
                        }
                    }
                    return new ResponseEntity<>(HttpStatus.OK);
//                }
                } else {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/delete") //Nếu dùng deleteFlag thì phải dùng @PatchMapping để update lại deleteFlag
    public String deleteGuest() {
        return null;
    }

    /*
        Created by khoaVC
        Role: GUEST
        Time: 23:00 15/06/2022
        Function: getPersonByUserName = find Person by userName
        Class:
    */
    @GetMapping(value = "/getByUseName")
    public Guest getGuestByUserName(@RequestParam(name = "un") String userName) {
        return iGuestService.getGuestByUserName(userName);
    }

    /*
        Created by khoaVC
        Role: GUEST
        Time: 09:40 16/06/2022
        Function: getPersonByEmail = find Person by email
        Class:
    */
    @GetMapping(value = "/getByEmail")
    public Guest getGuestByEmail(@RequestParam(name = "em") String email) {
        return iGuestService.getGuestByEmail(email);
    }

    /*
            Created by khoaVC
            Role: GUEST
            Time: 20:00 16/06/2022
            Function: mappingAccount() = mapping personDto to account
            Class:
    */
    private void mappingAccount(GuestDto guestDto, Account account) {
        account.setUserName(guestDto.getUserName());
        account.setEncryptPassword(passEncTech1.encode(guestDto.getPassword()));
        account.setIsEnabled(true);
        account.setVerificationCode(null);
    }

    @GetMapping(value = "/listTarget")
    public ResponseEntity<List<Target>> listTarget() {
        return new ResponseEntity<>(iTargetService.getAllTarget(), HttpStatus.OK);
    }

    @GetMapping(value = "/listFavorite")
    public ResponseEntity<List<Favorite>> listFavorite() {
        return new ResponseEntity<>(iFavoriteService.getAllFavorite(), HttpStatus.OK);
    }

    /*
            Created by tamHT
            Role: GUEST
            Time: 20:00 25/06/2022
            Class:
    */
    @PatchMapping("/updatePassword")
    public ResponseEntity<Account> update(@Valid @RequestBody ChangePassword changePassword) {
        Account account = jwtFilter.findAccountByJwtToken();
        if (encoder.matches(changePassword.getCurrentPassword(), account.getEncryptPassword()) &&
                changePassword.getNewPassword().equals(changePassword.getConfirmNewPassword())) {
            String encryptPassword = encoder.encode(changePassword.getNewPassword());
            iAccountService.changePassword(encryptPassword, account.getId());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/listTop100")
    public ResponseEntity<Page<Top100Dto>> viewTop100( @RequestParam int page){
        Page<Top100Dto> top100Dtos = iGuestService.viewTop100(PageRequest.of(page, 10));
        if (top100Dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(top100Dtos, HttpStatus.OK);
    }
}

