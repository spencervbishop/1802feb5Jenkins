package com.beans;

public class Event {
    //enter all the constant "rates"
    int event_id;
    double rate;
    String event_type;
    String grading_format;
    String testingVar;

    //CONSTRUCTORS

    public Event(){}

    //DATABASE --> USER
    public Event(int event_id, double rate, String grading_format, String event_type) {
        this.event_id = event_id;
        this.rate = rate;
        this.grading_format = grading_format;
        this.event_type = event_type;
    }

    //USER --> DATABASE
    public Event(double rate, String grading_format, String event_type){
        this.rate=rate;
        this.grading_format=grading_format;
        this.event_type = event_type;
    }

    //GETTERS AND SETTERS

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getEvent_type() {
        return event_type;
    }

    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }

    public String getGrading_format() {
        return grading_format;
    }

    public void setGrading_format(String grading_format) {
        this.grading_format = grading_format;
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
