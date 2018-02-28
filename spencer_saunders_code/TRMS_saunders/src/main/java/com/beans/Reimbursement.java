package com.beans;

import java.util.Date;

public class Reimbursement extends Application {

    int reimbursement_id;
    int application_id;
    int employee_id;
    double amount_awarded;
    String testingVar;

    //CONSTRUCTORS
    public Reimbursement(){}

    //USER --> DATABASE
    public Reimbursement(Application app, double award){ //app must already be in the database
        this.application_id = app.app_id;
        this.employee_id = app.emp_id;
        this.amount_awarded = award;
    }


    //DATABASE --> USER
    public Reimbursement(int reimbursement_id, int application_id, int employee_id, double amount_awarded) {
        this.reimbursement_id = reimbursement_id;
        this.application_id = application_id;
        this.employee_id = employee_id;
        this.amount_awarded = amount_awarded;
    }

    //GETTERS AND SETTERS

    public int getReimbursement_id() {
        return reimbursement_id;
    }

    public void setReimbursement_id(int reimbursement_id) {
        this.reimbursement_id = reimbursement_id;
    }

    public int getApplication_id() {
        return application_id;
    }

    public void setApplication_id(int application_id) {
        this.application_id = application_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public double getAmount_awarded() {
        return amount_awarded;
    }

    public void setAmount_awarded(double amount_awarded) {
        this.amount_awarded = amount_awarded;
    }

    @Override
    public String getTestingVar() {
        return testingVar;
    }

    @Override
    public void setTestingVar(String testingVar) {
        this.testingVar = testingVar;
    }

    //TOSTRING HASHCODE EQUALS ETC

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
