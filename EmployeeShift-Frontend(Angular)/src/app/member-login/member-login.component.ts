import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NavbarComponent } from '../components/navbar/navbar.component';

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
  email = 'sza786@gmail.com';

  //this function we will call in member-login html component
  displayEmail() {
    console.log(this.email);
  }
}
