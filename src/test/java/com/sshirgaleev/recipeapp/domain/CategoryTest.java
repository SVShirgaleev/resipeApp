package com.sshirgaleev.recipeapp.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CategoryTest {
    Category category;

    @Before
    public void setUp() {
        category = new Category();
        category.setId(5L);
        category.setDescription("description");
    }

    @Test
    public void getId() throws Exception{
        Long idValue = 5L;
        assertEquals(idValue, category.getId());
    }

    @Test
    public void getDescription() throws Exception{
        String description = "description";
        assertEquals(description,category.getDescription());
    }

}
