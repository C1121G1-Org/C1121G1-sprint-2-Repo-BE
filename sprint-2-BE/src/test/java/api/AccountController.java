package api;

import api.dto.AccountDto;
import api.dto.ChangePassword;
import api.models.Account;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class AccountController {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    //    test cho new password rỗng;
    @Test
    public void updatePassword_14() throws Exception {
        ChangePassword changePassword = new ChangePassword();
        changePassword.setNewPassword("");
        changePassword.setUsername("khoaVC");
        changePassword.setCurrentPassword("12345");
        changePassword.setConfirmNewPassword("");
        changePassword.setNewPassword("");
        Account account = new Account();
        account.setId(1L);
        account.setUserName(changePassword.getUsername());
        account.setIsLogin(true);
        account.setVerificationCode("");
        account.setEncryptPassword(changePassword.getNewPassword());
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/updatePassword/")
                        .content(this.objectMapper.writeValueAsString(account))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    test cho new password null
    @Test
    public void updatePassword_13() throws Exception {
        ChangePassword changePassword = new ChangePassword();
        changePassword.setUsername("khoaVC");
        changePassword.setCurrentPassword("12345");
//        changePassword.setNewPassword("");
        Account account = new Account();
        account.setId(1L);
        account.setUserName(changePassword.getUsername());
        account.setIsLogin(true);
        account.setVerificationCode("");
        account.setEncryptPassword(changePassword.getNewPassword());
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/updatePassword/")
                        .content(this.objectMapper.writeValueAsString(account))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    test cho new  password không đúng định dạng
    @Test
    public void updatePassword_15() throws Exception {
        ChangePassword changePassword = new ChangePassword();
        changePassword.setUsername("khoaVC");
        changePassword.setCurrentPassword("12345");
//        "Mật khẩu phải có ít nhất 8 ký tự, 1 chữ viết hoa, 1 chữ viết thường, 1 ký tự đặt biệt, 1 chữ số và không được chứa khoảng trắng
        changePassword.setNewPassword("webhenho123");
        changePassword.setConfirmNewPassword("webhenho123");
        Account account = new Account();
        account.setId(1L);
        account.setUserName(changePassword.getUsername());
        account.setIsLogin(true);
        account.setVerificationCode("");
        account.setEncryptPassword(changePassword.getNewPassword());
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/updatePassword/")
                        .content(this.objectMapper.writeValueAsString(account))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //    test cho new  password quá ngắn
    @Test
    public void updatePassword_16() throws Exception {
        ChangePassword changePassword = new ChangePassword();
        changePassword.setUsername("khoaVC");
        changePassword.setCurrentPassword("12345");
//        "Mật khẩu phải có ít nhất 8 ký tự, 1 chữ viết hoa, 1 chữ viết thường, 1 ký tự đặt biệt, 1 chữ số và không được chứa khoảng trắng
        changePassword.setNewPassword("web");
        changePassword.setConfirmNewPassword("web");
        Account account = new Account();
        account.setId(1L);
        account.setUserName(changePassword.getUsername());
        account.setIsLogin(true);
        account.setVerificationCode("");
        account.setEncryptPassword(changePassword.getNewPassword());
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/updatePassword/")
                        .content(this.objectMapper.writeValueAsString(account))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //    test cho update password thành công
    @Test
    public void updatePassword_18() throws Exception {
        ChangePassword changePassword = new ChangePassword();
        changePassword.setUsername("khoaVC");
        changePassword.setCurrentPassword("12345");
//        "Mật khẩu phải có ít nhất 8 ký tự, 1 chữ viết hoa, 1 chữ viết thường, 1 ký tự đặt biệt, 1 chữ số và không được chứa khoảng trắng
        changePassword.setNewPassword("Webhenho@123");
        changePassword.setConfirmNewPassword("Webhenho@123");
        Account account = new Account();
        account.setId(1L);
        account.setUserName(changePassword.getUsername());
        account.setIsLogin(true);
        account.setVerificationCode("");
        account.setEncryptPassword(changePassword.getNewPassword());
        this.mockMvc.perform(MockMvcRequestBuilders.patch("/updatePassword/")
                        .content(this.objectMapper.writeValueAsString(account))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


}
