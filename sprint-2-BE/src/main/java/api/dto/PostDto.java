package api.dto;

import api.models.Guest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    private Long id;

    private String image;

    private String postDate;

    private String privacy;

    private String feeling;

    private String content;

    private Long guestId;

}
