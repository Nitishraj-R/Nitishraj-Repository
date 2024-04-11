import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { LoginService } from './login.service';
import { GeneratedToken } from '../model/generated-token';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  @ViewChild('usernameInput') usernameInput!: ElementRef<HTMLInputElement>;
  @ViewChild('passwordInput') passwordInput!: ElementRef<HTMLInputElement>;
  @ViewChild('loginButton') loginButton!: ElementRef<HTMLButtonElement>;
  @ViewChild('registerButton') registerButton!: ElementRef<HTMLButtonElement>;

  invalidUser=false;
  userName:string="";
  password:string="";
  constructor(private loginService:LoginService,private generatedToken:GeneratedToken,private router:Router){}

  ngOnInit(): void {
    
  }

  ngAfterViewInit(){
    this.loginButton.nativeElement.addEventListener('click',()=>{
      this.userName=this.usernameInput.nativeElement.value;
      this.password=this.passwordInput.nativeElement.value;
      if(this.userName!=="" && this.password!=""){
        console.log("userName->"+this.userName+" \npassword->"+this.password);
        this.loginService.verifyLogin(this.userName,this.password)?.subscribe(response=>{
          console.log("response",response);
          
          if(response){

            this.generatedToken.setToken(response.data.token);
            console.log("generated token ->",this.generatedToken.getToken());
            this.router.navigate(['/dashboard']);
            console.log("navigating to dashboard");
            this.invalidUser=false;
          }
          else{
            console.log("No response is found for this request");
            this.invalidUser=true;
          }
        })
      }
      else{
        console.log("user Name or password is not given");
        
      }
    })

    // this.registerButton.nativeElement.addEventListener('click',()=>{
    //   this.router.navigate(['/register']);
    // })

  }
  
}
