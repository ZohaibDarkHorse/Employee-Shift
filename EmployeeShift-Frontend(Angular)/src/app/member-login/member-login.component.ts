import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NavbarComponent } from '../components/navbar/navbar.component';
import { ApiServiceService } from '../../services/api-service.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-member-login',
  standalone: true,
  imports: [FormsModule, NavbarComponent],
  templateUrl: './member-login.component.html',
  styleUrl: './member-login.component.css',
})
export class MemberLoginComponent {
  loginType = 'Admin'; //here I will be using one way interpolation this will
  //be passed to html document

  constructor(private service: ApiServiceService, private location: Location) {}

  member_login_form_data(formData: any) {
    //  console.log(formData);
    this.service.member_Login(formData).subscribe((result) => {
      //console.log(result);
      //console.log(result.jwtToken);
      localStorage.setItem('token', result.jwtToken);
      localStorage.setItem('username', result.username);
      // this.service.token = result.jwtToken;
      //this.service.username = result.username;
      this.location.go('/home');
      window.location.reload();
    });

    console.log(this.service.token);
  }

  //this function we will call in member-login html component
}
