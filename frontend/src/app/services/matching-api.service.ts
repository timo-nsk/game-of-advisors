import {inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {MatchRequest} from '../matching/matching.component';

@Injectable({
  providedIn: 'root'
})
export class MatchingApiService {
  http : HttpClient = inject(HttpClient);

  BASE_API_URL = 'http://localhost:18736/api/matching';

  postMatchRequest(payload : MatchRequest) : Observable<any> {
    console.log(payload)
    return this.http.post(this.BASE_API_URL + '/find-matches', payload)
  }
}
