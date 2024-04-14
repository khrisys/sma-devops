import {Component, OnInit} from '@angular/core';
import {SecurityService} from "./services/security.service";
import {KeycloakService} from "keycloak-angular";
import {KeycloakProfile} from "keycloak-js";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  title = 'SMA | Service de Maintenance Automobile';
  public profile?: KeycloakProfile;

  /**
   * injection de keycloakSerrvice pour recuperation du profile
   * @param keycloakService
   */
  constructor(public keycloakService: KeycloakService) {
  }

  /**
   * Recuperation du profil si authentifié
   */
  ngOnInit() {
    if (this.keycloakService.isLoggedIn()) {
      this.keycloakService.loadUserProfile().then(profile => {
        this.profile = profile;
      });
    }
  }

  async login() {
    await this.keycloakService.login({
      redirectUri: window.location.origin
    });
  }

  logout() {
    this.keycloakService.logout(window.location.origin)
  }
}
