package com.controller;

import com.beans.Application;
import com.services.ApplicationService;

import java.util.ArrayList;
import java.util.List;

public class ApplicationController implements Controller {

    ApplicationService applicationService = new ApplicationService();

    public int saveApplication(Application app){
        int id = applicationService.saveApplication(app);
        return id;
    }

//    public List<Application> getAllApplications(int emp_id){
//        List<Application> allApps = new ArrayList<>();
//
//
//    }
}
