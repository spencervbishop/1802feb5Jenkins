package com.controller;

import com.beans.Application;
import com.services.ApplicationService;

public class ApplicationController implements Controller {

    ApplicationService applicationService = new ApplicationService();

    public int saveApplication(Application app){
        int id = applicationService.saveApplication(app);
        return id;
    }
}
