package com.romantest.autocredit.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Agreement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    boolean isApproved;
    int days;

    boolean isSigned;

    String documentPath;

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() != Agreement.class){
            return false;
        }
        Agreement a = (Agreement) obj;
        return a.getId() == this.id &&
                a.getDocumentPath().equals(this.documentPath) &&
                a.isApproved() == this.isApproved &&
                a.isSigned() == this.isSigned;
    }
}
