package api.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LikeCommentDto {
    @NotNull(message = "flag không được để trống")
    Boolean likeCommentFlag;
    @NotNull(message = "id comment không được để trống!")
    Long commentId;
    @NotNull(message = "id khách hàng không được để trống!")
    Long guestId;
}
