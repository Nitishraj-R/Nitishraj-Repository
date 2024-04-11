import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { OrganizationComponent } from './organization/organization.component';
import { AssetCreationComponent } from './asset-creation/asset-creation.component';

const routes: Routes = [
  {path: '',redirectTo: '/login', pathMatch:'full'},
  { path: 'dashboard', component: DashboardComponent },
  { path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path:'organization', component:OrganizationComponent},
  {path:'assetcreation', component:AssetCreationComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
