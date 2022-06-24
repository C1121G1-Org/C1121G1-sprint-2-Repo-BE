package api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
