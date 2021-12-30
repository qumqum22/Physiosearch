import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { AddPostRequest } from '../models/addPostRequest';
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

  public addPost(postRequest: AddPostRequest):Observable<AddPostRequest> {
    return this.http.post<AddPostRequest>(`${this.apiServerUrl}/profile/add/post`, postRequest);
  }
}
