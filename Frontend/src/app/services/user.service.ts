import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { RegisterUserRequest } from '../models/registerUserRequest';
import { UpdateUserRequest } from '../models/updateUserRequest';
import { User } from '../models/user';

@Injectable({
    providedIn: 'root'
})
export class UserService {

    private apiServerUrl = environment.apiBaseUrl;

    constructor(private http:HttpClient) {
    }


    // REFACTORED

    // UNREFACTORED
    public getUsers():Observable<User[]> {
        
        return this.http.get<User[]>(`${this.apiServerUrl}/users`);
    }
    
    public getUser(id: number):Observable<User> {
        
        return this.http.get<User>(`${this.apiServerUrl}/users/${id}`);
    }

    public getUsersByAddress(id: number):Observable<User[]> {
        
        return this.http.get<User[]>(`${this.apiServerUrl}/users/address/${id}`);
    }


    public registerUser(user: RegisterUserRequest):Observable<User> {
        return this.http.post<User>(`${this.apiServerUrl}`, user);
    }

    public updateUser(userId: number, updateUserData: UpdateUserRequest):Observable<User> {
        return this.http.put<User>(`${this.apiServerUrl}/users/update/${userId}`, updateUserData);
    }

    public deleteUser(userId: number): Observable<void> {
        return this.http.delete<void>(`${this.apiServerUrl}/users/delete/${userId}`);
    }
}