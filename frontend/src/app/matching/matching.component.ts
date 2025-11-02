import {Component, inject, OnInit} from '@angular/core';
import {FormArray, FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {MatchingApiService} from '../services/matching-api.service';
import {ThemaApiService} from '../services/thema-api.service';
import {JsonPipe, NgForOf} from '@angular/common';
import {NeuesThemaRequestDto} from '../betreuer/thema-erstellen/thema-erstellen.component';
import {RouterLink} from '@angular/router';

export interface MatchRequest {
  anforderungen: string[];
  fachgebiete: string;
}

@Component({
  selector: 'app-matching',
  imports: [
    ReactiveFormsModule,
    NgForOf,
    JsonPipe,
    RouterLink
  ],
  templateUrl: './matching.component.html',
  styleUrl: './matching.component.css',
})
export class MatchingComponent implements OnInit {
  matchingForm!: FormGroup;
  matchService = inject(MatchingApiService)
  themaService = inject(ThemaApiService)
  anforderungen: { [key: string]: string; } = {};
  betreuer! : any[];

  constructor(private fb: FormBuilder) {
  }

  ngOnInit(): void {
    this.themaService.getAllAnforderungen().subscribe({
      next: data => {
        this.anforderungen = data;

        this.initThemaForm();
      }
    })
  }

  postMatchRequest() {
    this.matchService.postMatchRequest(this.formToRequestDto()).subscribe({
      next: data => {
        this.betreuer = data;
        console.log(this.betreuer);
      }
    })
  }

  formToRequestDto() : MatchRequest {
    const fachgebiete = this.matchingForm.get('fachgebiete')?.value;
    let anforderungenSet: string[] = []

    const entriesA = Object.entries(this.anforderungen);
    let anforderungenFormArray = this.anforderungenFormArray.controls;

    for (let i = 0; i < entriesA.length; i++) {
      const bool = anforderungenFormArray[i].value
      if (bool) {
        const [key, value] = entriesA[i];
        anforderungenSet.push(key)
      }
    }
    return { anforderungen: anforderungenSet, fachgebiete: fachgebiete, }
  }

  private initThemaForm() {
    this.matchingForm = this.fb.group({
      fachgebiete: ['', Validators.required],
      anforderungen: this.fb.array([])
    });

    this.addAnforderungen();
  }

  private addAnforderungen() {
    const veranstaltungenArray = this.matchingForm.get('anforderungen') as FormArray;
    for (const key of Object.keys(this.anforderungen)) {
      veranstaltungenArray.push(new FormControl(false));
    }
  }

  get anforderungenFormArray(): FormArray {
    return this.matchingForm.get('anforderungen') as FormArray;
  }

  protected readonly Object = Object;
}
