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

    public static String getMaritalStatus(MaritalStatus m){
        switch (m){
            case SINGLE -> {
                return "Не замужем / Не женат";
            }
            case MARRIED -> {
                return "Замужем / Женат";
            }
            case DIVORCED -> {
                return "Разведен / Разведена";
            }
            case WIDOW -> {
                return "Вдовец / Вдова";
            }
            default -> {
                return "Нет данных";
            }
        }
    }
}
