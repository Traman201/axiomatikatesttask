package com.romantest.autocredit.entity;

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
}
