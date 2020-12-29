import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UploadFilesService {

  private baseUrl = 'http://localhost:8888/erp_api/document-handler';


constructor(private http: HttpClient) { }

upload(file: File): Observable<HttpEvent<any>> {
     /**
     *  FormData is a data structure that can be used to store key-value pairs. 
     *  We use it to build an object which corresponds to an HTML form with append() method. 
     */
  const formData: FormData = new FormData();

  formData.append('files', file);

  const req = new HttpRequest('POST', `${this.baseUrl}/upload`, formData, {
    reportProgress: true,
    responseType: 'json'
  });

  return this.http.request(req);
}

getFiles(): Observable<any> {
  return this.http.get(`${this.baseUrl}/files`);
}
}