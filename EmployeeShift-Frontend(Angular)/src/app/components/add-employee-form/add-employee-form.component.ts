import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ApiServiceService } from '../../../services/api-service.service';

@Component({
  selector: 'app-add-employee-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './add-employee-form.component.html',
  styleUrl: './add-employee-form.component.css',
})
export class AddEmployeeFormComponent {
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
  addEmployeeDetailsForm(form: any) {
    const formData = new FormData();
    formData.append('name', form.value.name);
    formData.append('project', form.value.project);
    formData.append('emailId', form.value.emailId);
    formData.append('allocatedBy', this.username ?? '');
    formData.append('organization', form.value.organization);

    if (this.selectedFile) {
      formData.append('image', this.selectedFile, this.selectedFile.name);
    }
    this.service.addEmployeeDetail(formData, this.token).subscribe(
      (result) => {
        console.log(result);

        // this.userById = result;
        window.location.reload();
      },
      (error) => {
        alert(error);
      }
    );
  }
}
