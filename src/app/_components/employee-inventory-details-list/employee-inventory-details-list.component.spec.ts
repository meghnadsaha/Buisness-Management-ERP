import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeInventoryDetailsListComponent } from './employee-inventory-details-list.component';

describe('EmployeeInventoryDetailsListComponent', () => {
  let component: EmployeeInventoryDetailsListComponent;
  let fixture: ComponentFixture<EmployeeInventoryDetailsListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeInventoryDetailsListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeInventoryDetailsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
