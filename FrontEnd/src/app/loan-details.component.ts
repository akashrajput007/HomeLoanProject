import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employment } from '../employment-details/Employment';
import { Customer } from '../personal-details/Customer';
import { Application } from './Application';


@Component({
  selector: 'app-loan-details',
  templateUrl: './loan-details.component.html',
  styleUrls: ['./loan-details.component.css']
})
export class LoanDetailsComponent implements OnInit {

 // application: Application;
 tempEmployment: any;
 myEmployment: Employment;
 eligibleAmount: any;
 
  application: Application = {
   //applicationNo : 0,
    comments : "",
    status : "FORM SUBMITTED",
    tenure: 0,
    expectedAmount : 0,
    customer: new Customer()
}

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  clicked(){
    if(this.application.expectedAmount < 50000) {
      alert("As per our policy, we do no sanction loan below Rs. 50,000")
    }
    else if(this.application.tenure == 0) {
      alert("As per our policy, tenure cannot be less than 1 year")
    }
    else if(this.application.tenure > 30 || this.application.tenure == 0) {
      alert("As per our policy, tenure cannot be more than 30 years")
    }
    else {

  
        this.tempEmployment = sessionStorage.getItem("employmentKey");
        this.myEmployment = JSON.parse(this.tempEmployment);
        this.myEmployment.netMonthlyIncome

        this.eligibleAmount = 60 * (0.6 * this.myEmployment.netMonthlyIncome);

        if(this.eligibleAmount < this.application.expectedAmount) {
          alert("Your expected amount is more than eligibility amount");
        }
     else{
       sessionStorage.setItem("applicationKey", JSON.stringify(this.application));
      this.router.navigateByUrl("/application/collateral-details");
      }
    }
  }

  back() {
    this.router.navigateByUrl("/application/property-details");
  }

}
