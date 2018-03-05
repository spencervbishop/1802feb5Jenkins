import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { TaskItem } from '../domain/TaskItem';
import { ListsService } from '../services/lists.service';
import { ActivatedRoute } from '@angular/router';
import { TodoList } from '../domain/todo-list';

@Component({
  selector: 'app-my-list',
  templateUrl: './my-list.component.html',
  styleUrls: ['./my-list.component.css']
})
export class MyListComponent implements OnInit {

  list: TodoList;

  selectedItems: TaskItem[] = [];

  constructor(private listService: ListsService, private route: ActivatedRoute,
    private location: Location) { }

  ngOnInit() {
    const id = +this.route.snapshot.paramMap.get('id');
    this.listService.getList(id).subscribe((data) => {
      this.list = data;
      console.log(data);
    });
  }

  // selectItem(item: TaskItem) {
  //   let find = this.selectedItems.find(i => {
  //     return i === item;
  //   });

  //   if(find) {
  //     this.deselectItem(item);
  //   } else {
  //     this.selectedItems.push(item);
  //   }

  //   console.log(this.selectedItems);
  // }

  selectItem(evt: {item: TaskItem, selected: boolean}) {
    console.log(evt);
    if(evt.selected) {
      this.selectedItems.push(evt.item);
    } else {
      this.deselectItem(evt.item);
    }
  }

  isSelected(item): boolean {
    const r = this.selectedItems.find(i => {
      return i === item;
    });

    return (r) ? true : false;
  }

  private deselectItem(item: {}) {
    let i = this.selectedItems.findIndex(i => {
      return i === item;
    });

    if(i >= 0) {
      this.selectedItems.splice(i, 1);
    }
  }

  deleteItems() {
    while(this.selectedItems.length > 0) {
      const elem = this.selectedItems.shift();
      const index = this.list.items.findIndex(i => {
        return i.value === elem.value;
      });
      this.list.items.splice(index, 1);
    }
  }

  newTask(task) {
    this.list.items.push(task);
    this.listService.updateList(this.list).subscribe((data) => {
    });
  }

  goBack() {
    this.location.back();
  }
}
