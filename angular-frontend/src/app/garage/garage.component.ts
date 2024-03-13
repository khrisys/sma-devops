import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {CommonModule, NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-garage',
  standalone: true,
  imports: [
    NgForOf,
    NgIf, HttpClientModule, CommonModule
  ],
  templateUrl: './garage.component.html',
  styleUrl: './garage.component.css'
})
export class GarageComponent implements OnInit {
  garages: any;

  constructor(private http: HttpClient) {
  }

  ngOnInit() {
    this.http.get("http://localhost:8888/GARAGE-SERVICE/garages").subscribe({
      next: data => {
        this.garages = data;
      },
      error: err => {
        console.log(err)
      }
    })
  }
}
