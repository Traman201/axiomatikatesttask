package com.romantest.autocredit.controller;

import com.romantest.autocredit.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/agreement")
public class AgreementController {

    @Autowired
    SurveyService surveyService;

   /* @GetMapping
    public String agreementListForm(Model model){
        model.addAttribute("agreements", surveyService.getAgreementDAO().getAll());
        return "agreementListForm";
    }*/

    @GetMapping
    public String agreementListFormSignedOnly(@RequestParam(required = false, defaultValue = "off") boolean signedOnly, Model model){
        if(signedOnly){
            model.addAttribute("agreements", surveyService.getAgreementDAO().getSignedOnly());
        }
        else{
            model.addAttribute("agreements", surveyService.getAgreementDAO().getAll());
        }
        model.addAttribute("signedOnly", signedOnly);
        return "agreementListForm";
    }

    @GetMapping("/{id}")
    public String requestRedirect(@PathVariable int id){
        int surveyId = surveyService.getSurveyDAO().getByAgreementId(id).getId();

        return "redirect:/request/" + surveyId;

    }
}
