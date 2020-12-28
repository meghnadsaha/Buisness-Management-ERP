import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


const baseUrl = 'http://localhost:8888/erp_api/'; //base url


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};   

@Injectable({
  providedIn: 'root'
})
export class EmployeeInventoryService {

  constructor(private http:HttpClient) { }
 
  save(user): Observable<any> {
    return this.http.post(baseUrl + 'inventoryDetails/save', {
      driver_no: user.driver_no,
      salary: user.salary,
      date_of_joining: user.date_of_joining,
      date_of_salary_initiation: user.date_of_salary_initiation,
      food_expenses: user.food_expenses,
      yearly_bonus: user.yearly_bonus
    }, httpOptions);
  }

  getAll(): Observable<any> {
    return this.http.get(baseUrl+"test/retrive-all");
  }

  get(id): Observable<any> {
    return this.http.get(`${baseUrl+"test/retrive"}/${id}`);
  }

  create(data): Observable<any> {
    return this.http.post(baseUrl+"test/create", data);
  }

  update(id, data): Observable<any> {
    return this.http.put(`${baseUrl+"test/update"}/${id}`, data);
  }

  delete(id): Observable<any> {
    return this.http.delete(`${baseUrl+"test/delete"}/${id}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(baseUrl+"test/delete-all");
  }

  findByTitle(title): Observable<any> {
    return this.http.get(`${baseUrl+"test/fetch-by-title"}?title=${title}`);
  }


  

  
}
