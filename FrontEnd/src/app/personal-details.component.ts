import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from './Customer';

@Component({
  selector: 'app-personal-details',
  templateUrl: './personal-details.component.html',
  styleUrls: ['./personal-details.component.css']
})
export class PersonalDetailsComponent implements OnInit {

  // customer: Customer;

  confirmPassword: string;
  customer: Customer = {
    custId: 0,
    aadharNumber: "",
    dateOfBirth: new Date(),
    emailId: "",
    firstName: "",
    gender: "",
    lastName: "",
    middleName: "",
    panNumber: "",
    password: "",
    phoneNumber: "",
    title: ""
  };

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  clicked() {
    if (this.customer.title == "") {
      alert("Please enter the title")
    }
    else if (this.customer.firstName == "") {
      alert("Please enter First Name")
    }
    else if (this.customer.lastName == "") {
      alert("Please enter Last Name")
    }
    else if (this.customer.emailId == "" || this.customer.emailId.length < 6) {
      alert("Please enter correct email address")
    }
    else if (this.customer.password == "") {
      alert("Please enter the password")
    }
    else if (this.customer.password.length < 4) {
      alert("Password should be more than 4 characters")
    }
    else if (this.confirmPassword == "" || (this.customer.password != this.confirmPassword)) {
      alert("Confirm Password does not match!!")
    }
    else if (this.customer.phoneNumber == "" || this.customer.phoneNumber.length != 10) {
      alert("Please enter correct Phone Number")
    }
    else if (this.customer.gender == "") {
      alert("Please enter gender")
    }    
    else if (this.customer.aadharNumber == "" || this.customer.aadharNumber.length != 12) {
      alert("Please enter correct Aadhar Card Number")
    }
    else if (this.customer.panNumber == "" || this.customer.panNumber.length != 10) {
      alert("Please enter correct PAN Card Number")
    }
    else{
    sessionStorage.setItem("customerKey", JSON.stringify(this.customer));
    this.router.navigateByUrl("/application/address-details");
    }
  }

  
}
