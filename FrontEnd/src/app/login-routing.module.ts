import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConfirmPasswordComponent } from './confirm-password/confirm-password.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { LoginDashboardComponent } from './login-dashboard/login-dashboard.component';
import { LoginComponent } from './login.component';

const routes: Routes = [
  {
    path: '',
    component: LoginComponent
  },
  {
    path: 'login-dashboard',
    component: LoginDashboardComponent
  },
  {
    path: 'forgot-password',
    component: ForgotPasswordComponent
  },
  {
    path: 'confirm-password',
    component: ConfirmPasswordComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LoginRoutingModule { }
