package api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

    /*
        Created by khoaVC
        Role: MEMBER
        Time: 23:00 15/06/2022
        Function:
        Class: ExtraPersonDto
    */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExtraInforDto {
    private String image;
    private String favorite;
    private Boolean maritalStatus;
    private List<Integer> targetList;
    private List<Integer> favoriteList;
}
