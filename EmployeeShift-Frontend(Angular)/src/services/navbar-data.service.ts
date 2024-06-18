import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class NavbarDataService {
  constructor() {}

  brand = 'EmployeeShift';
  link1 = 'Home';
  link2 = 'Login';
  link3 = 'Logout';
  link4 = 'Register';
}
