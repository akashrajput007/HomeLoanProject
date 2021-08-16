import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';




import { CompleteDetailsService } from 'src/app/complete-details.service';
import { FileUploadService } from 'src/app/file-upload.service';
import { Address } from '../address-details/Address';
import { AllDetails } from '../AllDetails';
import { Collateral } from '../collateral-details/Collateral';
import { Employment } from '../employment-details/Employment';
import { Application } from '../loan-details/Application';
import { Customer } from '../personal-details/Customer';
import { Property } from '../property-details/Property';
import { DocumentUpload } from './DocumentUpload';


@Component({
  selector: 'app-upload-documents',
  templateUrl: './upload-documents.component.html',
  styleUrls: ['./upload-documents.component.css']
})
export class UploadDocumentsComponent implements OnInit {

  //doc: Document = new Document();
  tempCustomer: any;
  myCustomer: Customer;
  // tempProperty: any;
  // myProperty: Property;
  // tempEmployment: any;
  // myEmployment: Employment;
  // tempApplication: any;
  // myApplication: Application;
  // tempCollateral: any;
  // myCollateral: Collateral;
  // tempAddress: any;
  // myAddress: Address;
  // tempDetails: any;
  //allDetails: AllDetails;
  // tempDoc: any;
  // mydoc: Document;

  doc: DocumentUpload = {
    //docId:0,
    
    agreementToSale: "",
    aadharCard: "",
    itrc: "",
    loa: "",
    noc: "",
    panCard: "",
    photograph: "",
    salarySlip: "",
    signature: "",
    voterId: "",
    bankStatement: "",
    customer: new Customer()
  }


  // allDetails: AllDetails = {
  //   customer: new Customer(),
  //   property: new Property,
  //   application: new Application(),
  //   employment: new Employment(),
  //   address: new Address(),
  //   collateral: new Collateral(),
  //   document: new DocumentUpload()
  // };





  loading: boolean = false; // Flag variable
  file: File; // Variable to store file
  aadharNo: string = "";
  map = new Map();
  permitted: boolean = false;
  counter: number=0;

  constructor(private router: Router, private completeDetails: CompleteDetailsService, private fileUploadService: FileUploadService) {

    this.tempCustomer = sessionStorage.getItem("customerKey");
    this.myCustomer = JSON.parse(this.tempCustomer);
    this.aadharNo = this.myCustomer.aadharNumber;
  }

  ngOnInit(): void {
  }

  
  clicked() {

    for (let [key, value] of this.map) {
      this.onUpload(this.map.get(key), key,this.aadharNo);    
    }   

    this.map.clear();
    this.router.navigateByUrl("/application/confirm");
 
  }


  
  back() {
    this.router.navigateByUrl("/application/collateral-details");
  }

  onChange(event: any) {
    this.file = event.target.files[0];
    if (this.file == undefined) {
      this.map.delete(event.target.id);
    }
    else {
      this.map.set(event.target.id, this.file);
    }
  }

  onUpload(fileObj: File,key:any ,aadharNo: string | null) {
  
console.log("onUpload() called..")
    this.fileUploadService.upload(fileObj, this.aadharNo).subscribe(
      (data: any) => {
      //  for (let [key, value] of this.map) {
          if (key == "photograph") {
            this.doc.photograph = data;
            console.log("photo=",this.doc.photograph)
          }
          else if (key == "signature") {
            this.doc.signature = data;
            console.log("Signature=",this.doc.signature)
          }
          else if (key == "aadhar-card") {
            this.doc.aadharCard = data;
            console.log("aadharcard=",this.doc.aadharCard)
           }
          else if (key == "pan-card") {
            this.doc.panCard = data;
            console.log("pancard = ",this.doc.panCard)
          }
          else if (key == "voter-id") {
            this.doc.voterId = data;
            console.log("voter = ",this.doc.voterId)
          }
          else if (key == "bank-statement") {
            this.doc.bankStatement = data;
            console.log("bankstatem = " , this.doc.bankStatement)
          }
          else if (key == "salary") {
            this.doc.salarySlip = data;
            console.log("salaryslip = ",this.doc.salarySlip)
          }
          else if (key == "loa") {
            this.doc.loa = data;
            console.log("loa",this.doc.loa)
          }
          else if (key == "itrc") {
            this.doc.itrc = data;
            console.log("itrc",this.doc.itrc)
          }
          else if (key == "noc") {
            this.doc.noc = data;
            console.log("noc",this.doc.noc)
          }
          else if (key == "agreementToSale") {
            this.doc.agreementToSale = data;
            console.log("agrettosale = ", this.doc.agreementToSale)
          }

          sessionStorage.setItem("documentKey", JSON.stringify(this.doc));
          console.log("session storage of document key = ", sessionStorage.getItem('documentKey'))
          console.log("------------------------------------------------------------------------")
        //}
     
      },
      (err: any) => {
        console.log(err);
      }
    );
  }
}
