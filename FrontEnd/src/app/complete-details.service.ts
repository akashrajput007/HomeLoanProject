import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AllDetails } from './application/AllDetails';

@Injectable({
  providedIn: 'root'
})
export class CompleteDetailsService {
  baseURL: string = 'http://localhost:8085/'
  constructor(private myhttp: HttpClient) {

  }
  // this.myCustomer , this.myAddress , this.myEmployment , this.myProperty , this.myApplication , this.myCollateral
  insertAllDetailsService(allDetails : AllDetails): Observable<any> {
    console.log("Service called")  
    console.log("networth from service page = == ", allDetails.collateral.networth);
    return this.myhttp.post<any>(this.baseURL + "comp/upload", allDetails);
   }
}
