import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Subject } from 'rxjs';
import { AdminValidationService } from '../admin-validation.service';
import { Admin } from '../modals/Admin';
import { User } from '../modals/user';
import { CommonService } from '../services/common.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  // isUser:boolean = false;
  // userDetails:User = new User();

  isUser:boolean = false;
  userDetails:User = new User();
  adminData : Admin;
  adminFound : boolean = false;
  username : String;
  password : String;

  constructor(private commonService: CommonService, private toastr: ToastrService, private router: Router,private adminService : AdminValidationService) { }

  ngOnInit(): void {
  }

  save(event:any) {
    event.preventDefault();
    if(this.userDetails && this.userDetails.emailId && this.userDetails.password) {
      this.commonService.login(this.userDetails).subscribe((data:any)=>{
      sessionStorage.setItem("emailId", JSON.stringify(this.userDetails.emailId));
      if(data){
         if (data == "Success") {
          alert("Success");
          this.router.navigateByUrl('/login/login-dashboard');
          this.commonService.loginSub.next('User Details');
          localStorage.setItem('name',JSON.stringify(this.userDetails.emailId));
         }
         else if(data == "Password Mismatch") {
            alert("Password mismatch");
         }
         else {
              alert("user does not exists!!")
         }
         
        }
    },error =>{
     console.log(error);
      //console.log("we are inside error block")
      
      // if(error.error.text == "Success"){
      //   this.router.navigateByUrl('/login/login-dashboard');
      //   this.commonService.loginSub.next('User Details');
      //   localStorage.setItem('name',JSON.stringify(this.userDetails.emailId));
      //   this.toastr.success(error.error.text,error.error.text);
      // }else{
      //   this.toastr.error(error.error.text,"Error");
    
      // }
      
    })
    } else {
      if(this.userDetails && !this.userDetails.emailId && !this.userDetails.password) {
      //  this.toastr.error("Please enter Email Id or Password","Error");
        alert("Please enter Email Id or Password")
      } else if(!this.userDetails.emailId) {
       // this.toastr.error("Please enter Email Id","Error");
        alert("Please enter Email Id")
      } else {
       // this.toastr.error("Please enter Password","Error");
        alert("Please enter Password")
      }
    }
    
  }

  AdminValidation(username : String, password : String){
  //  console.log("Validating Admin...");
    this.adminService.AdminValidationService(username,password).subscribe(
      (data: Admin)=>
    { console.log(data);
      this.adminData = data;
      if (this.adminData != null){
    //    console.log("Correct Credentials");
       // this.toastr.success("Login Successful")
        alert("Login Successful")
        this.adminFound = true;
               this.router.navigateByUrl("/admin-dashboard");
            }
            else if (this.adminData == null){
             // this.toastr.error("Check Email / Password")
              alert("Invalid Credentials")
              //console.log("Invalid Credentials");
            }
     
    },
    (err: any)=>{
      console.log(err);
    }
    )
  
    }
    forgot(event:any){
      event.preventDefault();
      this.router.navigateByUrl("/login/forgot-password");
      }

  admin() {
    this.isUser = true;
  }

  user() {
    this.isUser = false;
  }

  forgotAdmin(event:any) {
    event.preventDefault();
  }

  saveAdmin(event:any) {
    event.preventDefault();
  }
}
