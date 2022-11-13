package com.romantest.autocredit.service;

import com.romantest.autocredit.dao.*;
import com.romantest.autocredit.entity.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyService {

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

    public void save(Survey survey){
        organisationDAO.save(survey.getClient().getPosition().getOrganisation());
        positionDAO.save(survey.getClient().getPosition());
        registrationDAO.save(survey.getClient().getRegistration());
        clientDAO.save(survey.getClient());
        surveyDAO.save(survey);
    }
}
