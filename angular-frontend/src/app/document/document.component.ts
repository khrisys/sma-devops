import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-document',
  standalone: true,
  imports: [HttpClientModule, NgForOf, NgIf],
  templateUrl: './document.component.html',
  styleUrl: './document.component.css'
})
export class DocumentComponent implements OnInit{
documents:any;
  constructor(private http:HttpClient) {
  }

  ngOnInit() {
    this.http.get("http://localhost:8888/DOCUMENT-SERVICE/documents").subscribe({
      next: data => {
        this.documents = data;
      }, error: err => {
        console.log(err)
      }
    })
  }
}
