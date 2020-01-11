package pl.lukaszgeb.kwejk.dao;

import org.springframework.stereotype.Component;
import pl.lukaszgeb.kwejk.model.Gif;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GifDaoImpl implements GifDao {

    public GifDaoImpl() {
    }

    private static List<String> names = new ArrayList<>();

    public static List<String> getNames() {
        return names;
    }

    public static List<Gif> gifsWithId = new ArrayList<>();

    static {
        gifsWithId.add(new Gif("android-explosion", "username1", 1));
        gifsWithId.add(new Gif("ben-and-mike", "username2",2));
        gifsWithId.add(new Gif("book-dominos", "username3", 3));
        gifsWithId.add(new Gif("compiler-bot", "username4", 1));
        gifsWithId.add(new Gif("cowboy-coder", "username5", 1));
        gifsWithId.add(new Gif("infinite-andrew", "username6", 2));
    }
    public static void setNames(List<String> names) {
        GifDaoImpl.names = names;
    }

    static {
        names.add("android-explosion");
        names.add("ben-and-mike");
        names.add("book-dominos");
        names.add("compiler-bot");
        names.add("cowboy-coder");
        names.add("infinite-andrew");
    }

    @Override
    public List<Gif> findAll() {
        List<Gif> gifs = new ArrayList<>();
        int i = 1;
        for (String name : names) {
            Gif gif = new Gif(name, "username" + i++);
            gifs.add(gif);
            if (i % 2 == 0)
                gif.setFavorite(true);
            else
                gif.setFavorite(false);
        }
        return gifs;
    }


    @Override
    public List<Gif> getFavorites() {
        return findAll().stream().filter((g) -> g.isFavorite()).collect(Collectors.toList());
    }

    @Override
    public Gif findOne(String name) {
        for (Gif gif : findAll()) {
            if (gif.getName().equals(name)) {
                return gif;
            }
        }
        return null;
    }

    @Override
    public List<Gif> searchGifsFromCategory(int q) {
        List<Gif> categoryGifs = new ArrayList();
        for (int i=0; i<gifsWithId.size(); i++){
            if (gifsWithId.get(i).getCategoryId()==q){
                categoryGifs.add(gifsWithId.get(i));
            }
        }
        return categoryGifs;
    }

}
