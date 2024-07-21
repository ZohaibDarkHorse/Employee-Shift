import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-validationalert',
  standalone: true,
  imports: [],
  templateUrl: './validationalert.component.html',
  styleUrl: './validationalert.component.css',
})
export class ValidationalertComponent {
  @Input() message: String = '';
}
