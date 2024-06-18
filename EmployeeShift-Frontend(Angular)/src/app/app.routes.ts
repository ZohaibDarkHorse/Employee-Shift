import { RouterModule, Routes } from '@angular/router';
import { MemberLoginComponent } from './member-login/member-login.component';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';

export const routes: Routes = [
  {
    path: 'member-login',
    component: MemberLoginComponent,
  },
  {
    path: 'home',
    component: HomeComponent,
  },

  {
    path: '',
    component: RegisterComponent,
  },
];
