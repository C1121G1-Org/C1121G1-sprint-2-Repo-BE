package api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

    /*
        Created by TuanNQ
        Time: 14:00 23/06/2022
        Function: Create post
    */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    private Long id;
    private String image;
    private String postDate;
    private String privacy;
    private String feeling;

    @NotBlank
    private String content;
    private Long guestId;
}
