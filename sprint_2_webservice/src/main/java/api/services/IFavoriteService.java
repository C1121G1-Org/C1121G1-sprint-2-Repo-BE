package api.services;

import api.models.Favorite;

import java.util.List;

public interface IFavoriteService {
    List<Favorite> getAllFavorite();
}
