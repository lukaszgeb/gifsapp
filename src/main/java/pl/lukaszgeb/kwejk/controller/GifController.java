package pl.lukaszgeb.kwejk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.lukaszgeb.kwejk.dao.GifDao;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GifController {

    @Autowired
    private GifDao gifDao;

    @GetMapping("/")
    public String showAll(ModelMap modelMap) {
        modelMap.addAttribute("gif", gifDao.findAll());
        return "home";
    }

    @GetMapping("/gif/{name}")
    public String details(@PathVariable String name, ModelMap modelMap) {
        modelMap.addAttribute("gif", gifDao.findOne(name));
        return "gif-details";
    }

    @GetMapping("/search")
    public String searchResult(@RequestParam String q, ModelMap modelMap){
        modelMap.addAttribute("gif",gifDao.findOne(q));
        if (gifDao.findOne(q)==null)
            modelMap.addAttribute("comment","Nie ma takiego gifa!");
        return "home";
    }

    @GetMapping("/favorites")
    public String home(ModelMap modelMap) {
        modelMap.addAttribute("gifs",gifDao.getFavorites());
        return "favorites";
    }

}
