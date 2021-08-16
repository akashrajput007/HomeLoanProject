import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { CalculatorComponent } from './calculator/calculator.component';
//import { LoginComponent } from './login/login.component';
import { FaqComponent } from './faq/faq.component';
import { FeaturesComponent } from './features/features.component';
import { DocumentsComponent } from './documents/documents.component';
import { LoanTrackerComponent } from './loan-tracker/loan-tracker.component';
import { YourAccountComponent } from './your-account/your-account.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { ForgotPasswordComponent } from './login/forgot-password/forgot-password.component';
import { ConfirmPasswordComponent } from './login/confirm-password/confirm-password.component';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutUsComponent,
    CalculatorComponent,
  //  LoginComponent,
    FaqComponent,
    FeaturesComponent,
    DocumentsComponent,
    LoanTrackerComponent,
    YourAccountComponent,
    AdminDashboardComponent,
    ForgotPasswordComponent,
    ConfirmPasswordComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ToastrModule.forRoot(),
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
