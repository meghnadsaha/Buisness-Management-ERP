import { Component, OnInit ,Input} from '@angular/core';
import { EmployeeInventoryService } from 'src/app/_services/employee-inventory.service';

@Component({
  selector: 'app-employee-inventory-details-create',
  templateUrl: './employee-inventory-details-create.component.html',
  styleUrls: ['./employee-inventory-details-create.component.css']
})
export class EmployeeInventoryDetailsCreateComponent  implements OnInit {
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