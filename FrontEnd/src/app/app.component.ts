import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommonService } from './services/common.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'home-loan';
  type = 'Login';
  constructor(private commonService: CommonService, private router: Router) {}

  ngOnInit() {
    this.commonService.loginSub.subscribe((data:any) => {
      this.type = data;
    })
    let localName = localStorage.getItem("name");
    if(localName) {
      this.type = "User Details";
    }
  }

  features() {
    this.router.navigateByUrl("/features");
  }

  calculator() {
    this.router.navigateByUrl("/calculator");
  }

  documents() {
    this.router.navigateByUrl("/documents");
  }
}
