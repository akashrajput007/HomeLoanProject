import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { CommonService } from 'src/app/services/common.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  userId: any = null;

  constructor(private router: Router, private commonService: CommonService, private toastr: ToastrService) { }

  ngOnInit(): void {
  }

  submit() {
    console.log(this.userId)
    if(this.userId) {
      console.log("inside if")
      this.commonService.forgotPassword(this.userId).subscribe((data:string) => {
        console.log("data is :",data);
        
        if(data == "Customer exist"){
          this.router.navigateByUrl('/login/confirm-password');
          localStorage.setItem('userId',JSON.stringify(this.userId));
          console.log("User Found")
        }else{
          console.log("error")
        }
        
      }, 
      (err)=> {
        console.log("Error")
        localStorage.setItem('userId',JSON.stringify(this.userId));
        this.router.navigateByUrl('/login/confirm-password');
        
      }
      )
    } else {
      console.log("Please enter user id")
    }
  }

  back() {
    this.router.navigateByUrl("/login");
  }
}
