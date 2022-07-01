package api.controllers;

import api.dto.CommentDto;
import api.models.Account;
import api.models.Guest;
import api.models.ResponseObject;
import api.services.ICommentService;
import api.services.ILikeCommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/comment")
public class CommentRestController {
    @Autowired
    ICommentService iCommentService;
    @Autowired
    ILikeCommentService iLikeCommentService;

/*
        *//*
           Created by hoangDH
           Role: Admin, member
           Time: 11:17 24/06/2022
           Function: create comment;
           Class:
       *//*
    @Transactional(rollbackFor = Exception.class)
    @PostMapping(value = "/create")
    public ResponseEntity<ResponseObject> createComment(@Valid @RequestBody CommentDto commentDto, BindingResult bindingResult){
        commentDto.validate(commentDto, bindingResult);
        Map<String, String> errorMap = new HashMap<>();
        bindingResult
                .getFieldErrors()
                .stream()
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
                List<Guest> result = new ArrayList<>();
                result.add(guest);
                return new ResponseEntity<>(new ResponseObject<>(true, "OK", errorMap, result), HttpStatus.OK);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return new ResponseEntity<>(new ResponseObject<>(false, "FAILED", errorMap, new ArrayList<>()), HttpStatus.BAD_REQUEST);
    }*/

    @GetMapping(value = "/list")
    public ResponseEntity<ResponseObject> listComment(){
        return null;
    }

    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<ResponseObject> updateComment(@PathVariable String id){
        return null;
    }

    @PatchMapping(value = "/delete/{id}")
    public ResponseEntity<ResponseObject> deleteComment(@PathVariable String id){
        return null;
    } //Xóa bằng cách update lại các delete_flag = 1
}
