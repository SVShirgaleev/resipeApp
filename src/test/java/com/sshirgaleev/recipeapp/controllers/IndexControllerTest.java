package com.sshirgaleev.recipeapp.controllers;

import com.sshirgaleev.recipeapp.Services.RecipeService;
import com.sshirgaleev.recipeapp.Services.RecipeServiceImpl;
import com.sshirgaleev.recipeapp.domain.Recipe;
import com.sshirgaleev.recipeapp.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class IndexControllerTest {
    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    IndexController controller;


    @Before
    public void setUp()throws Exception{
        MockitoAnnotations.initMocks(this);
        controller = new IndexController(recipeService);
    }

    @Test
    public void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index"));
    }

    @Test
    public void getIndexPage() {
        //given
        Set<Recipe> recipeSet = new HashSet<>();
        recipeSet.add(new Recipe());

        Recipe recipe = new Recipe();
        recipe.setId(1L);

        recipeSet.add(recipe);
        when(recipeService.getRecipes()).thenReturn(recipeSet);

        ArgumentCaptor<Set<Recipe>> argumentCaptor =ArgumentCaptor.forClass(Set.class);

        String viewName = controller.getIndexPage(model);

        assertEquals("index", viewName);
        verify(recipeService,times(1)).getRecipes();
        verify(model,times(1)).addAttribute(eq("recipes"), argumentCaptor);
        Set<Recipe> setInCController = argumentCaptor.getValue();
        assertEquals(2,setInCController.size());
    }
}