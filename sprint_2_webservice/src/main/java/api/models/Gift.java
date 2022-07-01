package api.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Gift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    private String image;
    @Column(name = "amount_Coin", columnDefinition = "Integer")
    private String amountCoin;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private CategoryGift categoryGift;
    @OneToMany(mappedBy = "gift")
    @JsonBackReference
    private Set<GiftGuest> giftGuestSet;
}
