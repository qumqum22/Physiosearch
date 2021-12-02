import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { Rehabilitation } from '../models/rehabilitation';

@Injectable({
  providedIn: 'root'
})
export class RehabilitationService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http:HttpClient) { }

  public getRehabilitations():Observable<Rehabilitation[]> {
    return this.http.get<Rehabilitation[]>(`${this.apiServerUrl}/rehabilitations`);
  }
}
