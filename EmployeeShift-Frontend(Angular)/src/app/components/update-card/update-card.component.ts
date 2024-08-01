import { Component, Input, Output, EventEmitter } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ApiServiceService } from '../../../services/api-service.service';

@Component({
  selector: 'app-update-card',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './update-card.component.html',
  styleUrl: './update-card.component.css',
})
export class UpdateCardComponent {
  @Input() userDetail: any;
  @Output() closeUpdateEmployeeModal = new EventEmitter<boolean>();

  username: string | null; // Declare username property
  token: string | null;
  selectedFile: File | null = null;
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
  onFileSelected(event: any) {
    const file = event.target.files[0];
    this.selectedFile = file ?? null;
  }

  closeUpdateEmployeeModalFunction() {
    this.closeUpdateEmployeeModal.emit(false);
  }

  getProfileImageUrl(): string {
    const baseUrl = 'http://localhost:8080/images/download/';
    const profileImage =
      this.userDetail.GetEmployeeByIdResponse.EmployeeDetail.profileImage;
    return profileImage ? `${baseUrl}${profileImage}` : '';
  }

  updateEmployee(form: any) {
    const formData = new FormData();
    formData.append(
      'empId',
      this.userDetail.GetEmployeeByIdResponse.EmployeeDetail.empId
    );
    formData.append('name', form.value.name);
    formData.append('project', form.value.project);
    formData.append('emailId', form.value.emailId);
    formData.append(
      'organization',
      this.userDetail.GetEmployeeByIdResponse.EmployeeDetail.organization
    );
    if (this.selectedFile) {
      formData.append('image', this.selectedFile, this.selectedFile.name);
    }
    // Provide a fallback value for `username` if it's null
    formData.append('allocatedBy', this.username ?? '');
    this.service.updateEmployeeDetail(formData, this.token).subscribe(
      (result) => {
        this.closeUpdateEmployeeModalFunction();

        alert('Updated');
        // this.userById = result;
        location.reload();
      },
      (error) => {
        alert('You Hit a error');
        console.log(error);
        //alert(error);
      }
    );
  }
}
