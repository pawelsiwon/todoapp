import { Component, OnInit } from '@angular/core';
import { TodoentriesService } from 'src/app/services/todoentries.service';
import { TodolistComponent } from '../todolist/todolist.component';

@Component({
  selector: 'app-createnew',
  templateUrl: './createnew.component.html',
  styleUrls: ['./createnew.component.css']
})
export class CreatenewComponent implements OnInit {
  
  todoTask: string;
  
  
  constructor(private service: TodoentriesService, private entryList: TodolistComponent) {

  }

  ngOnInit(): void {
  }

  add() {
    this.service.add(this.todoTask);
    this.todoTask = "";
    this.entryList.update();
  }

}
