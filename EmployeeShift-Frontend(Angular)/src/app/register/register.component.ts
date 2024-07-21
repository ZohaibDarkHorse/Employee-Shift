import { Component } from '@angular/core';
import { NavbarComponent } from '../components/navbar/navbar.component';
import { FormsModule } from '@angular/forms';
import { ApiServiceService } from '../../services/api-service.service';
import { faUsers } from '@fortawesome/free-solid-svg-icons';

import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { error } from 'node:console';

import { ToastrService } from 'ngx-toastr';

import { CommonModule } from '@angular/common';

import { ValidationalertComponent } from '../components/validationalert/validationalert.component';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [
    FormsModule,
    NavbarComponent,
    FontAwesomeModule,
    CommonModule,
    ValidationalertComponent,
  ],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css',
})
export class RegisterComponent {
  icon = faUsers;

  brand: String = '';
  validateOrganization: String = '';
  validateEmail: String = '';
  validatePhoneNumber: String = '';
  validatePassword: String = '';
  submitIsHidden: boolean = true;
  showValidationAlert: boolean = false;

  //result = 0;
  // constructor(private data: NavbarDataService) {
  //   this.brand = data.brand;
  // }

  constructor(
    private service: ApiServiceService,
    private toastr: ToastrService
  ) {}

  validation() {
    console.log(this.submitIsHidden);
    if (
      this.validateOrganization == '' ||
      this.validateEmail == '' ||
      this.validatePhoneNumber == '' ||
      this.validatePassword == ''
    )
      this.showValidationAlert = true;
    if (
      this.validateOrganization !== '' &&
      this.validateEmail !== '' &&
      this.validatePhoneNumber !== '' &&
      this.validatePassword !== '' &&
      this.validateEmail !== ''
    ) {
      this.submitIsHidden = false;

      console.log(this.submitIsHidden);
    }
  }

  //all the form data will come here as this function is being called in the form
  getUserFormData(data: any) {
    this.service.registerUser(data).subscribe(
      (result) => {
        if (result.status == 201)
          //alert('User Registered');
          this.toastr.success(
            '<i class="fa-solid fa-thumbs-up"></i>',
            'User Registered',
            {
              positionClass: 'toast-top-center',
              enableHtml: true,
            }
          );
      },
      (error) => {
        // console.log(error.error.UserResponse.fault.message);
        // console.log(error);
        // alert(
        //   'User Not Registered due to:' + error.error.UserResponse.fault.message
        // );
        this.toastr.error(
          '  <i class="fa-solid fa-user-large-slash"></i>',
          error.error.UserResponse.fault.message,
          {
            positionClass: 'toast-top-center',
            enableHtml: true,
          }
        );
      }
    );
  }
}
