package pl.lukaszgeb.kwejk.dao;

import pl.lukaszgeb.kwejk.model.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> showCategories();
    Category searchCategory(String q);
    Category searchCategoryById(int id);

}
