import { Component, OnInit } from '@angular/core';
import { CommonService } from '../services/common.service';

@Component({
  selector: 'app-your-account',
  templateUrl: './your-account.component.html',
  styleUrls: ['./your-account.component.css']
})
export class YourAccountComponent implements OnInit {
  balance=null;
  availableBalance=null;
  constructor(private service:CommonService) { }

  ngOnInit(): void {
    //this.fetchBalance();
  }

  check(event: any) {
    event.preventDefault();
    this.fetchBalance();
  }
  fetchBalance(){
    this.service.fetchBalance(this.balance).subscribe((data)=>{
      console.log("data",data);
      if(data){
        this.availableBalance=data;
      }else{
        this.availableBalance=null;
      }
    })
  }
}
