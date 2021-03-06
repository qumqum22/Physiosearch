import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { Clinic } from '../models/clinic';

@Injectable({
  providedIn: 'root'
})

export class ClinicService {


  private apiServerUrl = environment.apiBaseUrl;
  
  constructor(private http:HttpClient) { }

  getClinic(clinicId: number):Observable<Clinic> {
        
    return this.http.get<Clinic>(`${this.apiServerUrl}/clinic/${clinicId}`).pipe(
        tap(console.log)
    );
}
  getClinics(userId: number):Observable<Clinic[]> {
    return this.http.get<Clinic[]>(`${this.apiServerUrl}/clinics/${userId}`).pipe(
      tap(console.log)
  );
  }

  deleteClinic(clinicId: number, userId:number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/clinic/delete/${clinicId}/${userId}`);
  }

}
