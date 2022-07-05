package api.controllers;

import api.services.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class SendEmailController {

    @Autowired
    private SendEmailService emailService;

    @PostMapping(value = "/email")
    public ResponseEntity<?> enviarEmail(String email, String name, String code) throws Exception{
        try {
            emailService.sendEmail(email, name, code);
            return new ResponseEntity<>(email, HttpStatus.OK);
        } catch (MailException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
