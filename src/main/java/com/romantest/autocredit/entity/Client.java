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

    @NotBlank(message = "Укажите серию паспорта")
    @Pattern(regexp = "\\d{4}", message = "Серия паспорта должна состоять из 4 цифр")
    String passportSeries;

    @Id
    @NotBlank(message = "Укажите номер паспорта")
    @Pattern(regexp = "\\d{6}", message = "Номер паспорта должен состоять из 6 цифр")
    String passportNumber;

    @NotBlank(message = "Укажите дату выдачи паспорта")
    @Pattern(regexp = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$", message = "Проверьте правильность указанной даты")
    String issueDate;

    @NotBlank(message = "Укажите подразделение, которое выдало паспорт")
    @Size(min = 5, message = "Проверьте правильность написания подразделения выдачи паспорта")
    String issueDepartment;

    @NotNull(message = "Укажите Ваше семейное положение")
    @Enumerated(EnumType.ORDINAL)
    @Valid
    MaritalStatus maritalStatus;

    @NotBlank
    @Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$", message = "Укажите номер телефона")
    String phoneNumber;

    @ManyToOne
    @NotNull
    @Valid
    Registration registration;

    @OneToOne
    @Valid
    Position position;

    @NotBlank(message = "Укажите дату выхода на работу")
    @Pattern(regexp = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$", message = "Проверьте правильность указанной даты")
    String hireDate;




}
