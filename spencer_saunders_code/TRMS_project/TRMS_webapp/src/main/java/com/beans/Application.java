package com.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Application {

    int app_id;
    int emp_id;
    int event_id;
    Date event_date;
    String location;
    double cost;
    String description;
    String work_just;
    boolean ds_approved;
    boolean dh_approved;
    boolean benco_approved;
    boolean approval_email;
    int work_time_missed;
    double proj_reimb;
    boolean urgent;
    String testingVar;

    //CONSTRUCTORS


    public Application() {
    }

    //FILLED BY THE USER --> PUT IN DATABASE
    public Application(Employee emp, Event evt, Date event_date, String location, double cost, String description,
                       String work_just, //boolean ds_approved, boolean dh_approved, boolean benco_approved,
                       boolean approval_email, int work_time_missed) {
        this.event_id = evt.event_id;
        this.event_date = event_date;
        this.location = location;
        this.cost = cost;
        this.description = description;
        this.work_just = work_just;
//        this.ds_approved = ds_approved;
//        this.dh_approved = dh_approved;
//        this.benco_approved = benco_approved;
        this.approval_email = approval_email;
        this.work_time_missed = work_time_missed;

        //CALCULATES THE PROJECTED REIMBURSEMENT BASED ON THE SET REIMBURSEMENT RATE FOR
        //THE EVENT AND THE EMPLOYEE'S AVAILABLE AMOUNT
        double amount = evt.rate*cost;
        if(amount<= emp.avail_amount) {
            this.proj_reimb = evt.rate * cost;
        }else{
            this.proj_reimb = emp.avail_amount;
        }

        //SETS EVENT DATE AND CHECKS WHETHER OR NOT THE APPLICATION SHOULD BE URGENT
        setEvent_date(event_date);
    }

    //FILLED BY THE DATABASE --> SHOWN TO USER
    public Application(int app_id, int emp_id, int event_id, Date event_date, String location, double cost, String description,
                       String work_just, boolean ds_approved, boolean dh_approved, boolean benco_approved, boolean approval_email,
                       int work_time_missed, double proj_reimb, boolean urgent) {
        this.app_id = app_id;
        this.emp_id = emp_id;
        this.event_id = event_id;
        this.event_date = event_date;
        this.location = location;
        this.cost = cost;
        this.description = description;
        this.work_just = work_just;
        this.ds_approved = ds_approved;
        this.dh_approved = dh_approved;
        this.benco_approved = benco_approved;
        this.approval_email = approval_email;
        this.work_time_missed = work_time_missed;
        this.proj_reimb = proj_reimb;
        this.urgent = urgent;
    }

    //GETTERS AND SETTERS

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public int getApp_id() {
        return app_id;
    }

    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public Date getEvent_date() {
        return event_date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWork_just() {
        return work_just;
    }

    public void setWork_just(String work_just) {
        this.work_just = work_just;
    }

    public boolean isDs_approved() {
        return ds_approved;
    }

    public void setDs_approved(boolean ds_approved) {
        this.ds_approved = ds_approved;
    }

    public boolean isDh_approved() {
        return dh_approved;
    }

    public void setDh_approved(boolean dh_approved) {
        this.dh_approved = dh_approved;
    }

    public boolean isBenco_approved() {
        return benco_approved;
    }

    public void setBenco_approved(boolean benco_approved) {
        this.benco_approved = benco_approved;
    }

    public boolean isApproval_email() {
        return approval_email;
    }

    public void setApproval_email(boolean approval_email) {
        this.approval_email = approval_email;
    }

    public int getWork_time_missed() {
        return work_time_missed;
    }

    public void setWork_time_missed(int work_time_missed) {
        this.work_time_missed = work_time_missed;
    }

    public double getProj_reimb() {
        return proj_reimb;
    }

    public void setProj_reimb(double proj_reimb) {
        this.proj_reimb = proj_reimb;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

    public void setEvent_date(Date event_date) {
        //EVENT SHOULD BE MORE THAN A WEEK AWAY
        //THIS IS CHECKED IN THE CONTROL LAYER
        //SET UP A TRIGGER IN THE DATABASE
        this.event_date =event_date;

        //IF EVENT IS LESS THAN TWO WEEKS AWAY, REQUEST BECOMES URGENT
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        Date today = new Date();
        Date date = event_date;
        long daysDiff = (date.getTime()-today.getTime())/(24*60*60*1000);
        if(daysDiff<=13){
            this.urgent = true;
        }
    }

    public String getTestingVar() {
        return testingVar;
    }

    public void setTestingVar(String testingVar) {
        this.testingVar = testingVar;
    }

    //TOSTRING, EQUALS, HASHCODE, ETC

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
