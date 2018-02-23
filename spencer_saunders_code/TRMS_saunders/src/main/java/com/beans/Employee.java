package com.beans;

import static com.beans.EmployeeType.*;

public class Employee {

    int emp_id;
    String first_name;
    String last_name;
    String username;
    String password;
    EmployeeType title;
    private int super_id;
    private int benco_id;
//    private int dh_id;
    int department;
    double avail_amount;
//    double pending_amount;
//    double awarded_amount;


    //CONSTRUCTORS
    public Employee(){
    };

    //USER --> DATABASE
    public Employee(String fname, String lname, String uname, String pass, int ds, int dept, double amount){
        first_name = fname;
        last_name = lname;
        username = uname;
        password = pass; //HASH THIS
        super_id = ds;
        department = dept;
        avail_amount = amount;
    }
    //DATABASE --> USER
    public Employee(int emp_id, String fname, String lname, String username, String password, int ds,
                    int benco, boolean isDs, boolean isDh, boolean isBenco, int dept, double amount){

        this.emp_id = emp_id;
        first_name = fname;
        last_name = lname;
        this.username = username;
        this.password = password;
        super_id = ds;
        benco_id = benco;
        department = dept;
        avail_amount = amount;
        if(isDs){
            title = EmployeeType.DIRECT_SUPERVISOR;
        }else if(isDh){
            title = EmployeeType.DEPT_HEAD;
        }else if(isBenco){
            title = EmployeeType.BENCO;
        }else{
            title = EmployeeType.EMPLOYEE;
        }
    }

    //GETTERS AND SETTERS

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public EmployeeType getTitle() {
        return title;
    }

    public void setTitle(EmployeeType title) {
        this.title = title;
    }

    public int getSuper_id() {
        return super_id;
    }

    public void setSuper_id(int super_id) {
        this.super_id = super_id;
    }

    public int getBenco_id() {
        return benco_id;
    }

    public void setBenco_id(int benco_id) {
        this.benco_id = benco_id;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public double getAvail_amount() {
        return avail_amount;
    }

    public void setAvail_amount(double avail_amount) {
        this.avail_amount = avail_amount;
    }

    //TOSTRING, HASHCODE, EQUALS, ETC

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
