import {inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PersonApiService {
  http : HttpClient = inject(HttpClient);

  BASE_API_URL = 'http://localhost:18736/api/person';

  getAllPersonen() {
    return this.http.get(this.BASE_API_URL + '/get-all-personen');
  }

  getThemenByEmail(email : string) : Observable<any[]> {
    return this.http.get<any[]>(this.BASE_API_URL + '/get-themen-by-email/' + email);
  }

  postMatchRequest(anforderungen : any, fachgebiete : any) : Observable<any> {
    return this.http.post('http://localhost:18736/api/matching/find-matches',
      {
        anforderungen : anforderungen,
        fachgebiete : fachgebiete,
      })
  }
}
