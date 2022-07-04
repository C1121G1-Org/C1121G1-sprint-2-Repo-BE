package api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

    /*
        Created by khoaVC
        Role: GUEST
        Time: 23:00 15/06/2022
        Function:
        Class: PersonDto
    */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GuestDto implements Validator {

    private Long id;

    @NotBlank(message = "Tên đăng nhập không được để trống.")
    @Size(min = 6, max = 32, message = "Tên đăng nhập phải từ 6 - 32 ký tự.")
    private String userName;

    @NotBlank(message = "Mật khẩu không được để trống.")
    @Size(min = 6, max = 32, message = "Mật khẩu phải từ 6 - 32 ký tự.")
    private String password;

    @NotBlank(message = "Ngày sinh không được để trống.")
    private String dateOfBirth;

//    @NotNull(message = "Giới tính không được để trống") //Chưa bắt được null
    private boolean gender;

    @NotBlank(message = "Nghề nghiệp không được để trống.")
    private String career;

    @NotBlank(message = "Địa chỉ không được để trống.")
    private String address;

    @NotBlank(message = "Email không được để trống.")
    @Email(message = "Bạn nhập sai định dạng email.")
    private String email;

    private String image;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        GuestDto guestDto = (GuestDto) target;

        // Validate userName
        if (guestDto.getUserName() != null) {
            if (!guestDto.getUserName().matches("^$|^[^!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?~`]*$")){
                errors.rejectValue("userName", "", "Tên đăng nhập không chứa các ký tự đặc biệt.");
            }
        }
        // Validate dateOfBirth
        if (guestDto.getDateOfBirth().equals("")) {
            errors.rejectValue("dateOfBirth", "dateOfBirth.notBlank", "Ngày sinh không được để trống.");
        } else {
            LocalDate today = LocalDate.now();
            LocalDate minDate = LocalDate.of(1800,1,1);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dateOfBirth = LocalDate.parse(guestDto.getDateOfBirth(), formatter);
            Period period = Period.between(dateOfBirth, today);
            if (period.getYears() < 18) {
                errors.rejectValue("dateOfBirth", "dateOfBirth.18", "Ngày sinh phải lớn hơn 18 tuổi.");
            }
            if (dateOfBirth.isBefore(minDate)) {
                errors.rejectValue("dateOfBirth", "dateOfBirth.18", "Ngày sinh phải trước ngày 01-01-1800.");
            }
        }

    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender=" + gender +
                ", career='" + career + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
