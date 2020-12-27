import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeInventoryDetailsComponent } from './employee-inventory-details.component';

describe('EmployeeInventoryDetailsComponent', () => {
  let component: EmployeeInventoryDetailsComponent;
  let fixture: ComponentFixture<EmployeeInventoryDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeInventoryDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeInventoryDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
