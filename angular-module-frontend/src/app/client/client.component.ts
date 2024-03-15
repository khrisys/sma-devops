import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrl: './client.component.css'
})
export class ClientComponent implements OnInit{

  clients: any;
  constructor(private http: HttpClient) {
  }

  /**
   * Recupere les données  à l'initialisation du component
   */
  ngOnInit() {
    this.http.get("http://localhost:8082/clients").subscribe({
      next: value => {
        this.clients = value;
      },
      error: err => {
        console.log(err);
      }
    });
  }
}
