import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Organization } from '../model/organization';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http:HttpClient,private router:Router) { }

  private url:string="http://localhost:8080/";
    
  saveEmployee(formGroup:FormGroup){


    const token =localStorage.getItem('token')
    // let headers=new HttpHeaders();
    // headers.set("Content-type","application/json")
    // if(token){
     let headers= new HttpHeaders({'Content-type':'application/json'});
      // headers.set("Authorization",token)
    // }
    return this.http.post(this.url+'employee/postEmployee',formGroup,{headers})

  }
   
  getOrganizations():Observable<Organization[]>{
    console.log('getOrg');
    
    let headers=new HttpHeaders();
    const token =localStorage.getItem('token')
    // headers.set("Content-type","application/json")
    if(token){

      headers=new HttpHeaders({
        'Authorization': token,
        'Access-Control-Allow-Origin': 'http://localhost:4200',
        'Content-type':'application/json',
        'Access-Control-Allow-Credentials':'true',
        'Access-Control-Allow-Headers':'Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers,Accept, Authorization'
      
      });
      // headers.set("Authorization",token);
      console.log("headers->",headers);
      
    }
    return this.http.get<Organization[]>(this.url+'organization/getAllOrganizations',{
      headers:headers
      
    })
  }
}
