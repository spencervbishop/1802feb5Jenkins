package com.beans;

public class Department {

    int dept;
    int dh_id;
    String dept_name;
    String testingVar;


    //CONSTRUCTORS
    public Department(){}

    //USER --> DATABASE
    public Department(int dh_id, String dept_name) {
        this.dh_id = dh_id;
        this.dept_name = dept_name;
    }
    public Department(String dept_name) {
        this.dept_name = dept_name;
    }

    //DATABASE --> USER
    public Department(int dept, int dh_id, String dept_name) {
        this.dept = dept;
        this.dh_id = dh_id;
        this.dept_name = dept_name;
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

    public String getTestingVar() {
        return testingVar;
    }

    public void setTestingVar(String testingVar) {
        this.testingVar = testingVar;
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
