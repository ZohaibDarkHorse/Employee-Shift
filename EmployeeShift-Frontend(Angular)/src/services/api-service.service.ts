import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'; //this will be used to call the apis
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ApiServiceService {
  posturl = 'http://localhost:8080/employeeShift/registerUser'; //this will be the end point where post req will be hit
  constructor(private http: HttpClient) {}

  //this function will register the user
  //old function
  // registerUser(data: any) {
  //   //this will take the form data and will make the post request with form body at posturl
  //   return this.http.post(this.posturl, data);
  // }
  //using to get the status of apis
  registerUser(data: any): Observable<any> {
    return this.http.post<any>(this.posturl, data, { observe: 'response' });
  }
}
