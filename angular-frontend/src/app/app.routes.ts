import { Routes } from '@angular/router';
import {GarageComponent} from "./garage/garage.component";
import {ClientComponent} from "./client/client.component";
import {VehiculeComponent} from "./vehicule/vehicule.component";
import {DocumentComponent} from "./document/document.component";

export const routes: Routes = [
  {path : "garages", component:GarageComponent},
  {path : "clients", component:ClientComponent},
  {path: "vehicules", component:VehiculeComponent},
  {path: "documents", component: DocumentComponent}
];
