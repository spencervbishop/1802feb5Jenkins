package com.beans;

public class Department {

    int dept;
    int dh_id;
    String dept_name;
    int benco_id;


    //CONSTRUCTORS
    public Department(){}

    //USER --> DATABASE
    public Department(int dh_id, String dept_name, int benco_id) {
        this.dh_id = dh_id;
        this.dept_name = dept_name;
        this.benco_id = benco_id;
    }

    //DATABASE --> USER
    public Department(int dept, int dh_id, String dept_name, int benco_id) {
        this.dept = dept;
        this.dh_id = dh_id;
        this.dept_name = dept_name;
        this.benco_id = benco_id;
    }

    public int getDept() {
        return dept;
    }

    public void setDept(int dept) {
        this.dept = dept;
    }

    public int getDh_id() {
        return dh_id;
    }

    public void setDh_id(int dh_id) {
        this.dh_id = dh_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public int getBenco_id() {
        return benco_id;
    }

    public void setBenco_id(int benco_id) {
        this.benco_id = benco_id;
    }

    //HASHCODE TOSTRING EQUALS ETC

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
