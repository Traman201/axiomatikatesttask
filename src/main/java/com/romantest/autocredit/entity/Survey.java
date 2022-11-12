package com.romantest.autocredit.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Getter
@Setter
@Entity
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    Date date;

    @NotNull(message = "Укажите сумму кредита")
    @Min(value = 1, message = "Проверьте правильность написания суммы кредита")
    long amount;

    @ManyToOne
    @NotNull
    @Valid
    Client client;


    @Override
    public String toString() {
        String str = "Client " + client.getName() + " " + client.getSurname() + " " + client.getMiddleName() + "\n" +
                "Position " + client.getPosition().getOrganisation().getName() + " " + client.getPosition().getName() + "\n" +
                "Amount " + amount + "\n";
        return str;
    }
}
