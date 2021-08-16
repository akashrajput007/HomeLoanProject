import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FileUploadService {
  baseApiUrl: string = "http://localhost:8085/doc/upload-file/";
  // baseApiUrl = "https://file.io"
  tempUrl: string="";

  constructor(private myhttp:HttpClient) { }
  upload(file: any,aadharNo : string ):Observable<any> {
  
      // Create form data
      const formData = new FormData(); 
        
      // Store form name as "file" with file data
      formData.append("file", file, file.name);
      this.tempUrl = this.baseApiUrl + aadharNo;
      console.log("Aadhar No" , aadharNo);
      console.log("This is the temp Url on which file will be sent = ",this.tempUrl);
        
      // Make http post request over api
      // with formData as req
      return this.myhttp.post(this.tempUrl, formData,{responseType:'text'});
}
}
