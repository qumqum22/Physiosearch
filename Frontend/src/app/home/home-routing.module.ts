import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router'
import { RegisterComponent } from './register/register.component'
import { LoginComponent } from './login/login.component'
import { ClinicComponent } from './clinic/clinic.component'
import { HomeComponent } from './home.component';
import { SettingsComponent } from './settings/settings.component';
import { ProfileComponent } from './profile/profile.component';
import { StartComponent } from './start/start.component';
import { SearchComponent } from './search/search.component';
import { ConversationComponent } from './conversation/conversation.component';
import {NotfoundComponent} from './notfound/notfound.component';

export const routes: Routes = [
    { path: '', component: HomeComponent,
    children: [
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'profile/:id', component: ProfileComponent },
    { path: 'clinic/:id', component: ClinicComponent },
    { path: 'settings', component: SettingsComponent },
    { path: 'conversation', component: ConversationComponent },
    { path: 'search', component: SearchComponent },
    { path: 'error/:errorType', component: NotfoundComponent },
    { path: '', component: StartComponent },
    { path: '**', component: NotfoundComponent}
    ]
    },
  ]
  
  @NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule ]
  })

  export class HomeRoutingModule { }