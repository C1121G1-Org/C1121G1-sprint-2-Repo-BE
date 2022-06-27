package api.dto;

import api.models.Comment;
import api.models.Guest;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

public class LikeCommentDto {
    private Long id;
    @NotNull
    private boolean likeCommentFlag;
}
