
import { Address } from "./address-details/Address";
import { Collateral } from "./collateral-details/Collateral";
import { Employment } from "./employment-details/Employment";
import { Application } from "./loan-details/Application";
import { Customer } from "./personal-details/Customer";
import { Property } from "./property-details/Property";
import { DocumentUpload } from "./upload-documents/DocumentUpload";

export class AllDetails {
    customer: Customer;
    property: Property;
    application: Application;
    employment: Employment;
    address: Address;
    collateral: Collateral;
    document: DocumentUpload;
  }