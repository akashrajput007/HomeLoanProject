import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Loan } from './loan-tracker/Loan';


@Injectable({
  providedIn: 'root'
})
export class LoanAccountNoService {
  baseURL: string = 'http://localhost:8085/LoanAccountNo/'
  constructor(private myhttp: HttpClient) { }
  LoanAccountNoService(ApplicationNo : number) : Observable<any> {
    return this.myhttp.get<Loan[]>(this.baseURL+"getLoanAccountNo/"+ApplicationNo);

  }
}
