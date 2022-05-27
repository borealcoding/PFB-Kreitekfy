import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { User } from '../../model/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserListService {
  url = environment.dev

  constructor(private http: HttpClient) { }

  public getAllUsers(): Observable<User[]> {
    const urlEndPoint: string = this.url + 'users';
    return this.http.get<User[]>(urlEndPoint)
  }
}
