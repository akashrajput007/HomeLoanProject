import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AllDetails } from '../application/AllDetails';
import { DashboardServiceService } from '../dashboard-service.service';
import { CommonService } from '../services/common.service';


@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {
  custId: number ;
  allDetails: AllDetails[] = [];
  tempAllDetails: AllDetails[] = [];
  constructor(private AllDetailsService : DashboardServiceService, private commonService: CommonService, private router: Router) { }

  ngOnInit(): void {
    this.AllDetailsService.findAllDetailsService().subscribe(
      (data: AllDetails[]) => {
        this.allDetails = data;
        this.tempAllDetails = data;
      },
      (err: any) => {
        console.log(err);
      } 
    );
  }
  approve(custId : number) {
    this.AllDetailsService.approveLoanService(custId)
    .subscribe(
      (data: string) => {
        if (data == null) {
          console.log("Loan Approved");
        }
      },
      (err) => {
        console.log(err);
      }
    )
    alert("Application Approved")
  }
  reject(custId : number) {
    this.AllDetailsService.updateStatusService(custId).subscribe(
      (data: any) => {
        if (data == null) {
          console.log("Status Updated");
        }
      },
      (err: any) => {
        console.log(err);
      }
    )
    alert("Application Rejected")
  }
  delete(custId: number) 
  {
    
    console.log('customer number to delete '+  custId);
    this.AllDetailsService.deleteAllDetailsService(custId).
    subscribe((data:any) =>
    {
       
      console.log('log is ' + data);
        if(data == null ) {
           this.tempAllDetails = this.allDetails.filter(c=>(c.customer.custId != custId));

          console.log('from deleteEmployee() '+ data); 
                    // console.log(this.tempEmployees);
          this.allDetails = this.tempAllDetails;
          console.log('Employee deleted '+ custId);
        }
      }, (err: any) => { 
          console.log(err);
      });

      alert("Application Deleted");
  
    } 
  updateAllDetailsArray(){
    if (this.custId == 0) {
      console.log('its zero' + this.custId);
      this.tempAllDetails = this.allDetails;
    }
    else {
      console.log("its not zero" + this.custId);
      this.tempAllDetails = this.allDetails?.filter(
        c => (c.customer.custId == this.custId));
    
      console.log("Length of Employee : " + this.tempAllDetails?.length);
     }
  }
  logout() {
    localStorage.clear();
    this.commonService.loginSub.next('Login');
    this.router.navigateByUrl("/login");
  }
}
