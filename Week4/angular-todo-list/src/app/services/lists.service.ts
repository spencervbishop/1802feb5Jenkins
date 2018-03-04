import { Injectable } from '@angular/core';
import { HttpClient } from 'selenium-webdriver/http';
import { TodoList } from '../domain/todo-list';

@Injectable()
export class ListsService {

  private lists: TodoList[] = [
    {
      id: 1,
      title: "Palpatine due by Monday",
      items: [{ text: "Finish the Deathstar" },
      { text: "Execute all Jedi" },
      { text: "Conquer the galaxy" }]
    },
    {
      id: 2,
      title: "Test list",
      items: []
    }
  ];

  constructor() { }

  getLists(): TodoList[] {
    return this.lists;
  }

  getList(id: number): TodoList {
    return this.lists.find(l => {
      return l.id === id;
    });
  }

}