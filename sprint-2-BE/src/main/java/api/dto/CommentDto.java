package api.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto implements Validator {
    private Long id;

    @NotBlank(message = "comment không được để trống")
    private String commentContent;
    @Pattern(regexp = "('^\\\\d{4}[\\\\-\\\\/\\\\s]?((((0[13578])|(1[02]))[\\\\-\\\\/\\\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\\\-\\\\/\\\\s]?(([0-2][0-9])|(30)))|(02[\\\\-\\\\/\\\\s]?[0-2][0-9]))$')",
    message = "Định dạng ngày tháng không hợp lệ!")
    @NotBlank(message = "thời gian comment không được để trống")
    private String time;



    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
