import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {error} from "@angular/compiler-cli/src/transformers/util";

@Component({
  selector: 'app-garage',
  templateUrl: './garage.component.html',
  styleUrl: './garage.component.css'
})
export class GarageComponent implements OnInit {
  garages: any;
  constructor(private http: HttpClient) {
  }

  /**
   * Recupere les données  à l'initialisation du component
   */
  ngOnInit() {
    this.http.get("http://localhost:8081/garages").subscribe({
      next: value => {
        this.garages = value;
      },
      error: err => {
        console.log(err);
      }
    });
  }
}
