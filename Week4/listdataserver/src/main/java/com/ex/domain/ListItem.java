package com.ex.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ListItem {

    private int id;
    private String value;
    private boolean complete;

    @JsonIgnore
    private TodoList list;

    public ListItem() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public TodoList getList() {
        return list;
    }

    public void setList(TodoList list) {
        this.list = list;
    }
}
