package com.romantest.autocredit.controller;

import com.itextpdf.text.pdf.qrcode.Mode;
import com.romantest.autocredit.entity.Survey;
import com.romantest.autocredit.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;

@Controller
@RequestMapping("/request")
public class RequestController {

    @Autowired
    SurveyService surveyService;

    @GetMapping
    public String requestsListForm(Model model){
        model.addAttribute("requests", surveyService.getSurveyDAO().getAll());
        return "requestsListForm";
    }

    @GetMapping("/download")
    @ResponseBody
    public void downloadFile(@RequestParam int id, HttpServletResponse response) {
        String path = surveyService.getSurveyDAO().getById(id).getAgreement().getDocumentPath();

        try {
            response.setContentType("application/pdf");
            String headerKey = "Content-Disposition";
            String headerValue = String.format("attachment; filename=\"%s\"", path.replace("src_main_resources_documents_", ""));
            response.setHeader(headerKey, headerValue);
            FileInputStream inputStream;
                inputStream = new FileInputStream(path);
                try {
                    inputStream = new FileInputStream(path);
                    int c;
                    while ((c = inputStream.read()) != -1) {
                        response.getWriter().write(c);
                    }
                } finally {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    response.getWriter().close();
                }
            } catch (IOException e) {
                e.printStackTrace();

            }
    }

    @GetMapping("/{id}")
    public String detailRequestForm(@PathVariable int id, Model model){
        model.addAttribute("request", surveyService.getSurveyDAO().getById(id));
        return "detailRequestForm";
    }

    @PostMapping("/change")
    public @ResponseBody boolean toggleAgreementSign(@RequestParam int id){
        Survey survey = surveyService.getSurveyDAO().getById(id);
        survey.getAgreement().setSigned(!survey.getAgreement().isSigned());
        surveyService.getAgreementDAO().save(survey.getAgreement());
        return survey.getAgreement().isSigned();
    }
}
