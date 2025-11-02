import {Component, inject, OnInit} from '@angular/core';
import {ActivatedRoute, RouterLink} from '@angular/router';
import {NgForOf, NgIf} from '@angular/common';

@Component({
  selector: 'app-person-details',
  standalone: true,
  imports: [
    NgForOf,
    NgIf,
    RouterLink
  ],
  templateUrl: './person-details.component.html',
  styleUrls: ['./person-details.component.css', '../../../styles.css']
})
export class PersonDetailsComponent implements OnInit {
    route = inject(ActivatedRoute);
    person : any;

    ngOnInit(): void {
      this.route.queryParams.subscribe(params => {
        this.person = JSON.parse(params['person']);
        console.log("this person: ", this.person);
      });
    }

    getFachgebieteString() : string {
      let s = ""
      let fachgebiete = this.person.fachgebiete

      if(!fachgebiete) {
        return "keine"
      }

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

    getThemenFachgebiete() : string {
      let s = ""
      let fachgebiete = this.person.themen.fachgebiete

      if(!fachgebiete) {
        return "keine"
      }

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
