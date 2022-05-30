import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Song } from '../../model/song.model';

@Injectable({
  providedIn: 'root'
})
export class SongListService {
  url = environment.dev

  constructor(private http: HttpClient) {

  }

  public getAllSongs(page: number, size: number, sort: string): Observable<Song[]> {
    const urlEndPoint: string = this.url + 'songs?page=' + page + '&size=' + size + '&sort=' + sort;
    console.log("------")
    console.log(urlEndPoint);
    return this.http.get<Song[]>(urlEndPoint);
  }
}
