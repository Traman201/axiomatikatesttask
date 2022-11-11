package com.romantest.autocredit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/survey")
public class SurveyController {

    @GetMapping
    public String surveyForm(){
        return "survey";
    }
}
