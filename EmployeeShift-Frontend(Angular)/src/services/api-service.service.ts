import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'; //this will be used to call the apis
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ApiServiceService {
  posturl = 'http://localhost:8080/employeeShift/registerUser'; //this will be the end point where post req will be hit
  loginurl = 'http://localhost:8080/employeeShift/auth/login';
  getAllEmployeeUrl =
    'http://localhost:8080/employeeShift/getAllEmployeeOfOrganization/';
  getEmployeeByIdUrl = 'http://localhost:8080/employeeShift/getEmployeeById/';
  addfEmployeeDetailUrl = 'http://localhost:8080/employeeShift/addEmployee';
  deleteEmployeeByIdUrl = 'http://localhost:8080/employeeShift/deleteEmployee/';
  constructor(private http: HttpClient) {
    // Check if localStorage is available before accessing it
  }

  registerUser(data: any): Observable<any> {
    return this.http.post<any>(this.posturl, data, { observe: 'response' });
  }

  member_Login(data: any): Observable<any> {
    return this.http.post(this.loginurl, data);
  }

  getAllEmployeeOfOrganization(username: any, token: any): Observable<any> {
    const headers = new HttpHeaders({
      Authorization: `Bearer ${token}`,
    });
    return this.http.get<any>(this.getAllEmployeeUrl + username, {
      headers,
    });
  }
  getEmployeeById(Id: any, token: any): Observable<any> {
    // console.log('ID:' + Id);
    // console.log(token);
    const headers = new HttpHeaders({
      Authorization: `Bearer ${token}`,
    });
    return this.http.get<any>(this.getEmployeeByIdUrl + Id, { headers });
  }
  addEmployeeDetail(data: any, token: any): Observable<any> {
    // console.log('data:' + data);
    // console.log(token);
    const headers = new HttpHeaders({
      Authorization: `Bearer ${token}`,
    });
    return this.http.post<any>(this.addfEmployeeDetailUrl, data, { headers });
  }
  deleteEmployeeById(Id: any, token: any): Observable<any> {
    //  console.log('data:' + data);
    //  console.log(token);
    const headers = new HttpHeaders({
      Authorization: `Bearer ${token}`,
    });
    return this.http.delete<any>(this.deleteEmployeeByIdUrl + Id, { headers });
  }
}
