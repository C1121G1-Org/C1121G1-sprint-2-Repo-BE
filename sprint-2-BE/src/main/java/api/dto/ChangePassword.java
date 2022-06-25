package api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/*
    Created by tamHT
    Date: 15:30 25/06/2022
    Function: This object use to hold the current and new password to change password.
*/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChangePassword {
    private String username;
    @NotBlank(message = "Vui lòng nhập mật khẩu hiện tại.")
    private String currentPassword;

    @NotBlank(message = "Vui lòng nhập mật khẩu mới.")
    @Pattern(regexp = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$",
            message = "Mật khẩu phải có ít nhất 8 ký tự, 1 chữ viết hoa, 1 chữ viết thường, 1 ký tự đặt biệt, 1 chữ số và không được chứa khoảng trắng, tab, v.v")
    private String newPassword;
    @NotBlank(message = "Vui lòng nhập xác nhận mật khẩu mới.")
    @Pattern(regexp = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$",
            message = "Mật khẩu phải có ít nhất 8 ký tự, 1 chữ viết hoa, 1 chữ viết thường, 1 ký tự đặt biệt, 1 chữ số và không được chứa khoảng trắng, tab, v.v")
    private String confirmNewPassword;

}
