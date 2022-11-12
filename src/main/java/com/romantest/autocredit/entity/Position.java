package com.romantest.autocredit.entity;

import lombok.AllArgsConstructor;
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
@IdClass(PositionId.class)
public class Position {

    @Id
    @NotBlank(message = "Укажите наименование должности")
    @Size(min = 5, message = "Название должности должно состоять как минимум из пяти букв")
    String name;

    @Id
    @OneToOne
    @Valid
    Organisation organisation;
}


@Getter
@Setter
@AllArgsConstructor
class PositionId{
    String name;
    Organisation organisation;
}
