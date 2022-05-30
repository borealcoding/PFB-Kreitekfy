import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Song } from 'src/app/entities/song/model/song.model';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {
  url = environment.dev

  constructor(
    
    private http: HttpClient
  ) { 

  }
public getAllSongs(): Observable<Song[]>{
  const urlEndPoint: string = this.url + 'songs';
  return this.http.get<Song[]>(urlEndPoint)
}
  public getOneSong(id: number): Observable<Song> {
    const urlEndPoint: string = this.url + `song/${id}` ; 
    console.log(urlEndPoint);
    return this.http.get<Song>(urlEndPoint);
  }
}
