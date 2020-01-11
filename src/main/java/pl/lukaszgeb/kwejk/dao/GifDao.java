package pl.lukaszgeb.kwejk.dao;

import pl.lukaszgeb.kwejk.model.Gif;

import java.util.List;

public interface GifDao {
    List<Gif> findAll();
    List<Gif> getFavorites();
    Gif findOne(String name);
    List<Gif> searchGifsFromCategory(int id);
}
