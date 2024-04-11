import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Organization } from '../model/organization';

@Injectable({
  providedIn: 'root'
})
export class OrganizationService {

  constructor(private http:HttpClient,private organization:Organization) { }

  url:string="http://localhost:8080/";
  token:string | null=localStorage.getItem("token");

  updateOrganization(organization:Organization){

    let headers=new HttpHeaders();
    headers.set('Content-Type','application/json')

    if(this.token!=null){
      headers.set('Authorization',this.token);
    }
    try{
    return this.http.put(this.url+"/organization/updateOrganization",organization,{headers});
    }
    catch(error){
      console.error("error->"+error);
      return null;
      
    }
  }
}
