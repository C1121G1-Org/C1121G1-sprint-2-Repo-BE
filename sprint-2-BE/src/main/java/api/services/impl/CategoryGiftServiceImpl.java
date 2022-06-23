package api.services.impl;

import api.repositories.ICategoryGiftRepository;
import api.services.ICategoryGiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryGiftServiceImpl implements ICategoryGiftService {
    @Autowired
    ICategoryGiftRepository iCategoryGiftRepository;
}
