import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CompleteDetailsService } from 'src/app/complete-details.service';
import { Address } from '../address-details/Address';
import { AllDetails } from '../AllDetails';
import { Collateral } from '../collateral-details/Collateral';
import { Employment } from '../employment-details/Employment';
import { Application } from '../loan-details/Application';
import { Customer } from '../personal-details/Customer';
import { Property } from '../property-details/Property';
import { DocumentUpload } from '../upload-documents/DocumentUpload';

@Component({
  selector: 'app-confirmation',
  templateUrl: './confirmation.component.html',
  styleUrls: ['./confirmation.component.css']
})
export class ConfirmationComponent implements OnInit {
  tempCustomer: any;
  myCustomer: Customer;
  tempProperty: any;
  myProperty: Property;
  tempEmployment: any;
  myEmployment: Employment;
  tempApplication: any;
  myApplication: Application;
  tempCollateral: any;
  myCollateral: Collateral;
  tempAddress: any;
  myAddress: Address;
  tempDetails: any;
  //allDetails: AllDetails;
  tempDoc: any;
  mydoc: DocumentUpload;

  allDetails: AllDetails = {
    customer: new Customer(),
    property: new Property,
    application: new Application(),
    employment: new Employment(),
    address: new Address(),
    collateral: new Collateral(),
    document: new DocumentUpload()
  };
  constructor(private router: Router, private completeDetails : CompleteDetailsService) { 


    
  }

  ngOnInit(): void {

   
  }

  clicked() {


    this.tempCustomer = sessionStorage.getItem("customerKey");
    this.myCustomer = JSON.parse(this.tempCustomer);
    this.allDetails.customer = this.myCustomer;


    this.tempProperty = sessionStorage.getItem("propertyKey");
    this.myProperty = JSON.parse(this.tempProperty);
    this.allDetails.property = this.myProperty;


    this.tempEmployment = sessionStorage.getItem("employmentKey");
    this.myEmployment = JSON.parse(this.tempEmployment);
    this.allDetails.employment = this.myEmployment;

    this.tempApplication = sessionStorage.getItem("applicationKey");
    this.myApplication = JSON.parse(this.tempApplication);
    this.allDetails.application = this.myApplication;

    this.tempCollateral = sessionStorage.getItem("collateralKey");
    this.myCollateral = JSON.parse(this.tempCollateral);
    this.allDetails.collateral = this.myCollateral;

console.log("networth from confirmation page = == ", this.allDetails.collateral.networth);


    this.tempAddress = sessionStorage.getItem("addressKey");
    this.myAddress = JSON.parse(this.tempAddress);
    this.allDetails.address = this.myAddress;
    console.log("this is the allDetails.document = ", this.allDetails.address);

    this.tempDoc = sessionStorage.getItem("documentKey");
    console.log(this.tempDoc)
    this.mydoc = JSON.parse(this.tempDoc);
    this.allDetails.document = this.mydoc;
    console.log("this is the allDetails.document = ", this.allDetails.document);
    this.completeDetails.insertAllDetailsService(this.allDetails).subscribe(
      (data: any) => {
        console.log("subscribe");
        console.log("Application No.",data);
        localStorage.setItem("applicationNo",JSON.stringify(data));
      },
      (err: any) => {
        console.log(err);
      }
    );

    sessionStorage.clear()
    this.router.navigateByUrl("/application/form-submitted");
  }

  prepareData() {

//    console.log("prepare data called")

   


  }

}
