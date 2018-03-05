package com.ex.data.dao;

import com.ex.domain.TodoList;

import java.util.Collection;

public interface ListDao {
    Collection<TodoList> getAll();
    TodoList getOne(int id);
    int updateList(TodoList list);
}
