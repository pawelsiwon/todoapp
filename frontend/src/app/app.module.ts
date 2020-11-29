import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { TodoentryComponent } from './components/todoentry/todoentry.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { TodolistComponent } from './components/todolist/todolist.component';
import { CreatenewComponent } from './components/createnew/createnew.component';
import { TodoLayoutComponent } from './components/todo-layout/todo-layout.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    TodoLayoutComponent,
    TodoentryComponent,
    TodolistComponent,
    CreatenewComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
