package api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class GiftGuest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne
    @JoinColumn(name = "guest_receive", referencedColumnName = "id")
    private Guest guest;

    @ManyToOne
    @JoinColumn(name = "gift_id", referencedColumnName = "id")
    private Gift gift;

    private String sender;


}
