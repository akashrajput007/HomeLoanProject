import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class LoanTrackerService {
  baseURL: string = 'http://localhost:8085/loanTracker/'
  constructor(private myhttp: HttpClient) { }

  LoanTrackerService(ApplicationNo : number, PhoneNo : String) : Observable<any> {
    return this.myhttp.get<any>(this.baseURL+"getApplication/"+ApplicationNo+"/"+PhoneNo);
}
}
