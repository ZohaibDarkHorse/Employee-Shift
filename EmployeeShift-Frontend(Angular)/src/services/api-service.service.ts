import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'; //this will be used to call the apis
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ApiServiceService {
  token: string | null;
  username: string | null; // Declare username property

  posturl = 'http://localhost:8080/employeeShift/registerUser'; //this will be the end point where post req will be hit
  loginurl = 'http://localhost:8080/employeeShift/auth/login';
  getAllEmployeeUrl =
    'http://localhost:8080/employeeShift/getAllEmployeeOfOrganization/';
  constructor(private http: HttpClient) {
    // Check if localStorage is available before accessing it
    if (typeof localStorage !== 'undefined') {
      this.username = localStorage.getItem('username');
      this.token = localStorage.getItem('token');
    } else {
      // Fallback or handle the case where localStorage is not available
      this.username = null; // Or any other default value you want to set
      this.token = null;
    }
  }

  registerUser(data: any): Observable<any> {
    return this.http.post<any>(this.posturl, data, { observe: 'response' });
  }

  member_Login(data: any): Observable<any> {
    return this.http.post(this.loginurl, data);
  }

  getAllEmployee(): Observable<any> {
    console.log(this.username);
    console.log(this.token);
    console.log(`Bearer ${this.token}`);
    const headers = new HttpHeaders({
      Authorization: `Bearer ${this.token}`,
    });
    console.log(headers);
    return this.http.post<any>(this.getAllEmployeeUrl + this.username, null, {
      headers,
    });
  }
}
