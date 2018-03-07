package com.services;

import com.beans.Application;
import com.dao.ApplicationJDBC;
import com.util.ConnectionUtil;

public class ApplicationService {
    ApplicationJDBC dao;

    public ApplicationService(ConnectionUtil cu){
        dao = new ApplicationJDBC(cu);
    }

    public ApplicationService(){
        dao = new ApplicationJDBC();
    }

    public int saveApplication(Application app){
        int id = dao.saveApplication(app);
        return id;
    }

    public Application getApplication(int app_id){
        Application app = dao.getApplication(app_id);
        app.setTestingVar("service tested");
        return app;
    }

    public int updateApplicationInfo(int id, Application app){
        int rows = dao.updateApplication(id, app);
        return rows;
    }

    public void deleteApplication(int id){

    }


}
