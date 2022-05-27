import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Songs } from '../../song.model';

@Injectable({
  providedIn: 'root'
})
export class SongListService {
  url = environment.dev

  constructor(private http: HttpClient) { }

  public getAllSongs(): Observable<Songs[]>{
    const urlEndPoint: string = this.url + 'songs';
    return this.http.get<Songs[]>(urlEndPoint)
  }
}
