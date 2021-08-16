import { Component, OnInit } from '@angular/core';
import { LoanAccountNoService } from '../loan-account-no.service';
import { LoanTrackerService } from '../loan-tracker.service';
import { Application } from './Application';
import { Loan } from './Loan';

@Component({
  selector: 'app-loan-tracker',
  templateUrl: './loan-tracker.component.html',
  styleUrls: ['./loan-tracker.component.css']
})
export class LoanTrackerComponent implements OnInit {

  loan : Loan[];
  application : Application;
  appNo: number;
  phoneNo: String;
  applicationFound : boolean = false;
  loanNoFound : boolean = false;
  constructor(private loanService : LoanTrackerService, private loanAccNo : LoanAccountNoService) { }

  ngOnInit(): void {

    
  }
  Tracker(ApplicationNo : number, PhoneNo : String){
  console.log("Tracking...");
   this.loanService.LoanTrackerService(ApplicationNo,PhoneNo).subscribe(
     
  (data: Application)=>
  { console.log(data);
    this.application = data;
    if (this.application != null){
      this.applicationFound = true;
      
    }
   
  },
  (err: any)=>{
    console.log(err);
  }
   )
  }
  displayAccNo(ApplicationNo : number){
    console.log("Fetching Account No...");
    this.loanAccNo.LoanAccountNoService(ApplicationNo).subscribe(
      (data: Loan[])=>
  { console.log(data);
    this.loan = data;
    if (this.loan != null){
      this.loanNoFound = true;
      
    }
   
  },
  (err)=>{
    console.log(err);
  }
   )
    
  }
}
