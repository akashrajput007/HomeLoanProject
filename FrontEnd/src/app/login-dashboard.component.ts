import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Customer } from 'src/app/application/personal-details/Customer';
import { Application } from 'src/app/loan-tracker/Application';
import { Loan } from 'src/app/loan-tracker/Loan';
import { CommonService } from 'src/app/services/common.service';
import { Emi } from './EMI';
import { getEMI } from './getEmi';


@Component({
  selector: 'app-login-dashboard',
  templateUrl: './login-dashboard.component.html',
  styleUrls: ['./login-dashboard.component.css']
})
export class LoginDashboardComponent implements OnInit {
  emailId: string;
  tempEmailId: any;
 // emi: getEMI = new getEMI();

// emi: getEMI[] 
// buttonClicked:boolean=false;
disableClass:string;
emi: getEMI={
  customer : new Customer,
  loan : new Loan,
  emiList: [{
    emiId: 0,
    emiDueDate: new Date,
    status: ""
  }],
  application: new Application
}


 // tempemi: getEMI = new getEMI();
  tempemi: getEMI={
    customer : new Customer,
    loan : new Loan,
    emiList: [{
      emiId: 0,
      emiDueDate: new Date,
      status: ""
    }],
    application: new Application
  }


  constructor(private commonService: CommonService, private router: Router) {
  this.tempEmailId = sessionStorage.getItem("emailId");
  this.emailId = JSON.parse(this.tempEmailId);
  }

  ngOnInit(): void {
    console.log(this.emailId);
    this.commonService.getEMIService(this.emailId).subscribe(
      (data: getEMI) => {
        this.emi = data;
        this.tempemi = data;
      }
    )
  }
  pay(custId:number) {
    this.commonService.insertAndGetEmiService(custId).subscribe(
      (data: getEMI) => {
        this.emi = data;
        this.tempemi = data;
        alert("Emi paid Successfully")
      }
    )
    this.disableClass = "disabled";
    location.reload();
  
  }
  logout() {
    localStorage.clear();
    this.commonService.loginSub.next('Login');
    this.router.navigateByUrl("/login");
  }
}
