import {Component, inject, OnInit} from '@angular/core';
import {RouterLink} from '@angular/router';
import {PersonApiService} from '../services/person-api.service';
import {JsonPipe, NgForOf} from '@angular/common';

@Component({
  selector: 'app-betreuer',
  imports: [
    RouterLink,
    NgForOf,
    JsonPipe
  ],
  templateUrl: './betreuer.component.html',
  styleUrl: './betreuer.component.css',
})
export class BetreuerComponent implements OnInit {
  personService = inject(PersonApiService)
  betreuerThemen : any[] = [];

  ngOnInit(): void {
    // TODO email muss später aus github oauth2 geholt werden
    this.personService.getThemenByEmail("timo@neske.de").subscribe({
      next: data => {
        this.betreuerThemen = data
      }
    })
  }
}
