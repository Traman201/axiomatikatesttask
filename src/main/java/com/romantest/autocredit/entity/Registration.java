package com.romantest.autocredit.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table(name = "registration")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @NotBlank(message = "Укажите страну проживания")
    @Size(min = 3, message = "Название страны проживания должно состоять как минимум из 3 букв")
    String country;


    @NotBlank(message = "Укажите город проживания")
    @Size(min = 3, message = "Название города проживания должно состоять как минимум из 3 букв")
    String city;

    @Size(min = 2, message = "Название улицы проживания должно состоять как минимум из 2 букв")
    String street;

    @Min(value = 1, message = "Проверьте правильность указания номера дома")
    long building;

    long apartment;

    boolean notApartment = false;
}
