package api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/*
    Created by HauPV
    Time: 14:00 27/06/2022
    Function: Friend DTO
*/
@Getter
@Setter
@NoArgsConstructor
public class FriendDto {
    private Long id;
    private String name;
    private String dateOfBirth;
    private boolean gender;
    private String career;
    private String address;
    private String email;
    private String image;
    private Boolean maritalStatus;
    private boolean deleteFlag;
}
