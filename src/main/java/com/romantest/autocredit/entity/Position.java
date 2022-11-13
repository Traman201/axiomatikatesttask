package com.romantest.autocredit.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table(name = "position")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @NotBlank(message = "Укажите наименование должности")
    @Size(min = 5, message = "Название должности должно состоять как минимум из пяти букв")
    String name;


    @OneToOne(targetEntity = Organisation.class)
    @Valid
    Organisation organisation;
}


