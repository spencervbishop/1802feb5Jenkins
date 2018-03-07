package com.beans;

public class BenCo extends Supervisor {

    int emp_id;
    EmployeeType title = EmployeeType.BENCO;

    //CONSTRUCTORS
    public BenCo(){}

    public BenCo(int emp_id, EmployeeType title) {
        this.emp_id = emp_id;
        this.title = title;
    }

    //GETTERS AND SETTERS
    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public EmployeeType getTitle() {
        return title;
    }

    public void setTitle(EmployeeType title) {
        this.title = title;
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
