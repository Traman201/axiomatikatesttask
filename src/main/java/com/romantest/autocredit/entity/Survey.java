package com.romantest.autocredit.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "survey")
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    String date;

    @NotNull(message = "Укажите сумму кредита")
    @Min(value = 1, message = "Проверьте правильность написания суммы кредита")
    long amount;

    @ManyToOne
    @NotNull
    @Valid
    Client client;

    @OneToOne
    Agreement agreement;


    @Override
    public String toString() {
        return "Client " + client.getName() + " " + client.getSurname() + " " + client.getMiddleName() + "\n" +
                "Position " + client.getPosition().getOrganisation().getName() + " " + client.getPosition().getName() + "\n" +
                "Amount " + amount + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || obj.getClass() != Survey.class){
            return false;
        }
        Survey s = (Survey) obj;
        return s.getId() == this.id &&
                s.getDate().equals(this.date) &&
                s.getAmount() == this.amount &&
                s.getClient().equals(this.client) &&
                s.getAgreement().equals(this.agreement);
    }
}
