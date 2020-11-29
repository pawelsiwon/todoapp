import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TodoentryComponent } from './todoentry.component';

describe('TodoentryComponent', () => {
  let component: TodoentryComponent;
  let fixture: ComponentFixture<TodoentryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TodoentryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TodoentryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
