package api.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "comment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "longtext",nullable = false)
    private String commentContent;

    @Column(name = "time", nullable = false, columnDefinition = "DATE")
    private String time;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private Post post;
    @OneToMany(mappedBy = "comment")
    @JsonBackReference
    private Set<LikeComment> likeCommentSet;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "guest_id", referencedColumnName = "id")
    private Guest guest;
}
