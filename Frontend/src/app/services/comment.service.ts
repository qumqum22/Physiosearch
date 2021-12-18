import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Comment} from './../models/comment';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  private apiServerUrl = environment.apiBaseUrl;
  
  constructor(private http:HttpClient) { }
  

  getCommentsAboutUser(userId: number):Observable<Comment[]> {
    return this.http.get<Comment[]>(`${this.apiServerUrl}/users/comments/${userId}`);
  }
}