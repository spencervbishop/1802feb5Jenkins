package com.ex.web.controller;

import com.ex.data.dao.ListDao;
import com.ex.data.impl.ListDaoImpl;
import com.ex.domain.TodoList;
import com.ex.web.Controller;

import java.util.List;

public class ListDataController implements Controller {
    ListDao ld = new ListDaoImpl();

    public List<TodoList> getAllLists() {
        return (List<TodoList>)ld.getAll();
    }

    public TodoList getOneList(int id){
        return ld.getOne(id);
    }

    public int updateList(TodoList list) {
        return ld.updateList(list);
    }
 }
