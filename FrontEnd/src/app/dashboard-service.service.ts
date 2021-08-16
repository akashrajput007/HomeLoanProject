import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AllDetails } from './application/AllDetails';

@Injectable({
  providedIn: 'root'
})
export class DashboardServiceService {
  baseURL: string = 'http://localhost:8085/'
  constructor(private myhttp: HttpClient) { }
  
  approveLoanService(custId: number):Observable<string>{
     return this.myhttp.get<string>(this.baseURL + "comp/approveLoan/" + custId);
  }

  findAllDetailsService() : Observable<AllDetails[]> {
    return this.myhttp.get<AllDetails[]>(this.baseURL + "comp/getAllDetails");
  }

  deleteAllDetailsService(custId : number): Observable<string> {
    return this.myhttp.delete<string>(this.baseURL + "cust/deleteAllDetails/" + custId);
  }

  updateStatusService(custId: number) : Observable<string>{
    console.log(custId);
    return this.myhttp.get<string>(this.baseURL + "application/updateStatus/" + custId);
  }
}
