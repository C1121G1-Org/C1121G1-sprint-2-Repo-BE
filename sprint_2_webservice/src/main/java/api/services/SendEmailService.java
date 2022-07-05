package api.services;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface SendEmailService {
    void sendEmail(String email, String name, String code) throws MessagingException, UnsupportedEncodingException;
}
