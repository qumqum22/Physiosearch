import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AgmCoreModule } from '@agm/core';

import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {HomeComponent} from './home.component';
import {HomeRoutingModule } from './home-routing.module';
import { NavigationBarComponent } from './navigation-bar/navigation-bar.component';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatTabsModule } from '@angular/material/tabs';
import { ProfileComponent } from './profile/profile.component';
import { SettingsComponent } from './settings/settings.component';
import { StartComponent } from './start/start.component';
import { SearchComponent } from './search/search.component';
import { MatSelectModule} from '@angular/material/select';
import { MatFormFieldModule} from '@angular/material/form-field';
import { MatInputModule} from '@angular/material/input';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ConversationComponent } from './conversation/conversation.component';
import { ClinicComponent } from './clinic/clinic.component';

@NgModule({
  declarations: [
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    NavigationBarComponent,
    ProfileComponent,
    SettingsComponent,
    StartComponent,
    SearchComponent,
    ConversationComponent,
    ClinicComponent],
  imports: [ 
    CommonModule,
    HomeRoutingModule,
    AgmCoreModule,
    MatToolbarModule,
    MatTabsModule,
    FormsModule, ReactiveFormsModule,
    MatSelectModule,
    MatFormFieldModule, 
    MatInputModule,
  ],

  exports: [],
})
export class HomeModule { }
