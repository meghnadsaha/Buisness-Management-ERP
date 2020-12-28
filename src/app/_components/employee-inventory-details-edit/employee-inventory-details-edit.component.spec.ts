import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeInventoryDetailsEditComponent } from './employee-inventory-details-edit.component';

describe('EmployeeInventoryDetailsEditComponent', () => {
  let component: EmployeeInventoryDetailsEditComponent;
  let fixture: ComponentFixture<EmployeeInventoryDetailsEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeInventoryDetailsEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeInventoryDetailsEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
