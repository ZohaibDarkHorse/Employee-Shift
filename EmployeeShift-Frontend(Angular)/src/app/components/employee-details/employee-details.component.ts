import { Component } from '@angular/core';
import { NgxPaginationModule } from 'ngx-pagination';
import { ApiServiceService } from '../../../services/api-service.service';
import { CommonModule } from '@angular/common';
import { ModalsComponent } from '../employee-detail/modals.component';
import { UpdateCardComponent } from '../update-card/update-card.component';
import { error } from 'node:console';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-employee-details',
  standalone: true,
  imports: [
    NgxPaginationModule,
    CommonModule,
    ModalsComponent,
    UpdateCardComponent,
  ],
  templateUrl: './employee-details.component.html',
  styleUrl: './employee-details.component.css',
})
export class EmployeeDetailsComponent {
  username: string | null; // Declare username property
  token: string | null;
  users: any = {
    GetAllEmployeeResponse: {
      EmployeeList: [],
    },
  };
  employeeDetail: any = {
    GetEmployeeByIdResponse: {
      EmployeeDetail: {
        empId: null,
        name: '',
        project: '',
        emailId: '',
        allocatedBy: '',
        organization: '',
        profileImage: '',
      },
    },
  };
  viewEmployeeDetail = false;
  viewUpdateEmployee = false;
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
        this.employeeDetail = result;
        console.log(this.employeeDetail);
      },
      (error) => {
        console.log('HAHA');
      }
    );
  }
  showEmployeeDetails() {
    this.viewEmployeeDetail = !this.viewEmployeeDetail;
  }
  showUpdateEmployeeDetails() {
    this.viewUpdateEmployee = !this.viewUpdateEmployee;
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
    this.viewUpdateEmployee = false;
  }
  onUpdateBtnClicK(Id: any) {
    this.getEmployeeById(Id);
    this.showUpdateEmployeeDetails();
    this.viewEmployeeDetail = false;
  }
  getAllEmployeeOfOrganization(): void {
    this.service
      .getAllEmployeeOfOrganization(this.username, this.token)
      .subscribe(
        (result) => {
          this.users = result;
        },
        (error) => {
          console.log(error);
          this.users = { GetAllEmployeeResponse: { EmployeeList: [] } }; // Ensure the structure is there in case of error
        }
      );
  }

  getValueFromModal(data: any) {
    this.viewEmployeeDetail = data;
  }
  getValueFromcloseUpdateEmployeeModal(data: any) {
    this.viewUpdateEmployee = data;
  }

  ngOnInit(): void {
    this.getAllEmployeeOfOrganization();
  }
}
