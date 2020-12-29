import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeInventoryDetailsCreateComponent } from './employee-inventory-details-create.component';

describe('EmployeeInventoryDetailsCreateComponent', () => {
  let component: EmployeeInventoryDetailsCreateComponent;
  let fixture: ComponentFixture<EmployeeInventoryDetailsCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeInventoryDetailsCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeInventoryDetailsCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
