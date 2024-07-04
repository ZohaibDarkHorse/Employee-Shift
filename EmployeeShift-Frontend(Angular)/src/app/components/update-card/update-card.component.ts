import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-update-card',
  standalone: true,
  imports: [],
  templateUrl: './update-card.component.html',
  styleUrl: './update-card.component.css',
})
export class UpdateCardComponent {
  @Input() userDetail: any;
}
