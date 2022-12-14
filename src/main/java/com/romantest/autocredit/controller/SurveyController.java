package com.romantest.autocredit.controller;

import com.romantest.autocredit.entity.Client;
import com.romantest.autocredit.entity.Survey;
import com.romantest.autocredit.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/client")
    public String clientForm(Model model, @SessionAttribute("survey") Survey survey){
        model.addAttribute("newClient", surveyService.getClientDAO().getById(survey.getClient().getPassportNumber()));
        return "duplicateClientForm";
    }

    @PostMapping("/client")
    public String updateClient(@RequestParam(defaultValue = "off", required = false) boolean update, @SessionAttribute("survey") Survey survey, SessionStatus sessionStatus){
        if(!update){
            survey.setClient(surveyService.getClientDAO().getById(survey.getClient().getPassportNumber()));
        }
        surveyService.save(survey);

        sessionStatus.setComplete();

        return "redirect:/survey";


    }

    @PostMapping
    public String newSurvey(@Valid Survey survey, BindingResult bindingResult,
                            Errors errors, SessionStatus sessionStatus){

        if(errors.hasErrors()){
            System.out.println(errors.getAllErrors());
            return "surveyForm";
        }
        Client tmp;
        if((tmp = surveyService.getClientDAO().getById(survey.getClient().getPassportNumber())) != null && !tmp.equals(survey.getClient())){
            return "redirect:/survey/client";
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
