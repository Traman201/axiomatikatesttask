package com.romantest.autocredit.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.romantest.autocredit.dao.*;
import com.romantest.autocredit.entity.Agreement;
import com.romantest.autocredit.entity.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Random;

@Service
public class SurveyService {

    @Autowired
    Font font;

    Random random;

    @Autowired
    ClientDAO clientDAO;

    @Autowired
    OrganisationDAO organisationDAO;

    @Autowired
    PositionDAO positionDAO;

    @Autowired
    RegistrationDAO registrationDAO;

    @Autowired
    SurveyDAO surveyDAO;

    @Autowired
    AgreementDAO agreementDAO;

    public SurveyService(){
        random = new Random();
    }
    public void save(Survey survey){
        organisationDAO.save(survey.getClient().getPosition().getOrganisation());
        positionDAO.save(survey.getClient().getPosition());
        registrationDAO.save(survey.getClient().getRegistration());
        clientDAO.save(survey.getClient());

        survey.setAgreement(approve(survey));
        agreementDAO.save(survey.getAgreement());

        surveyDAO.save(survey);

    }

    Agreement approve(Survey survey){
        Agreement agreement = new Agreement();
        agreement.setApproved(random.nextBoolean());
        agreement.setSigned(false);
        if(agreement.isApproved()){
            agreement.setDocumentPath(generateContract(survey));
        }
        return agreement;
    }

    String generateContract(Survey survey){
        Document doc = new Document();
        String path = "src/main/resources/documents/" + survey.getId() + "_agreement_" + survey.getDate() + ".pdf";
        try{

            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(path));

            doc.open();

            doc.add(new Paragraph(
                    "Соглашение о кредитовании", font));

            doc.add(new Paragraph(
                    "ФИО заявителя: " + survey.getClient().getSurname() + " "
                    + survey.getClient().getName() + " "
                    + (survey.getClient().isNoMiddleName() ? "" : survey.getClient().getMiddleName()),
                    font
            ));

            doc.add(new Paragraph(
                    "Паспотрные данные заявителя: " + "Серия: " + survey.getClient().getPassportSeries() + " "
                    + "Номер: " + survey.getClient().getPassportNumber(),
                    font
            ));

            doc.add(new Paragraph(
                    "Семейное положение: " + survey.getClient().getMaritalStatus().getStatus(),
                    font
            ));

            doc.add(new Paragraph(
                    "Адрес прописки заявителя: " + survey.getClient().getRegistration().getCountry() + ", "
                    + survey.getClient().getRegistration().getCity() + ", "
                    + survey.getClient().getRegistration().getStreet() + ", "
                    + survey.getClient().getRegistration().getBuilding()
                    + (survey.getClient().getRegistration().isNotApartment() ? "" : survey.getClient().getRegistration().getApartment()),
                    font
            ));

            doc.add(new Paragraph(
                    "Контактный телефон: " + survey.getClient().getPhoneNumber(),
                    font
            ));

            doc.add(new Paragraph(
                    "Сведения о занятости: " + survey.getClient().getPosition().getName() + ", "
                    + survey.getClient().getPosition().getOrganisation().getName() + ", "
                    + survey.getClient().getHireDate(),
                    font
            ));

            doc.add(new Paragraph(
                    "Заявленная сумма кредита: " + survey.getAmount() + "руб.",
                    font
            ));


            doc.add(new Paragraph(
               "Дата подписания: " + survey.getDate()
                    + "\nПодпись _________ " + survey.getClient().getSurname()
                    + " " + survey.getClient().getName().charAt(0) + ". "
                    + (survey.getClient().isNoMiddleName() ? "" : survey.getClient().getMiddleName().charAt(0) + "."),
                    font
            ));

            doc.close();

            writer.close();
        }
        catch (DocumentException | FileNotFoundException e){
            System.out.println("Ошибка при создании документа договора");
            return null;
        }
        return path;
    }

}
