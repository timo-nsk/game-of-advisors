import {Component, inject, OnInit} from '@angular/core';
import {ActivatedRoute, RouterLink} from '@angular/router';
import {NgForOf, NgIf} from '@angular/common';

@Component({
  selector: 'app-thema-details',
  imports: [
    NgForOf,
    NgIf,
    RouterLink
  ],
  templateUrl: './thema-details.component.html',
  styleUrl: './thema-details.component.css',
})
export class ThemaDetailsComponent implements OnInit {
  route = inject(ActivatedRoute);
  thema : any;
  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.thema = JSON.parse(params['thema']);
      console.log(this.thema);
    });
  }

  getAnforderungenString() : string {
    let anforderungen = this.thema.anforderungen

    if(anforderungen.length == 0) {
      return "keine"
    } else {
      let s = ""
      let n = anforderungen.length;

      for (let i = 0; i < n; i++) {
        if(i < n-1) {
          s += anforderungen[i] + ', '
        } else {
          s += anforderungen[i]
        }

      }

      return s
    }
  }

  getFachgebieteString() : string {
    let fachgebiete = this.thema.fachgebiete

    if(fachgebiete.length == 0) {
      console.log(fachgebiete);
      return "keine"
    } else {
      let s = ""
      let n = fachgebiete.length;

      for (let i = 0; i < n; i++) {
        if(i < n-1) {
          s += fachgebiete[i] + ', '
        } else {
          s += fachgebiete[i]
        }

      }

      return s
    }
  }

  get hatDateien() : boolean {
    return this.thema.dateien.length > 0;
  }

  get hatLinks() : boolean {
    return this.thema.links.length > 0;
  }
}
