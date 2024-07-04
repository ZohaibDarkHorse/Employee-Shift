import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarDataService } from '../../../services/navbar-data.service';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css',
})
export class NavbarComponent {
  brand = 'EmployeeShift';
  link1 = 'Home';
  link2 = 'Login';
  link3 = 'Logout';
  link4 = 'Register';

  @Input() log = 'no';

  logOut() {
    localStorage.clear();
  }

  ngOnInit() {}
}
