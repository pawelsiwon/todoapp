import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

let service: '/api/todoentries';

let entries: Array<TodoEntryInterface> = [
  {id: 0, description: "Reply to emails", done: true},
  {id: 1, description: "Create shopping list", done: false},
  {id: 2, description: "Set appointment with doctor", done: false},
  {id: 3, description: "Pay internet bills", done: true},
];

export interface TodoEntryInterface{
  id: number;
  description: string;
  done: boolean;
}

@Injectable({
  providedIn: 'root'
})
export class TodoentriesService {

  constructor(private http: HttpClient) { 
    
  }

  get() {
    return entries.slice();
  }

  load() {
    return this.http.get<Array<TodoEntryInterface>>(service);
  }

  add(entry: string) {
    entries.push({id: null, description: entry, done: false});
    console.log(entries);
  }

  markAsDone(id: number) {
    let todoEntry = entries.find(e => e.id == id);
    entries.splice(entries.indexOf(todoEntry), 1);
    return this.get();
  }

  public getRefesh(): Observable<boolean> {
    return this.refresh.asObservable();
  }
}
