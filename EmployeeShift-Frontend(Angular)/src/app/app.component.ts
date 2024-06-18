import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MemberLoginComponent } from './member-login/member-login.component';
import { HttpClientModule } from '@angular/common/http'; //imp to import in order to usee http client inside the service class
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    MemberLoginComponent,
    HttpClientModule,
    FontAwesomeModule,
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'employee-shift';
}
