import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {GarageComponent} from "./garage/garage.component";
import {ClientComponent} from "./client/client.component";
import {VehiculeComponent} from "./vehicule/vehicule.component";
import {DocumentComponent} from "./document/document.component";

const routes: Routes = [
  {path: "garages", component: GarageComponent},
  {path: "clients", component: ClientComponent},
  {path: "vehicules", component: VehiculeComponent},
  {path: "documents", component: DocumentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
