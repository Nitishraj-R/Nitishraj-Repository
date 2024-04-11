import { Component, ElementRef, ViewChild } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {

  
  constructor(private router:Router){}

  @ViewChild('registerButton') registerButton!: ElementRef<HTMLButtonElement>;
  @ViewChild('logout') logout!:ElementRef<HTMLButtonElement>;

  ngAfterViewInit(){
    this.logout.nativeElement.addEventListener("click",()=>{
      console.log("Before removing token->",localStorage.getItem("token"));
      
      localStorage.removeItem("token")
      console.log("After removing token->",localStorage.getItem("token"));
      this.router.navigate(['/login']);
    })

    this.registerButton.nativeElement.addEventListener('click',()=>{
      this.router.navigate(['/register']);
    })
  }

  
}
