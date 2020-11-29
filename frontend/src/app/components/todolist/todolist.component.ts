import { Component, OnInit } from '@angular/core';
import { TodoentriesService, TodoEntryInterface } from 'src/app/services/todoentries.service';

@Component({
  selector: 'app-todolist',
  templateUrl: './todolist.component.html',
  styleUrls: ['./todolist.component.css']
})

export class TodolistComponent implements OnInit {

  todoEntries: Array<TodoEntryInterface>;

  constructor(private todoService: TodoentriesService) {
    this.todoEntries = todoService.get();
   }

  ngOnInit(): void {
  }

  markAsDone(id: number) {
    this.todoEntries = this.todoService.markAsDone(id);
  }
}
