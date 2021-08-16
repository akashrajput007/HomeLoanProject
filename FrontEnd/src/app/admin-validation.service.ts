import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Admin } from './modals/Admin';

@Injectable({
  providedIn: 'root'
})
export class AdminValidationService {
  baseURL: string = 'http://localhost:8085/adminVal/'
  
  constructor(private myhttp: HttpClient) { }
  AdminValidationService(username : String, password : String): Observable<any>{
    return this.myhttp.get<Admin>(this.baseURL+"getAdmin/"+username+"/"+password);
  }
}
