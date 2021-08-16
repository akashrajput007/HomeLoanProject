import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../personal-details/Customer';
import { Collateral } from './Collateral';

@Component({
  selector: 'app-collateral-details',
  templateUrl: './collateral-details.component.html',
  styleUrls: ['./collateral-details.component.css']
})
export class CollateralDetailsComponent implements OnInit {

  //collateral: Collateral;

  collateral: Collateral = {
    //colId : 0,
    collateralType : "",
    networth : 0,
    customer : new Customer
  };

  constructor(private router: Router) { }

  ngOnInit(): void {
  }
  clicked(){
    sessionStorage.setItem("collateralKey", JSON.stringify(this.collateral));
    this.router.navigateByUrl("/application/upload-documents");
  }

  back() {
    this.router.navigateByUrl("/application/loan-details");
  }

  // getValues(val: any) {
  //   console.log(val);
  //   this.router.navigateByUrl("/application/upload-documents");
  // }
}
