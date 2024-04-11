import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { AuthRequest } from '../model/auth-request';
import { catchError, of } from 'rxjs';
import { ResponseStructure } from '../model/response-structure';
import { Organization } from '../model/organization';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  // let a:string=""
  constructor(private http:HttpClient,private organization:Organization) { }

  private apiUrl:string="http://localhost:8080/"
  private token:string="";
  

  verifyLogin(userName:string,password:string){
    // let a:string=""
    const headers= new HttpHeaders({'Content-type':'application/json'});
    let authRequest:AuthRequest=new AuthRequest(userName,password);

    console.log('authRequest.userName ->'+authRequest.userName+'authRequest.password ->'+authRequest.password);
    
    let observe=this.http.post<ResponseStructure>(this.apiUrl+'employee/authenticate',authRequest,{headers})
    .pipe(
      catchError((error: HttpErrorResponse | any) => {
        if (error.status === 403) {
          // Handle invalid credentials error
          // throw null;
          return of(null);
        } else {
          // Handle other errors
          return of(null);
        }
      })
    );
    console.log("observe->"+observe);
    
    if(observe){
      observe.subscribe(response=>{
        console.log('response',response);
        
        if(response){
          this.token=response.data.token;
          console.log("response.data.token->"+this.token);
          localStorage.setItem("token",this.token);
          this.organization=response.data.organization;
          localStorage.setItem("org",""+response.data.organization);
          console.log("token",localStorage.getItem("token"));
          console.log("organization->",this.organization);
          
          
        }
      })
      return observe;
    }
    else{
      console.log("unathorized person so no access is provided");
      return null;
    }
  }
}
