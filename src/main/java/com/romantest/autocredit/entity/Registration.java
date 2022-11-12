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

    @NotBlank(message = "Укажите улицу проживания")
    @Size(min = 2, message = "Название улицы проживания должно состоять как минимум из 2 букв")
    String street;

    @NotBlank(message = "Укажите номер дома")
    @Min(value = 1, message = "Проверьте правильность указания номера дома")
    String building;

    String apartment;

    boolean notApartment = false;
}
