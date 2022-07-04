package api.controllers;

import api.models.Account;
import api.payload.request.LoginRequest;
import api.payload.response.JwtResponse;
import api.security.JwtUtility;
import api.services.IAccountService;
import api.services.impl.AccountDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/*
    Created by TuanPA
    Date: 17:55 23/06/2022
    Function: This SecurityRestController class stipulates which method the requests sent from clients will go.
*/

@RestController
@RequestMapping("api/public")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SecurityRestController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private IAccountService iAccountService;

//    @Autowired
//    private JwtFilter jwtFilter;

//    @Autowired
//    private PasswordEncoder encoder;


    /*
        Function: This authenticateUser() method stipulates which method the requests sent from clients will go.
    */
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtility.generateJwtToken(loginRequest.getUsername());

        AccountDetailsImpl accountDetails = (AccountDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<String> roles = accountDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return new ResponseEntity<>(new JwtResponse(jwt, accountDetails.getId(), accountDetails.getUsername(), accountDetails.getImageLink(), roles), HttpStatus.OK);
    }

    @PatchMapping(value = "/warning/{id}")
    public ResponseEntity<Account> warningReport(){
        return null;
    }




}