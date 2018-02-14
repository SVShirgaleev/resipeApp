package com.sshirgaleev.recipeapp.controllers;

import com.sshirgaleev.recipeapp.Services.RecipeService;
import com.sshirgaleev.recipeapp.domain.Category;
import com.sshirgaleev.recipeapp.domain.UnitOfMeasure;
import com.sshirgaleev.recipeapp.repositories.CategoryRepository;
import com.sshirgaleev.recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){

        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
