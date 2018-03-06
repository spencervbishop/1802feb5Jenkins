import { Component, OnInit } from '@angular/core';
import { ListsService } from '../services/lists.service';
import { TodoList } from '../domain/todo-list';

@Component({
  selector: 'app-list-dir',
  templateUrl: './list-dir.component.html',
  styleUrls: ['./list-dir.component.css']
})
export class ListDirComponent implements OnInit {

  lists: TodoList[] = [];

  constructor(private listService: ListsService) { 
  }

  ngOnInit() {
    this.listService.getLists().subscribe((data) =>{
      this.lists = data;
    });
  }

}
