import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {GarageComponent} from "./garage/garage.component";
import {ClientComponent} from "./client/client.component";
import {VehiculeComponent} from "./vehicule/vehicule.component";
import {DocumentComponent} from "./document/document.component";
import {AuthGuard} from "./guards/auth.guard";

/**
 * Accorde l'autorisation des routes en fonction des roles associés, roles herités de keycloak
 */
const routes: Routes = [
  {path: "garages", component: GarageComponent, canActivate:[AuthGuard], data : {roles:['USER']}},
  {path: "clients", component: ClientComponent, canActivate:[AuthGuard], data : {roles:['ADMIN']}},
  {path: "vehicules", component: VehiculeComponent, canActivate:[AuthGuard], data : {roles:['USER']}},
  {path: "documents", component: DocumentComponent,canActivate:[AuthGuard], data : {roles:['USER']}}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
