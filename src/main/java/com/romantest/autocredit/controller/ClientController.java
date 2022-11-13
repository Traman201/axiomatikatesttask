package com.romantest.autocredit.controller;

import com.romantest.autocredit.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    SurveyService surveyService;

    @GetMapping
    public String clientListForm(
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "") String surname,
            @RequestParam(required = false, defaultValue = "") String middleName,
            @RequestParam(required = false, defaultValue = "") String passportSeries,
            @RequestParam(required = false, defaultValue = "") String passportNumber,
            @RequestParam(required = false, defaultValue = "") String phoneNumber,
            Model model){
        Map<String, String> filters = new HashMap<>();
        filters.put("name", name);
        filters.put("surname", surname);
        filters.put("middleName", middleName);
        filters.put("passportSeries", passportSeries);
        filters.put("passportNumber", passportNumber);
        filters.put("phoneNumber", phoneNumber);
        model.addAttribute("clients", surveyService.getClientDAO().getWithFilter(filters));
        return "clientListForm";
    }
}
