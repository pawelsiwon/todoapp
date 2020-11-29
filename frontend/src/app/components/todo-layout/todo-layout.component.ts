import { Component, OnInit } from '@angular/core';
import { TodoentriesService } from 'src/app/services/todoentries.service';
import { TodoEntryInterface } from 'src/app/services/todoentries.service';

let entries: Array<TodoEntryInterface> = [];

@Component({
  selector: 'app-todo-layout',
  templateUrl: './todo-layout.component.html',
  styleUrls: ['./todo-layout.component.css']
})
export class TodoLayoutComponent implements OnInit {

  constructor(private todoService: TodoentriesService) {
    entries = todoService.get();
   }

  ngOnInit(): void {
  }

}
