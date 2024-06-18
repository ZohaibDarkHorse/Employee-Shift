import { Component } from '@angular/core';
import { NavbarComponent } from '../components/navbar/navbar.component';
import { FormsModule } from '@angular/forms';
import { ApiServiceService } from '../../services/api-service.service';
import { faUsers } from '@fortawesome/free-solid-svg-icons';

import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { error } from 'node:console';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule, NavbarComponent, FontAwesomeModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css',
})
export class RegisterComponent {
  icon = faUsers;
  organizationName = '';
  brand = '';
  //result = 0;
  // constructor(private data: NavbarDataService) {
  //   this.brand = data.brand;
  // }

  constructor(private service: ApiServiceService) {}
  //all the form data will come here as this function is being called in the form
  getUserFormData(data: any) {
    this.service.registerUser(data).subscribe(
      (result) => {
        if (result.status == 201) alert('User Registered');
      },
      (error) => {
        alert('User Not Registered due to:' + error.status);
      }
    );
  }
}
