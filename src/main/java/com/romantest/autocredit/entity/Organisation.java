package com.romantest.autocredit.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table(name = "organisation")
public class Organisation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;

    @NotBlank(message = "Укажите название организации")
    @Size(min = 3, message = "Название организации должно состоять как минимум из 3 букв")
    @Column(name = "name")
    String name;

}
