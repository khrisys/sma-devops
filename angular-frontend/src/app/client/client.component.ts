import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {error} from "@angular/compiler-cli/src/transformers/util";
import {CommonModule, NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-client',
  standalone: true,
  imports: [
    NgForOf,
    NgIf, HttpClientModule, CommonModule
  ],
  templateUrl: './client.component.html',
  styleUrl: './client.component.css'
})
export class ClientComponent implements OnInit {
  clients: any;

  constructor(private http: HttpClient) {
  }

  ngOnInit() {
    this.http.get("http://localhost:8888/CLIENT-SERVICE/clients").subscribe({
      next: data => {
        this.clients = data;
      }, error: err => {
        console.log(err)
      }
    })
  }
}
