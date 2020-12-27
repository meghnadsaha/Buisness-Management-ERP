import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


const AUTH_API = 'localhost:8888/erp_api/inventoryDetails/'; //base url


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};   

@Injectable({
  providedIn: 'root'
})
export class EmployeeInventoryService {

  constructor(private http:HttpClient) { }
 
  save(user): Observable<any> {
    return this.http.post(AUTH_API + 'save', {
      driver_no: user.driver_no,
      salary: user.salary,
      date_of_joining: user.date_of_joining,
      date_of_salary_initiation: user.date_of_salary_initiation,
      food_expenses: user.food_expenses,
      yearly_bonus: user.yearly_bonus
    }, httpOptions);
  }
  

  
}
