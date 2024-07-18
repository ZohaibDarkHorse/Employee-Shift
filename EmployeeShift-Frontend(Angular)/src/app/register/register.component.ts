import { Component } from '@angular/core';
import { NavbarComponent } from '../components/navbar/navbar.component';
import { FormsModule } from '@angular/forms';
import { ApiServiceService } from '../../services/api-service.service';
import { faUsers } from '@fortawesome/free-solid-svg-icons';

import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { error } from 'node:console';

import { ToastrService } from 'ngx-toastr';

import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule, NavbarComponent, FontAwesomeModule, CommonModule],
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

  constructor(
    private service: ApiServiceService,
    private toastr: ToastrService
  ) {}
  //all the form data will come here as this function is being called in the form
  getUserFormData(data: any) {
    this.service.registerUser(data).subscribe(
      (result) => {
        if (result.status == 201)
          //alert('User Registered');
          this.toastr.success('User Registered');
      },
      (error) => {
        // console.log(error.error.UserResponse.fault.message);
        // console.log(error);
        // alert(
        //   'User Not Registered due to:' + error.error.UserResponse.fault.message
        // );
        this.toastr.error(
          'User Not Registered due to:' + error.error.UserResponse.fault.message
        );
      }
    );
  }
}
