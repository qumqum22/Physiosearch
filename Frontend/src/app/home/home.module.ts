import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AgmCoreModule } from '@agm/core';

import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {HomeComponent} from './home.component';
import {HomeRoutingModule } from './home-routing.module';
import { NavigationBarComponent } from './navigation-bar/navigation-bar.component';

import { MatToolbarModule } from '@angular/material/toolbar';
import { ProfileComponent } from './profile/profile.component';
import { SettingsComponent } from './settings/settings.component';
import { StartComponent } from './start/start.component';

@NgModule({
  declarations: [
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    NavigationBarComponent,
    ProfileComponent,
    SettingsComponent,
    StartComponent],
  imports: [ 
    CommonModule,
    HomeRoutingModule,
    AgmCoreModule,
    MatToolbarModule
  ],

  exports: [],
})
export class HomeModule { }
