import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { TaskItem } from '../domain/TaskItem';


@Component({
  selector: 'app-new-item',
  templateUrl: './new-item.component.html',
  styleUrls: ['./new-item.component.css']
})
export class NewItemComponent implements OnInit {

  item: TaskItem = new TaskItem();
  @Output() addNewTask = new EventEmitter<TaskItem>()

  constructor() { }

  ngOnInit() {
  }

  keyPress(evt) {
    if(evt.keyCode === 13) {
      this.addNewTask.emit(this.item);
      this.item = new TaskItem();
    }
  }

}
