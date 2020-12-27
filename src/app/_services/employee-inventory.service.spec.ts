import { TestBed } from '@angular/core/testing';

import { EmployeeInventoryService } from './employee-inventory.service';

describe('EmployeeInventoryService', () => {
  let service: EmployeeInventoryService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EmployeeInventoryService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
