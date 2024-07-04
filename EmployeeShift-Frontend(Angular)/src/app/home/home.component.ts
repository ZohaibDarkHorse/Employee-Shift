import { Component } from '@angular/core';
import { ApiServiceService } from '../../services/api-service.service';
import { NavbarComponent } from '../components/navbar/navbar.component';
import { CommonModule } from '@angular/common';
import { FooterComponent } from '../components/footer/footer.component';
import { EmployeeDetailsComponent } from '../components/employee-details/employee-details.component';
import { AddEmployeeFormComponent } from '../components/add-employee-form/add-employee-form.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    NavbarComponent,
    CommonModule,
    FooterComponent,
    EmployeeDetailsComponent,
    AddEmployeeFormComponent,
  ],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'], // Corrected property name to "styleUrls"
})
export class HomeComponent {
  loggedIn = 'yes';
  viewEmployeeDetail = false;
  showAllEmployeeDetails = true;

  constructor(private service: ApiServiceService) {}

  showAllEmployeeDetail() {
    this.showAllEmployeeDetails = !this.showAllEmployeeDetails;
    console.log(this.showAllEmployeeDetails);
  }
}
