import {APP_INITIALIZER, NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GarageComponent } from './garage/garage.component';
import { ClientComponent } from './client/client.component';
import { VehiculeComponent } from './vehicule/vehicule.component';
import { DocumentComponent } from './document/document.component';
import {HttpClientModule} from "@angular/common/http";
import {KeycloakAngularModule, KeycloakService} from "keycloak-angular";

/**
 * service de keycloak qui fonctionne à travers les modules et qui s'execute au demarrage de l'appli
 * @param keycloak
 */
function initializeKeycloak(keycloak: KeycloakService) {
  return () =>
    keycloak.init({
      config: {
        url: 'http://localhost:8080',
        realm: 'sma-realm',
        clientId: 'angular-module-frontend'
      },
      initOptions: {
        onLoad: 'login-required',
        checkLoginIframe: true,
        // silentCheckSsoRedirectUri:
        //   window.location.origin + '/assets/silent-check-sso.html'
      },
      enableBearerInterceptor: true,
      bearerPrefix: 'Bearer',
      bearerExcludedUrls: [
        '/assets',
        '/clients/public']
    });
}
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
    AppRoutingModule,
    HttpClientModule,
    KeycloakAngularModule
  ],
  providers: [
    {
      provide: APP_INITIALIZER,
      useFactory: initializeKeycloak,
      multi: true,
      deps: [KeycloakService]
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
