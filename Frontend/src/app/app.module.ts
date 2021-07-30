
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {AgmCoreModule} from '@agm/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MatToolbarModule} from '@angular/material/toolbar'

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyAGaa8-lSBawG35ucBvTEmHGOx2PuD6Nug'
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
