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
  public getAllSongs(): Observable<Song[]> {
    const urlEndPoint: string = this.url + 'allsongs';
    return this.http.get<Song[]>(urlEndPoint)
  }

}
