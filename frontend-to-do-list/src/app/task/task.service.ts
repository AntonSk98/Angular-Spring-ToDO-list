import { Injectable } from '@angular/core';
import {Observable, throwError} from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Task } from './task';
import {catchError, tap} from 'rxjs/operators';
import {RequestOptions} from '@angular/http';
@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private httpService: HttpClient) { }

  private static handleError(error: Response) {
    return throwError(error);
  }

  getAllTasks() {
    return this.httpService.get('http://localhost:8081/backend_to_do_list_war/api/tasks')
      .pipe(catchError(TaskService.handleError));
  }

  addOrEditTaskResolver(task: Task) {
    console.log(task);
    if (task.id) {
      return this.updateTask(task);
    } else {
      return this.addTask(task);
    }
  }

  addTask(task: Task) {
    return this.httpService.post('http://localhost:8081/backend_to_do_list_war/api/save/task', task, {responseType: 'text'})
      .pipe(catchError(TaskService.handleError));
  }

  deleteTask(id: number) {
    return this.httpService.delete(`http://localhost:8081/backend_to_do_list_war/api/task/${id}`, {responseType: 'text'})
      .pipe(catchError(TaskService.handleError));
  }

  getTaskById(id: number) {
    return this.httpService.get(`http://localhost:8081/backend_to_do_list_war/api/task/${id}`)
      .pipe(catchError(TaskService.handleError));
  }

  updateTask(task: Task) {
    return this.httpService.put(`http://localhost:8081/backend_to_do_list_war/api/task/${task.id}`, task, {responseType: 'text'})
      .pipe(catchError(TaskService.handleError));
  }
}
