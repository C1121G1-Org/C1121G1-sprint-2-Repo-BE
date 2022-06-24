package api.services.impl;

import api.models.Favorite;
import api.repositories.IFavoriteRepository;
import api.services.IFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteServiceImpl implements IFavoriteService {
    @Autowired
    IFavoriteRepository iFavoriteRepository;

    @Override
    public List<Favorite> getAllFavorite() {
        return iFavoriteRepository.getAllFavorite();
    }
}
