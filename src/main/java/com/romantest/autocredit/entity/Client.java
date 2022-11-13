package com.romantest.autocredit.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table(name = "client")
public class Client {
    @NotBlank(message = "Укажите имя")
    @Size(min = 2, message = "Имя должно состоять как минимум из двух букв")
    String name;

    @NotBlank(message = "Укажите фамилию")
    @Size(min = 2, message = "Фамилия должна состоять как минимум из двух букв")
    String surname;

    boolean noMiddleName = false;

    String middleName;

    @Pattern(regexp = "\\d{4}", message = "Серия паспорта должна состоять из 4 цифр")
    String passportSeries;

    @Id
    @Pattern(regexp = "\\d{6}", message = "Номер паспорта должен состоять из 6 цифр")
    String passportNumber;

    @Pattern(regexp = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$", message = "Проверьте правильность указанной даты")
    String issueDate;

    @NotBlank(message = "Укажите подразделение, которое выдало паспорт")
    @Size(min = 5, message = "Проверьте правильность написания подразделения выдачи паспорта")
    String issueDepartment;

    @NotNull(message = "Укажите Ваше семейное положение")
    @Enumerated(EnumType.ORDINAL)
    @Valid
    MaritalStatus maritalStatus;


    @Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$", message = "Укажите номер телефона")
    String phoneNumber;

    @ManyToOne
    @NotNull
    @Valid
    Registration registration;

    @OneToOne
    @Valid
    Position position;

    @Pattern(regexp = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$", message = "Проверьте правильность указанной даты")
    String hireDate;


    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() != Client.class){
            return false;
        }
        Client client = (Client) obj;
        return client.getName().equals(this.name) &&
                client.getSurname().equals((this.surname)) &&
                client.getMiddleName().equals(this.middleName) &&
                client.getPassportSeries().equals(this.passportSeries) &&
                client.getPassportNumber().equals(this.passportNumber) &&
                client.getIssueDate().equals((this.issueDate)) &&
                client.getIssueDepartment().equals(this.issueDepartment) &&
                client.getMaritalStatus().equals(this.maritalStatus) &&
                client.getPhoneNumber().equals(this.phoneNumber) &&
                client.getRegistration().equals(this.registration) &&
                client.getPosition().equals(this.position) &&
                client.hireDate.equals(this.hireDate);
    }
}
