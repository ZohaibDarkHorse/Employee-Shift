import { RouterModule, Routes } from '@angular/router';
import { MemberLoginComponent } from './member-login/member-login.component';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';
import { UpdateCardComponent } from './components/update-card/update-card.component';

export const routes: Routes = [
  {
    path: '',
    component: MemberLoginComponent,
  },
  {
    path: 'home',
    component: HomeComponent,
  },

  {
    path: 'register',
    component: RegisterComponent,
  },
  {
    path: 'underDevelopment',
    component: UpdateCardComponent,
  },
];
