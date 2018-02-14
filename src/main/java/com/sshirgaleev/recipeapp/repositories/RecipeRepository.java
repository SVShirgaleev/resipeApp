package com.sshirgaleev.recipeapp.repositories;

import com.sshirgaleev.recipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
