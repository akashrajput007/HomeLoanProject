import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../personal-details/Customer';
import { Address } from './Address';

@Component({
  selector: 'app-address-details',
  templateUrl: './address-details.component.html',
  styleUrls: ['./address-details.component.css']
})
export class AddressDetailsComponent implements OnInit {


  // address: Address;

  address: Address = {
    //addressId : 0,
    address : "",
    city : "",
    pinCode : 0,
    state : "",
    customer : new Customer()
  };

  constructor(private router: Router) { }

  ngOnInit(): void {
  
  }
  clicked(){
    if(this.address.address == "") {
      alert("Please enter address")
    }
    else if(this.address.city == "" ) {
      alert("Please enter city")
    }
    else if(this.address.state == "" ) {
      alert("Please enter state")
    }
    else{
    sessionStorage.setItem("addressKey", JSON.stringify(this.address));
    this.router.navigateByUrl("/application/employment-details");
    }
  }

  back() {
    this.router.navigateByUrl("/application");
  }

    


}
