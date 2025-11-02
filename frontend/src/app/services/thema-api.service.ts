import {inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {NeuesThemaRequestDto} from '../betreuer/thema-erstellen/thema-erstellen.component';

@Injectable({
  providedIn: 'root'
})
export class ThemaApiService {
  http : HttpClient = inject(HttpClient);

  BASE_API_URL = 'http://localhost:18736/api/thema';

  getAllThemen() {
    return this.http.get(this.BASE_API_URL + '/get-all-themen');
  }

  getAllAnforderungen() : Observable<{ [key: string]: string; }> {
    return this.http.get<{ [key: string]: string; }>(this.BASE_API_URL + '/get-anforderungen');
  }

  postNeuesThema(reqDto: NeuesThemaRequestDto) {
    return this.http.post(this.BASE_API_URL + '/neues-thema-erstellen', reqDto)
  }
}
