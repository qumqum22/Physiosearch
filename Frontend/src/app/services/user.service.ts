import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { LoginRequest } from '../models/loginRequest';
import { RegisterRequest } from '../models/registerRequest';
import { UpdateUserRequest } from '../models/updateUserRequest';
import { User } from '../models/user';
import { UserAccount } from '../models/userAccount';

@Injectable({
    providedIn: 'root'
})
export class UserService {

    private apiServerUrl = environment.apiBaseUrl;

    constructor(private http:HttpClient) {
    }

    public loginUser(login: LoginRequest):Observable<UserAccount>
    {
        return this.http.post<UserAccount>(`${this.apiServerUrl}/signin`, login);
    }

    public registerUser(userAccount: RegisterRequest):Observable<UserAccount> {
        return this.http.post<UserAccount>(`${this.apiServerUrl}/registerUser`, userAccount);
      }
    
      public registerPhysio(userAccount: RegisterRequest):Observable<UserAccount> {
        return this.http.post<UserAccount>(`${this.apiServerUrl}/registerPhysio`, userAccount);
      }
      
    public getUsers():Observable<User[]> {
        
        return this.http.get<User[]>(`${this.apiServerUrl}/users`);
    }
    
    public getUser(id: number):Observable<User> {
        
        return this.http.get<User>(`${this.apiServerUrl}/users/${id}`);
    }

    public getUsersByAddress(id: number):Observable<User[]> {
        
        return this.http.get<User[]>(`${this.apiServerUrl}/users/address/${id}`);
    }

    public updateUser(userId: number, updateUserData: UpdateUserRequest):Observable<User> {
        return this.http.put<User>(`${this.apiServerUrl}/users/update/${userId}`, updateUserData);
    }

    public deleteUser(userId: number): Observable<void> {
        return this.http.delete<void>(`${this.apiServerUrl}/users/delete/${userId}`);
    }
}