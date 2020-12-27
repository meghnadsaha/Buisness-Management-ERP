import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';


const AUTH_API = 'http://localhost:8888/erp_api/auth/'; //base url


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};   

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http:HttpClient) { }
 
  register(user): Observable<any> {
    return this.http.post(AUTH_API + 'signup', {
      username: user.username,
      password: user.password
    }, httpOptions);
  }
  

}
