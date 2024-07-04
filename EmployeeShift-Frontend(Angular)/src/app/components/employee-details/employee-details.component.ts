import { Component } from '@angular/core';
import { NgxPaginationModule } from 'ngx-pagination';
import { ApiServiceService } from '../../../services/api-service.service';
import { CommonModule } from '@angular/common';
import { ModalsComponent } from '../modals/modals.component';

@Component({
  selector: 'app-employee-details',
  standalone: true,
  imports: [NgxPaginationModule, CommonModule, ModalsComponent],
  templateUrl: './employee-details.component.html',
  styleUrl: './employee-details.component.css',
})
export class EmployeeDetailsComponent {
  username: string | null; // Declare username property
  token: string | null;
  users: any;
  userById: any;
  viewEmployeeDetail = false;
  psize = 10;
  currentPage = 1;
  constructor(private service: ApiServiceService) {
    // Check if localStorage is available before accessing it
    if (typeof localStorage !== 'undefined') {
      this.username = localStorage.getItem('username');
      this.token = localStorage.getItem('token');
    } else {
      // Fallback or handle the case where localStorage is not available
      this.username = null; // Or any other default value you want to set
      this.token = null;
    }
  }
  getEmployeeById(Id: any) {
    this.service.getEmployeeById(Id, this.token).subscribe(
      (result) => {
        console.log(result);
        this.userById = result;
      },
      (error) => {
        alert(error);
      }
    );
  }
  showEmployeeDetails() {
    this.viewEmployeeDetail = !this.viewEmployeeDetail;
  }
  deleteByID(id: any, event: Event) {
    event.stopPropagation(); // Stop the click event from propagating to the row
    this.service.deleteEmployeeById(id, this.token).subscribe(
      (result) => {
        console.log(result);
        window.location.reload();
      },
      (error) => {
        console.log(error);
      }
    );
  }

  onViewBtnClick(Id: any) {
    this.getEmployeeById(Id);
    this.showEmployeeDetails();
  }
  getAllEmployeeOfOrganization() {
    this.service
      .getAllEmployeeOfOrganization(this.username, this.token)
      .subscribe(
        (result) => {
          this.users = result;
        },
        (error) => {
          console.log(error);
        }
      );
  }

  getValueFromModal(data: any) {
    this.viewEmployeeDetail = data;
  }

  ngOnInit() {
    this.getAllEmployeeOfOrganization();
  }
}
