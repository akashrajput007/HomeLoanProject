import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../personal-details/Customer';
import { Property } from './Property';

@Component({
  selector: 'app-property-details',
  templateUrl: './property-details.component.html',
  styleUrls: ['./property-details.component.css']
})
export class PropertyDetailsComponent implements OnInit {

 // property: Property;

  // tempProperty: any;
  // myProperty: Property;
  property: Property = {
   // pId:0,
    cost: 0,
    propertyLocation : "",
    propertyName : "",
	  customer : new Customer()
  }
  
  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  clicked(){
    if(this.property.propertyLocation == "") {
      alert("please enter the property location")
    }
    else if(this.property.propertyName == "") {
      alert("please enter the property name")
    }
    else if(this.property.cost < 10000) {
      alert("As per our policy, loan cannot be sanctioned for property of cost below Rs. 10,000")
    }
    else{
      sessionStorage.setItem("propertyKey", JSON.stringify(this.property));
      this.router.navigateByUrl("/application/loan-details");
    }
  }

  back() {
    this.router.navigateByUrl("/application/employment-details");
  }
}
