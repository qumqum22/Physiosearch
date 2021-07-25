import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AgmCoreModule } from '@agm/core';

import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {HomeComponent} from './home/home.component';
import {HomeRoutingModule } from './home-routing.module';
import { NavigationBarComponent } from './navigation-bar/navigation-bar.component';


@NgModule({
  declarations: [
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    NavigationBarComponent],
  imports: [ 
    CommonModule,
    HomeRoutingModule,
    AgmCoreModule,
  ],

  exports: [],
})
export class HomeModule { }
