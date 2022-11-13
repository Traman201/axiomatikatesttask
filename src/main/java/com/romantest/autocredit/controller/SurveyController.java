package com.romantest.autocredit.controller;

import com.romantest.autocredit.entity.Survey;
import com.romantest.autocredit.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@RequestMapping("/survey")
@SessionAttributes("survey")
public class SurveyController {

    @Autowired
    SurveyService surveyService;

    @GetMapping
    public String surveyForm(){
        return "surveyForm";
    }

    @PostMapping
    public String newSurvey(@Valid Survey survey, BindingResult bindingResult,
                            Errors errors, SessionStatus sessionStatus){

        if(errors.hasErrors()){
            return "surveyForm";
        }

        surveyService.save(survey);

        sessionStatus.setComplete();
        return "redirect:/survey";
    }

    @ModelAttribute("survey")
    public Survey survey(){
        return new Survey();
    }
}
