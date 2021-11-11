import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { RegisterUserAccountRequest } from '../models/registerUserAccountRequest';
import { UserAccount } from '../models/userAccount';

@Injectable({
  providedIn: 'root'
})
export class UserAccountService {

  private apiServerUrl = environment.apiBaseUrl;
  
  constructor(private http:HttpClient) { }

  public registerUser(userAccount: RegisterUserAccountRequest):Observable<UserAccount> {
    return this.http.post<UserAccount>(`${this.apiServerUrl}/registerUser`, userAccount);
  }

  public registerPhysio(userAccount: RegisterUserAccountRequest):Observable<UserAccount> {
    return this.http.post<UserAccount>(`${this.apiServerUrl}/registerPhysio`, userAccount);
  }
}
