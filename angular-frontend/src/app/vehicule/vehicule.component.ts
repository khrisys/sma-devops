import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-vehicule',
  standalone: true,
  imports: [HttpClientModule, NgForOf, NgIf],
  templateUrl: './vehicule.component.html',
  styleUrl: './vehicule.component.css'
})
export class VehiculeComponent implements OnInit{
vehicules: any;
  constructor(private http: HttpClient) {
  }

  ngOnInit() {
    this.http.get("http://localhost:8888/VEHICULE-SERVICE/vehicules").subscribe({
      next: data => {
        this.vehicules = data;
      }, error: err => {
        console.log(err)
      }
    })
  }
}
