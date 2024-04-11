import { Injectable } from "@angular/core";
import { Organization } from "./organization";

@Injectable({
    providedIn: 'root'
  })
  
export class GeneratedToken {
    token:string="";
    organization:Organization=new Organization();
    // constructor(token:string){
    //     this.token=token;
    // }
    public getToken():string{
        return this.token;
    }

    public setToken(token:string){
        this.token=token;
    }

    public getOrganization():Organization{
        return this.organization;
    }

    public setOrganization(organization:Organization){
        this.organization=organization;
    }
}
