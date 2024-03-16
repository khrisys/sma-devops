import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-document',
  templateUrl: './document.component.html',
  styleUrl: './document.component.css'
})
export class DocumentComponent implements OnInit {
  documents: any;

  constructor(private http: HttpClient) {
  }

  ngOnInit() {
    this.http.get("http://localhost:8084/documents").subscribe({
      next: value => {
        this.documents = value;
      }, error: err => {
        console.log(err);
      }
    })
  }
}
