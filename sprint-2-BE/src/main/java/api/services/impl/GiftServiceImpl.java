package api.services.impl;

import api.models.CategoryGift;
import api.models.Gift;
import api.repositories.ICategoryGiftRepository;
import api.repositories.IGiftRepository;
import api.services.IGiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiftServiceImpl implements IGiftService {
    @Autowired
    IGiftRepository iGiftRepository;
    @Autowired
    ICategoryGiftRepository iCategoryGiftRepository;

    @Override
    public Page<Gift> getAllGift(Pageable pageable) {
        return iGiftRepository.getAllGift(pageable);
    }

    @Override
    public List<CategoryGift> categoryList() {
        return iCategoryGiftRepository.getAllCategory();
    }
}
