package com.dao;

import com.beans.Application;

import java.util.List;

public interface ApplicationDao {

    public Application getApplication(int app_id);

    public List<Application> getApplicationsOfEmployee(int emp_id);

    public int saveApplication(Application app);

    public int updateApplication(int app_id, Application app);

    public void deleteApplication(int app_id);

    public void approveApplication(int app_id);
}
