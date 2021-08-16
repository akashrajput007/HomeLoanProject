import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoginRoutingModule } from './login-routing.module';
import { LoginComponent } from './login.component';
import { LoginDashboardComponent } from './login-dashboard/login-dashboard.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [LoginComponent, LoginDashboardComponent],
  imports: [
    CommonModule,
    LoginRoutingModule,
    FormsModule
  ]
})
export class LoginModule { }
