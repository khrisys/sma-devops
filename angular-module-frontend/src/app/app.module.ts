import {APP_INITIALIZER, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {GarageComponent} from './garage/garage.component';
import {ClientComponent} from './client/client.component';
import {VehiculeComponent} from './vehicule/vehicule.component';
import {DocumentComponent} from './document/document.component';
import {HttpClientModule} from "@angular/common/http";
import {KeycloakAngularModule, KeycloakService} from "keycloak-angular";
// import {JwtModule} from "@auth0/angular-jwt;



/**
 * service de keycloak qui fonctionne à travers les modules et qui s'execute au demarrage de l'appli
 * @param keycloak
 */
function initializeKeycloak(keycloak: KeycloakService) {
  return () => {
    // const helper = new JwtHelperService();
    // const decodedToken = helper.decodeToken("http://localhost:8080/realms/sma-realm/protocol/openid-connect/token");
    // const expirationDate = helper.getTokenExpirationDate("http://localhost:8080/realms/sma-realm/protocol/openid-connect/token");
    // const isExpired = helper.isTokenExpired("http://localhost:8080/realms/sma-realm/protocol/openid-connect/token");

    // console.log("TOKENNNNNNNNNNNNNNNNNNNNNNNNNNNN : " + decodedToken + " : " + expirationDate + " : " + isExpired);

    keycloak.init({

      config: {
        url: 'http://localhost:8080',
        realm: 'sma-realm',
        clientId: 'sma-angular-module-frontend'
      },
      initOptions: {
        onLoad: 'login-required',
        checkLoginIframe: false,
        // idToken: helper.decodeToken("http://localhost:8080/realms/sma-realm/protocol/openid-connect/token"),
        // flow:"standard",
        // redirectUri: "http://localhost:80/",
        token: "http://localhost:8080/realms/sma-realm/protocol/openid-connect/token",

        // silentCheckSsoRedirectUri:
        //   window.location.origin + '/assets/silent-check-sso.html'
      },
      enableBearerInterceptor: true,
      bearerPrefix: 'Bearer ',
      bearerExcludedUrls: [
        '/assets',
        '/clients/public']
    });
  }
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
export class AppModule {
}
