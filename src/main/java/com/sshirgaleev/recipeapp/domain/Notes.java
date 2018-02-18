package com.sshirgaleev.recipeapp.domain;

import lombok.EqualsAndHashCode;

import javax.persistence.*;

@lombok.Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;

    @Lob
    public String recipeNotes;






}
