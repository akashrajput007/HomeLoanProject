
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject, Observable } from 'rxjs';
import { getEMI } from '../login/login-dashboard/getEmi';
import { User } from '../modals/user';

@Injectable({
  providedIn: 'root'
})
export class CommonService {
  url="http://localhost:8085";
  apis={
    fetchBalance:"/fetechBalance",
    userLogin:"/validation/userLogin",
    forgotPassword: "/validation/forgotPassword/",
    confirmPassword: '/validation/newPassword/'
  }
  loginSub = new Subject();

  constructor(private http:HttpClient) { }

  ngOnInit() {
  

  }
  fetchBalance(num:any):Observable<any>{
    return this.http.get(this.url+this.apis.fetchBalance + "/" + Number(num));
  }
  login(userObj:User){
    return this.http.post(this.url+this.apis.userLogin, userObj, {responseType:'text'});
  }
  getEMIService(emailId: string): Observable<getEMI>{
    return this.http.get<getEMI>(this.url + "/comp/getEmi/" + emailId);
  }
  insertAndGetEmiService(custId: number): Observable<getEMI>{
    return this.http.get<getEMI>(this.url + "/comp/insertEmiDetails/" + custId);
  }
  forgotPassword(num:any):Observable<string>{
    // const header = {
    //   headers: new HttpHeaders({
    //     "Content-Type": "application/json"
    //   })
    // }
    return this.http.get<string>(this.url+this.apis.forgotPassword + "/" + Number(num));
    }
 
  confirmPassword(num:any, password: any):Observable<any>{
    const header = {
      headers: new HttpHeaders({
        "Content-Type": "application/json"
      })
    }
    return this.http.put(this.url+this.apis.confirmPassword + "/" + Number(num) +"/"+password, '',header);
  }
}