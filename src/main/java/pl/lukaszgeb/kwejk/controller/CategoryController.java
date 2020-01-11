package pl.lukaszgeb.kwejk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pl.lukaszgeb.kwejk.dao.CategoryDao;
import pl.lukaszgeb.kwejk.dao.GifDao;
import pl.lukaszgeb.kwejk.model.Category;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private GifDao gifDao;

    @GetMapping("/categories")
    public String showCategories(ModelMap modelMap) {
        modelMap.addAttribute("categories", categoryDao.showCategories());
        return "categories";
    }

    @GetMapping("/searchCategory")
    public String searchCategories(@RequestParam String q, ModelMap modelMap) {
        if ((categoryDao.searchCategory(q) == null)) {
            modelMap.addAttribute("comment", "Nie ma takiej kategorii");
        } else {
            List<Category> categories = new ArrayList<>();
            categories.add(categoryDao.searchCategory(q));
            modelMap.addAttribute("categories", categories);
        }
        return "categories";
    }

    @GetMapping("/category/{id}")
    public String showGifsFromCategory(@PathVariable int id, ModelMap modelMap) {
        modelMap.addAttribute("category",categoryDao.searchCategoryById(id));
        modelMap.addAttribute("gifs", gifDao.searchGifsFromCategory(id));
        return "category";
    }

}
