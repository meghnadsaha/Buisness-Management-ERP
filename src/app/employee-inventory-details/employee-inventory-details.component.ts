import { Component, OnInit } from '@angular/core';
import { EmployeeInventoryService } from '../_services/employee-inventory.service';

@Component({
  selector: 'app-employee-inventory-details',
  templateUrl: './employee-inventory-details.component.html',
  styleUrls: ['./employee-inventory-details.component.css']
})
export class EmployeeInventoryDetailsComponent implements OnInit {
  form: any = {};
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';

  constructor(private employeeInventoryService: EmployeeInventoryService) { }

  ngOnInit() {
  }

  onSubmit() {
    this.employeeInventoryService.save(this.form).subscribe(
      data => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
      },
      err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    );
  }
}