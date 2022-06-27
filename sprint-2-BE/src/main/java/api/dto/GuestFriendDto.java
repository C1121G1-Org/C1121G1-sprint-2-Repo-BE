package api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/*
    Created by HauPV
    Time: 14:00 27/06/2022
    Function: Guest Friend DTO
*/
@Getter
@Setter
@NoArgsConstructor
public class GuestFriendDto {

    private Long id;

    private boolean isAccept;

    private boolean isSuggest;

    private GuestDto guestDto;

    private FriendDto friendDto;

}
