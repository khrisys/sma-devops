import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-vehicule',
  templateUrl: './vehicule.component.html',
  styleUrl: './vehicule.component.css'
})
export class VehiculeComponent implements OnInit {
  vehicules: any;

  constructor(private http: HttpClient) {
  }

  ngOnInit() {
    this.http.get("http://localhost:8083/vehicules").subscribe({
      next: value => {
        this.vehicules = value;
      },
      error: err => {
        console.log(err);
      }
    });
  }
}
