import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {

  loan:any = null;
  tenure:any = null;
  roi:any = null;
  emi:any = 0;
  calc=0
  calc1=0;
  calc2=0;

  income:any = null;
  roiEligible:any = null;
  eligibleAmount:any = 0;

  constructor() { }

  ngOnInit(): void {
  }

  calculate() {
    //this.roi = this.roi/100;
   // console.log("--->",this.loan * this.roi * ((1+this.roi ^ this.tenure) / (1+this.roi)^this.tenure-1));
    
   // this.emi = this.loan * this.roi * (((1+this.roi )^ this.tenure) / ((1+this.roi)^this.tenure-1));

    this.calc1 = (1.01) ^ this.tenure;
    this.calc2 = ((1.01) ^ this.tenure) - 1;
    this.calc = this.calc1 / this.calc2;
    this.emi = this.loan * (.01) * this.calc;
   // P*R*{((1+R)^n)/((1+R)^n-1)}
  }

  clear() {
    this.loan = null;
    this.tenure = null;
    this.roi = null;
    this.emi = 0;
  }

  calculateEligible() {
    this.eligibleAmount = 60 * (0.6 * this.income);
  }

  clearEligible() {
    this.income = null;
    this.roiEligible = null;
    this.eligibleAmount = 0;
  }

}
