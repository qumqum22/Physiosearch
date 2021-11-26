import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router'
import { RegisterComponent } from './register/register.component'
import { LoginComponent } from './login/login.component'
import { HomeComponent } from './home.component';
import { SettingsComponent } from './settings/settings.component';
import { ProfileComponent } from './profile/profile.component';
import { StartComponent } from './start/start.component';
import { SearchComponent } from './search/search.component';
import { ConversationComponent } from './conversation/conversation.component';

export const routes: Routes = [
    { path: '', component: HomeComponent,
    children: [
    { path: '', component: StartComponent },
    // { path: 'profile', component: ProfileComponent },
    { path: 'profile/:id', component: ProfileComponent },
    { path: 'settings', component: SettingsComponent },
    { path: 'conversation', component: ConversationComponent },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'search', component: SearchComponent },
    //{ path: '**', component: ErrorPageComponent}
    ]
    },
  ]
  
  @NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule ]
  })

  export class HomeRoutingModule { }