import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { GeneratedToken } from '../model/generated-token';
import { FormBuilder, FormGroup } from '@angular/forms';
import { RegisterService } from './register.service';
import { Router } from '@angular/router';
import { Organization } from '../model/organization';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit{

  // @ViewChild('emplIdInput') emplIdInput!:ElementRef<HTMLInputElement>
  // @ViewChild('firstnameInput') firstnameInput!:ElementRef<HTMLInputElement>
  // @ViewChild('lastnameInput') lastnameInput!:ElementRef<HTMLInputElement>
  // @ViewChild('mailInput') mailInput!:ElementRef<HTMLInputElement>
  // @ViewChild('passwordInput') passwordInput!:ElementRef<HTMLInputElement>
  // @ViewChild('joiningInput') joiningInput!:ElementRef<HTMLInputElement>
  // @ViewChild('birthInput') birthInput!:ElementRef<HTMLInputElement>
  // @ViewChild('mobileInput') mobileInput!:ElementRef<HTMLInputElement>
  // @ViewChild('designationInput') designationInput!:ElementRef<HTMLInputElement>
  // @ViewChild('rolesInput') rolesInput!:ElementRef<HTMLSelectElement>
  // @ViewChild('registerButton') registerButton!:ElementRef<HTMLButtonElement>

  // emplId:string='';
  // firstName:string='';
  // lastName:string='';
  // mail:string='';
  // passord:string='';
  // joiningdate:string="";
  // birthDate:string='';
  // mobile:string='';
  // designation:string='';
  // roles:string='';

  registerform:FormGroup;
  organizations:Organization[]=[];
  ngOnInit(): void {
    // this.registerService.getOrganizations().subscribe((response)=>{
    //   if(response){
    //     console.log("Organization is present");
    //     this.organizations=response;
    //   }
    //   else{
    //     console.log("no organization is present");
        
    //   }
    // });
    console.log('List of organizations->',this.organizations);

    
  }


  
  constructor(private formBuilder:FormBuilder,private registerService:RegisterService,private router:Router,private organization:Organization){
    this.registerform=this.formBuilder.group({
      "employeeId":"",
      "firstName":"",
      "lastName":"",
      "emailId":"",
      "password":"",
      "dateOfJoining":"",
      "dateOfBirth":"",
      "mobileNumber":"",
      "designation":"",
      "role":"",
      "organization":null
      // "organization":organization
    })
  }

  submit(){
    console.log("employee object->",this.registerform.value);
    
    console.log("empId->",this.registerform.value.employeeId);
    console.log("roles->",this.registerform.value.role);
    console.log("Org->",this.registerform.value.organization);

    
    this.registerService.saveEmployee(this.registerform.value).subscribe(response=>{
      console.log('response',response);
      if(response){
        console.log("response.toString->",response.toString());
        // this.router.navigate(['/dashboard']);
        localStorage.setItem("Eid",this.registerform.value.Id)
        // console.log("this.registerform.value.organization.value->",this.registerform.value.organization.value);
          
        // if(this.registerform.value.organization.value=='other'){
          
        //   this.router.navigate(['/organization']);
        // }
        // else{
          this.router.navigate(['/dashboard']);
        // }
      }
      
    })
  }
}
