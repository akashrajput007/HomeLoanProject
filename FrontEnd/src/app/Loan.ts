import { Application } from "./Application";

export class Loan{
   	loanAccNo : number;
	amountPaid : number;
	amountWithInterest : number;
	approvedAmount : number;
	balance : number;
	emiAmount : number;
	endDate : Date;
	startDate  : Date;
	application : Application;
}