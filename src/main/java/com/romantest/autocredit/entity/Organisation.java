package com.romantest.autocredit.entity;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table(name = "organisation")
public class Organisation {

    @Id
    @NotBlank(message = "Укажите название организации")
    @Size(min = 3, message = "Название организации должно состоять как минимум из 3 букв")
    String name;
}
