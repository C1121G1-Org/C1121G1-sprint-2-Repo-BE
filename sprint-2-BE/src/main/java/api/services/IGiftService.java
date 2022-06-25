package api.services;

import api.models.CategoryGift;
import api.models.Gift;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IGiftService {
    Page<Gift> getAllGift(Pageable pageable);

    List<CategoryGift> categoryList();

}
