package api.services.impl;

import api.repositories.IGuestFavoriteRepository;
import api.services.IGuestFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestFavoriteServiceImpl implements IGuestFavoriteService {
    @Autowired
    IGuestFavoriteRepository iGuestFavoriteRepository;
}
