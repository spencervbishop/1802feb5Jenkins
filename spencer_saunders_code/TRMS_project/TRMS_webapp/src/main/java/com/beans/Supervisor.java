package com.beans;

public class Supervisor extends Employee {  //INCLUDES DS AND DH EMPLOYEES

    int emp_id;
    String first_name;
    String last_name;
    String username;
    String password;
    EmployeeType title;
    private int benco_id;
    //    private int dh_id;
    int department;
    double avail_amount;

    //CONSTRUCTORS

    public Supervisor() {}
    public Supervisor(String first_name, String last_name, String username, String password, int benco_id,
                      EmployeeType e, int department, double avail_amount, int emp_id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.password = password;
        this.benco_id = benco_id;
        this.title = e;
        this.department = department;
        this.avail_amount = avail_amount;
        this.emp_id = emp_id;
    }


    //GETTERS AND SETTERS


    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int getEmp_id() {
        return emp_id;
    }

    @Override
    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    @Override
    public String getFirst_name() {
        return first_name;
    }

    @Override
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    @Override
    public String getLast_name() {
        return last_name;
    }

    @Override
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public EmployeeType getTitle() {
        return title;
    }

    @Override
    public void setTitle(EmployeeType title) {
        this.title = title;
    }

    @Override
    public int getBenco_id() {
        return benco_id;
    }

    @Override
    public void setBenco_id(int benco_id) {
        this.benco_id = benco_id;
    }

    @Override
    public int getDepartment() {
        return department;
    }

    @Override
    public void setDepartment(int department) {
        this.department = department;
    }

    @Override
    public double getAvail_amount() {
        return avail_amount;
    }

    @Override
    public void setAvail_amount(double avail_amount) {
        this.avail_amount = avail_amount;
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
