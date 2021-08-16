import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { CommonService } from 'src/app/services/common.service';

@Component({
  selector: 'app-confirm-password',
  templateUrl: './confirm-password.component.html',
  styleUrls: ['./confirm-password.component.css']
})
export class ConfirmPasswordComponent implements OnInit {

  newPassword:any = null;
  confirmPassword:any = null;

  constructor(private commonService: CommonService, private router: Router, private toastr: ToastrService) { }

  ngOnInit(): void {
  }

  submit() {

    if(this.newPassword && this.confirmPassword) {
      let newPass = this.newPassword.trim();
      let confirmPass = this.confirmPassword.trim();
      if(newPass == confirmPass) {
        let id= localStorage.getItem("userId");
        if(id) {
          console.log("id :", JSON.parse(id));
          id = JSON.parse(id);
          this.commonService.confirmPassword(id,this.newPassword).subscribe((data:any) => {
            console.log("data ",data);
            
          }, error => {
            alert("Password reset successful")
            this.router.navigateByUrl('/login');
          })
        }
      } else {
        alert("New Password and Confirm Password are doesn't match");

      }
    } else if(!this.newPassword && !this.confirmPassword) {
      alert("Please enter New Password and Confirm Password");
    } else if(!this.newPassword) {
      alert("Please enter New Password");
    } else if(!this.confirmPassword) {
      alert("Please enter Confirm Password");
    }
  }

  back() {
    this.router.navigateByUrl("/login/forgot-password");
  }
}
