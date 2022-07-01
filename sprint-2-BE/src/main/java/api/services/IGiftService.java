package api.services;

import api.models.CategoryGift;
import api.models.Gift;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface IGiftService {
    Page<Gift> getAllGift(Pageable pageable ,Integer categoryId);

    List<CategoryGift> categoryList();

}
