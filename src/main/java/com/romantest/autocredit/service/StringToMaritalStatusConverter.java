package com.romantest.autocredit.service;

import com.romantest.autocredit.entity.MaritalStatus;
import org.springframework.core.convert.converter.Converter;


public class StringToMaritalStatusConverter implements Converter<String, MaritalStatus> {


    @Override
    public MaritalStatus convert(String source) {
        for(MaritalStatus maritalStatus : MaritalStatus.values()){
            if(source.equals(maritalStatus.getStatus())){
                return maritalStatus;
            }
        }
        return null;
    }
}
