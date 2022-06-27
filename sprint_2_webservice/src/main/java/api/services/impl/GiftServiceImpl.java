package api.services.impl;

import api.repositories.IGiftRepository;
import api.services.IGiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GiftServiceImpl implements IGiftService {
    @Autowired
    IGiftRepository iGiftRepository;
}
