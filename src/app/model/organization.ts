import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
  })

export class Organization {
    organizationId:number=0;
    organizationCode:string="";
    name:string="";
    emailId:string="";
    location:string="";
    contactNumber:string="";

    

     get getOrganizationId(): number {
    return this.organizationId;
  }
  set setOrganizationId(value: number) {
    this.organizationId = value;
  }

  // Getter and setter for organizationCode
  get getOrganizationCode(): string {
    return this.organizationCode;
  }
  set setOrganizationCode(value: string) {
    this.organizationCode = value;
  }

  // Getter and setter for name
  get getName(): string {
    return this.name;
  }
  set setName(value: string) {
    this.name = value;
  }

  // Getter and setter for emailId
  get getEmailId(): string {
    return this.emailId;
  }
  set setEmailId(value: string) {
    this.emailId = value;
  }

  // Getter and setter for location
  get getLocation(): string {
    return this.location;
  }
  set setLocation(value: string) {
    this.location = value;
  }

  // Getter and setter for contactNumber
  get getContactNumber(): string {
    return this.contactNumber;
  }
  set setContactNumber(value: string) {
    this.contactNumber = value;
  }

}
