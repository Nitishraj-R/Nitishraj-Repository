import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { OrganizationService } from './organization.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-organization',
  templateUrl: './organization.component.html',
  styleUrls: ['./organization.component.css']
})
export class OrganizationComponent {

  organizationform:FormGroup;
  constructor(private formBuilder:FormBuilder,private organizationService:OrganizationService,private router:Router){
    this.organizationform=this.formBuilder.group({
      'organizationCode':"",
      "name":"",
      "emailId":"",
      "location":"",
      "contactNumber":"",
      "employees":""
    })
  }

  submit(){
    console.log("organization object->",this.organizationform.value);
    
    this.organizationform.value.employees=[localStorage.getItem('Eid')]
    console.log("organization objects emplpoyee object->",this.organizationform.value.employees);

    let observe=this.organizationService.updateOrganization(this.organizationform.value);
    if(observe){
      observe.subscribe((response)=>{
        if(response){
          console.log("response->",response);
          this.router.navigate(['/dashboard'])
        }
        else{
          this.router.navigate(['/organization'])
        }
    });
  }
    
  }
}
