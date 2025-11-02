import {Component, inject, OnInit} from '@angular/core';
import {PersonApiService} from '../services/person-api.service';
import {JsonPipe, NgForOf} from '@angular/common';
import {RouterLink} from '@angular/router';
import {ThemaApiService} from '../services/thema-api.service';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [
    NgForOf,
    RouterLink,
    JsonPipe
  ],
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css', '../../styles.css']
})
export class DashboardComponent implements OnInit {
  personenService = inject(PersonApiService)
  themaService = inject(ThemaApiService)
  personen : any[] = [];
  themen : any[] = []

  ngOnInit(): void {
      this.personenService.getAllPersonen().subscribe({
        next: (data: any) => {
          this.personen = data;
          console.log(this.personen);
        },
        error: (error: any) => {
          console.error('Error fetching personen:', error);
        }
      })

    this.themaService.getAllThemen().subscribe({
      next: (data: any) => {
        this.themen = data;
        console.log(this.themen);
      },
      error: (error: any) => {
        console.error('Error fetching personen:', error);
      }
    })
  }

}
