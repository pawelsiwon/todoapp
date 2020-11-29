import { TestBed } from '@angular/core/testing';

import { TodoentriesService } from './todoentries.service';

describe('TodoentriesService', () => {
  let service: TodoentriesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TodoentriesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
