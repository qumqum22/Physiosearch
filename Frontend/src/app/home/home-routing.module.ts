import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router'
import { RegisterComponent } from './register/register.component'
import { LoginComponent } from './login/login.component'
import { HomeComponent } from './home/home.component';
import { SettingsComponent } from './settings/settings.component';
import { ProfileComponent } from './profile/profile.component';

export const routes: Routes = [
    { path: '', component: HomeComponent }, // default route of the module
    { path: 'home', component: HomeComponent },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'profile', component: ProfileComponent },
    { path: 'settings', component: SettingsComponent },
    //{ path: '**', component: ErrorPageComponent}

  ]
  
  @NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule ]
  })

  export class HomeRoutingModule { }