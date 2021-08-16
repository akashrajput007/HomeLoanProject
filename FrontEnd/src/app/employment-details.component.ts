import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../personal-details/Customer';
import { Employment } from './Employment';

@Component({
  selector: 'app-employment-details',
  templateUrl: './employment-details.component.html',
  styleUrls: ['./employment-details.component.css']
})
export class EmploymentDetailsComponent implements OnInit {

 // employment: Employment;

  employment: Employment = {
    //eid:0,
    employerName : "",
    incomeFromOtherSources : 0,
    incomePat : 0,
    netMonthlyIncome : 0,
    organizationType : "",
    retirementAge : "",
    typeOfEmployement :"",
    workExperience : 0,
    customer : new Customer
}

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  clicked(){

    if(this.employment.typeOfEmployement == "") {
      alert("please enter type of employement")
    }
    else if(this.employment.netMonthlyIncome < 6000) {
      alert("Please confirm your net monthly income, your income is too low!!")
    }
    else {
    sessionStorage.setItem("employmentKey", JSON.stringify(this.employment));
    this.router.navigateByUrl("/application/property-details");
    }
  }

  back() {
    this.router.navigateByUrl("/application/address-details");
  }

  track() {
    
  }

  check() {
    
  }

  // getValues(val: any) {
  //   console.log(val);
  //   this.router.navigateByUrl("/application/property-details");
  // }
}
