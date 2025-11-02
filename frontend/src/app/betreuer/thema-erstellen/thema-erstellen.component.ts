import {Component, inject, OnInit} from '@angular/core';
import {FormArray, FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {NgForOf, NgIf} from '@angular/common';
import {ThemaApiService} from '../../services/thema-api.service';

export interface Link {
  url: string;
  text: string;
}

export interface NeuesThemaRequestDto {
  titel: string;
  beschreibung: string;
  anforderungen: string[];
  fachgebiet: string;
  links: Link[];
}

@Component({
  selector: 'app-thema-erstellen',
  imports: [ReactiveFormsModule, NgForOf, NgIf],
  templateUrl: './thema-erstellen.component.html',
  styleUrls: ['./thema-erstellen.component.css', '../../../styles.css']
})
export class ThemaErstellenComponent implements OnInit {
  themaService = inject(ThemaApiService)

  themaForm!: FormGroup;

  linkForm : FormGroup = new FormGroup({
    url: new FormControl('', [Validators.required]),
    text: new FormControl('', [Validators.required])
  })

  hinzugefuegteLinks : Link[] = []
  anforderungen: { [key: string]: string; } = {};

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.themaService.getAllAnforderungen().subscribe({
      next: data => {
        this.anforderungen = data;

        this.initThemaForm();
      }
    })
  }

  linkHinzufuegen() : void {
    //console.log(this.linkForm.value)
    const url = this.linkForm.get('url')?.value;
    const text = this.linkForm.get('text')?.value;
    const link : Link = {url: url, text: text};
    this.hinzugefuegteLinks.push(link);
  }

  formToRequestDto() : NeuesThemaRequestDto {
    const titel = this.themaForm.get('titel')?.value;
    const beschreibung = this.themaForm.get('beschreibung')?.value;
    const fachgebiet = this.themaForm.get('fachgebiete')?.value;
    const links = this.hinzugefuegteLinks;
    let anforderungenSet : string[] = []

    const entriesA = Object.entries(this.anforderungen);
    let anforderungenFormArray = this.anforderungenFormArray.controls;

    for (let i = 0; i < entriesA.length; i++) {
      const bool = anforderungenFormArray[i].value
      if(bool) {
        const [key, value] = entriesA[i];
        anforderungenSet.push(key)
      }
    }

    return {
      titel: titel,
      beschreibung: beschreibung,
      anforderungen: anforderungenSet,
      fachgebiet: fachgebiet,
      links: links}
  }

  postThema() {
    //console.log(this.linkForm.value)
    //console.log(this.themaForm.value)
    const reqDto = this.formToRequestDto()
    this.themaService.postNeuesThema(reqDto).subscribe({})
  }

  private initThemaForm() {
    this.themaForm = this.fb.group({
      titel: ['', Validators.required],
      beschreibung: [''],
      fachgebiete: ['', Validators.required],
      anforderungen: this.fb.array([])
    });

    this.addAnforderungen();
  }

  private addAnforderungen() {
    const veranstaltungenArray = this.themaForm.get('anforderungen') as FormArray;
    for (const key of Object.keys(this.anforderungen)) {
      veranstaltungenArray.push(new FormControl(false));
    }
  }

  get anforderungenFormArray(): FormArray {
    return this.themaForm.get('anforderungen') as FormArray;
  }

  protected readonly Object = Object;
}
