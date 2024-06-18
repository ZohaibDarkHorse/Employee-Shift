import { Component } from '@angular/core';
import { NavbarDataService } from '../../../services/navbar-data.service';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css',
})
export class NavbarComponent {
  brand = '';
  link1 = '';
  link2 = '';
  link3 = '';
  link4 = '';
  constructor(private navBarData: NavbarDataService) {
    this.brand = navBarData.brand;
    this.link1 = navBarData.link1;
    this.link2 = navBarData.link2;
    this.link3 = navBarData.link3;
    this.link4 = navBarData.link4;
  }
}
