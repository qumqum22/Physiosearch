import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { AddPhoneRequest } from '../models/addPhoneRequest';
import { Phone } from '../models/phone';

@Injectable({
  providedIn: 'root'
})

export class PhoneService {

  private apiServerUrl = environment.apiBaseUrl;
  
  constructor(private http:HttpClient) { }

  public getPhones(userId: number):Observable<Phone[]> {
    return this.http.get<Phone[]>(`${this.apiServerUrl}/phones/${userId}`);
}
  public deletePhone(phoneId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/phones/delete/${phoneId}`);
  }

  public addPhone(phoneRequest: AddPhoneRequest):Observable<Phone> {
    return this.http.post<Phone>(`${this.apiServerUrl}/phones/add`, phoneRequest);
  }
}
