import { Customer } from "src/app/application/personal-details/Customer";
import { Application } from "src/app/loan-tracker/Application";
import { Loan } from "src/app/loan-tracker/Loan";
import { Emi } from "./EMI";



export class getEMI {
    customer: Customer;
	loan: Loan;
    emiList: Emi[];
    application: Application;
}