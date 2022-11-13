package com.romantest.autocredit.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

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

    @Size(min = 1, message = "Проверьте правильность указания номера дома")
    String building;

    String apartment;

    boolean notApartment = false;

    @Override
    public boolean equals(Object obj) {
        if(obj == null || obj.getClass() != Registration.class){
            return false;
        }
        Registration r = (Registration) obj;
        return r.getId() == this.id &&
                r.getCity().equals(this.city) &&
                r.getCountry().equals(this.country) &&
                r.getStreet().equals(this.street) &&
                Objects.equals(r.getBuilding(), this.building) &&
                Objects.equals(r.getApartment(), this.apartment) &&
                r.isNotApartment() == this.notApartment;
    }
}
