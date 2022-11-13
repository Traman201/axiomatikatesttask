package com.romantest.autocredit.entity;

import com.romantest.autocredit.service.StringToMaritalStatusConverter;

public enum MaritalStatus {
    SINGLE("1"),
    MARRIED("2"),
    DIVORCED("3"),
    WIDOW("4");

    private final String status;

    MaritalStatus(String status) {
        this.status = status;
    }

    public String getStatus(){
        return status;
    }

    public String convertStatus(){
        return StringToMaritalStatusConverter.getMaritalStatus(this);
    }
}
