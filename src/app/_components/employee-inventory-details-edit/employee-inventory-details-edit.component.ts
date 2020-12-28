import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeInventoryService } from 'src/app/_services/employee-inventory.service';

@Component({
  selector: 'app-employee-inventory-details-edit',
  templateUrl: './employee-inventory-details-edit.component.html',
  styleUrls: ['./employee-inventory-details-edit.component.css']
})
export class EmployeeInventoryDetailsEditComponent implements OnInit {
  currentTutorial = null;
  message = '';

  constructor(
    private employeeInventoryService: EmployeeInventoryService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.message = '';
    this.getTutorial(this.route.snapshot.paramMap.get('id'));
  }

  getTutorial(id): void {
    this.employeeInventoryService.get(id)
      .subscribe(
        data => {
          this.currentTutorial = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  updatePublished(status): void {
    const data = {
      title: this.currentTutorial.title,
      description: this.currentTutorial.description,
      published: status
    };

    this.employeeInventoryService.update(this.currentTutorial.id, data)
      .subscribe(
        response => {
          this.currentTutorial.published = status;
          console.log(response);
        },
        error => {
          console.log(error);
        });
  }

  updateTutorial(): void {
    this.employeeInventoryService.update(this.currentTutorial.id, this.currentTutorial)
      .subscribe(
        response => {
          console.log(response);
          this.message = 'The inventory was updated successfully!';
        },
        error => {
          console.log(error);
        });
  }

  deleteTutorial(): void {
    this.employeeInventoryService.delete(this.currentTutorial.id)
      .subscribe(
        response => {
          console.log(response);
          this.router.navigate(['/list-of-inventory']);
        },
        error => {
          console.log(error);
        });
  }
}