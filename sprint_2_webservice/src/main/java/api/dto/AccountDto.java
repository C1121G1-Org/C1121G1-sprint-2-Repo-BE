package api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
        Created by khoaVC
        Role: GUEST
        Time: 20:00 16/06/2022
        Function:
        Class: AccountSprint2Dto
*/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto implements Validator {

    private Long id;

    @NotBlank(message = "Tên đăng nhập không được để trống.")
    @Size(min = 6, max = 32, message = "Tên đăng nhập phải từ 6 - 32 ký tự.")
    private String userName;

    private String encryptPassword;

    private Boolean isEnabled;

    private String verificationCode;

    @NotNull(message = "Trạng thái đăng nhập không được để trống")
    private Boolean isLogin;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        AccountDto accountDto = (AccountDto) target;
        // Validate userName
        if (accountDto.getUserName() != null) {
            if (!accountDto.getUserName().matches("^$|^[^!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?~`]*$")){
                errors.rejectValue("userName", "", "Tên đăng nhập không chứa các ký tự đặc biệt.");
            }
        }
    }
}
