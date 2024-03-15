import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GarageComponent } from './garage/garage.component';
import { ClientComponent } from './client/client.component';
import { VehiculeComponent } from './vehicule/vehicule.component';
import { DocumentComponent } from './document/document.component';

@NgModule({
  declarations: [
    AppComponent,
    GarageComponent,
    ClientComponent,
    VehiculeComponent,
    DocumentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
