package com.romantest.autocredit.controller;

import com.romantest.autocredit.entity.*;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/survey")
@SessionAttributes("survey")
public class SurveyController {

    @GetMapping
    public String surveyForm(){
        return "surveyForm";
    }

    @PostMapping
    public String newSurvey(@Valid Survey survey,
                            BindingResult bindingResult,
                            Errors errors){
        if(errors.hasErrors()){
            System.out.println(errors.getAllErrors().toString());
            return "surveyForm";
        }

        System.out.println(survey);
        return "redirect:/survey";
    }

    @ModelAttribute("survey")
    public Survey survey(){
        return new Survey();
    }
}
