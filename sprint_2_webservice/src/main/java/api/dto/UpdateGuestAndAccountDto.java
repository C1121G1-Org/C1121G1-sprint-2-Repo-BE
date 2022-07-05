package api.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateGuestAndAccountDto implements Validator {
    private String image;
    @NotNull(message = "Trạng thái đăng nhập không được để trống!")
    private Boolean isLogin;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UpdateGuestAndAccountDto updateGuestAndAccountDto = (UpdateGuestAndAccountDto) target;
        if (updateGuestAndAccountDto.getIsLogin()==null) {
            errors.rejectValue("idLogin", "isLogin.notNull", "Trạng thái đăng nhập  không được để trống!"); }
    }
}
