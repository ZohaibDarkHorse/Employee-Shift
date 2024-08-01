import { Component, Output, EventEmitter } from '@angular/core';
import { Input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-modals',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './modals.component.html',
  styleUrl: './modals.component.css',
})
export class ModalsComponent {
  showModal = true;
  constructor() {}
  @Input() userDetail: any;
  @Output() updateEvent = new EventEmitter<boolean>();
  closeModal() {
    this.showModal = false;
    this.updateEvent.emit(this.showModal);
  }
  getProfileImageUrl(): string {
    const baseUrl = 'http://localhost:8080/images/download/';
    const profileImage =
      this.userDetail.GetEmployeeByIdResponse.EmployeeDetail.profileImage;
    return profileImage ? `${baseUrl}${profileImage}` : '';
  }
}
