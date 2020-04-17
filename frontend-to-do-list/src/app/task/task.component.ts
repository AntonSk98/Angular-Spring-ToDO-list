import { Component, OnInit } from '@angular/core';
import {TaskService} from './task.service';
import { Task } from './task';
@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {

  tasks: Task[];
  newTask = new Task();
  updatedTask = new Task();
  page = 1;
  pageSize = 5;
  isUpdated = false;
  constructor(private taskService: TaskService) { }

  ngOnInit(): void {
    this.getAllTask();
  }

  getAllTask() {
    this.taskService.getAllTasks().subscribe((value: Task[]) => {
      this.tasks = value;
    });
  }

  saveTask() {
    if (this.newTask.date && this.newTask.title && this.newTask.description) {
      this.taskService.addOrEditTaskResolver(this.newTask).subscribe(value => {
        this.resetFields();
        this.getAllTask();
        this.isUpdated = false;
      });
    }
  }

  private resetFields() {
    this.newTask.id = null;
    this.newTask.date = null;
    this.newTask.title = null;
    this.newTask.description = null;
  }

  deleteTaskById(id: number) {
    this.taskService.deleteTask(id).subscribe(value => {
      this.getAllTask();
    });
  }

  getTaskById(id: number) {
    this.isUpdated = true;
    this.taskService.getTaskById(id).subscribe((value: Task) => this.newTask = value);
  }
}
