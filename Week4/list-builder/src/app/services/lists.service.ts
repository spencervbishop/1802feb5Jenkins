import { Injectable } from '@angular/core';
import { TodoList } from '../domain/todo-list';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { catchError } from 'rxjs/operators'
import { of } from 'rxjs/observable/of';

@Injectable()
export class ListsService {

  constructor(private http: HttpClient) { 

  }

  getLists(): Observable<TodoList[]>{

    return this.http.get<TodoList[]>("http://localhost:8080/app/api/lists")
    .pipe(catchError(this.handleError([])));
  }

  getList(id: number): Observable<TodoList> {
    return this.http.get<TodoList>(`http://localhost:8080/app/api/lists/list?id=${id}`);
  }

  updateList(list: TodoList): Observable<any> {
    return this.http.put("http://localhost:8080/app/api/lists/update", list);
  }

  private handleError<T>(result: T) {
    return (error: any): Observable<T> => {
      console.log("An error has occurred while retrieving data");
      return of(result as T);
    }
  }
}
