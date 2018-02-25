package com.sshirgaleev.recipeapp.repositories;

import com.sshirgaleev.recipeapp.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import java.util.Optional;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryTest {
    @Autowired
    UnitOfMeasureRepository unit;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByDescription() {
        Optional<UnitOfMeasure> uomOptional = unit.findByDescription("Teaspoon");
        assertEquals("Teaspoon", uomOptional.get().getDescription());
    }

    @Test
    public void findByDescriptionCup() {
        Optional<UnitOfMeasure> uomOptional = unit.findByDescription("Cup");
        assertEquals("Cup", uomOptional.get().getDescription());
    }
}