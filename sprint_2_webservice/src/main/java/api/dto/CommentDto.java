package api.dto;

import api.models.Comment;
import api.models.Guest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto implements Validator {
    private Long id;
    @NotBlank(message = "comment không được để trống!")
    private String commentContent;
    @NotBlank(message = "Ngày tạo comment không được để trống!")
    @Pattern(regexp = "^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$", message = "vui lòng nhập đúng định dạng")
    private String time;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }



    @Override
    public void validate(Object target, Errors errors) {
        CommentDto commentDto = (CommentDto) target;
        String pattern="^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$";

        if (commentDto.getTime().equals("")) {
            errors.rejectValue("time", "time.notBlank", "Ngày tạo comment không được để trống!");
        }
        else if(!commentDto.getTime().matches(pattern)){
            errors.rejectValue("time", "time.pattern", "Ngày tạo comment không đúng định dạng!");
        }else {
            LocalDate today = LocalDate.now();
            LocalDate minDate = LocalDate.of(2020,1,1);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate time = LocalDate.parse(commentDto.getTime(), formatter);

            if (time.isAfter(today)) {
                errors.rejectValue("time", "time.after", "Ngày tạo comment phải nhỏ hơn ngày hiện tại!");
            }
            if (time.isBefore(minDate)) {
                errors.rejectValue("time", "time.before", "Ngày tạo comment phải sau ngày thành lập page");
            }
        }
    }
}
