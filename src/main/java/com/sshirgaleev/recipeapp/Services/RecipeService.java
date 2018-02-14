package com.sshirgaleev.recipeapp.Services;

import com.sshirgaleev.recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
