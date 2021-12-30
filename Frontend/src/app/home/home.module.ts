import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AgmCoreModule } from '@agm/core';

import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {HomeComponent} from './home.component';
import {HomeRoutingModule } from './home-routing.module';
import { NavigationBarComponent } from './navigation-bar/navigation-bar.component';

import { ProfileComponent } from './profile/profile.component';
import { SettingsComponent } from './settings/settings.component';
import { StartComponent } from './start/start.component';
import { SearchComponent } from './search/search.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatTabsModule } from '@angular/material/tabs';
import { MatSelectModule} from '@angular/material/select';
import { MatFormFieldModule} from '@angular/material/form-field';
import { MatInputModule} from '@angular/material/input';
import { MatTableModule} from '@angular/material/table';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ConversationComponent } from './conversation/conversation.component';
import { ClinicComponent } from './clinic/clinic.component';
import { NotfoundComponent } from './notfound/notfound.component';

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
    ClinicComponent,
    NotfoundComponent],
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
    MatTableModule,
    MatSlideToggleModule,
  ],

  exports: [],
})
export class HomeModule { }
