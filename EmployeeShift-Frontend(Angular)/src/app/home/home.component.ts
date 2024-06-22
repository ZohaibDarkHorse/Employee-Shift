import { Component } from '@angular/core';
import { ApiServiceService } from '../../services/api-service.service';
import { NavbarComponent } from '../components/navbar/navbar.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [NavbarComponent, CommonModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
})
export class HomeComponent {
  username: string | null; // Declare username property
  users: any;
  constructor(private service: ApiServiceService) {
    // Check if localStorage is available before accessing it
    if (typeof localStorage !== 'undefined') {
      this.username = localStorage.getItem('username');
    } else {
      // Fallback or handle the case where localStorage is not available
      this.username = null; // Or any other default value you want to set
    }
  }
  getAllEmployee() {
    this.service.getAllEmployee().subscribe((result) => {
      this.users = result;
      console.log(this.users);
    });
  }
}
