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

  constructor(private http: HttpClient) { }

<<<<<<< HEAD
  public getAllSongs(): Observable<Song[]>{
    const urlEndPoint: string = this.url + '/allsongs';
=======
  public getAllSongs(page: number, size: number, sort: string): Observable<Song[]> {
    let urlEndPoint: string = this.url + 'songs?page=' + page + '&size=' + size + '&sort=' + sort;
>>>>>>> 570dab64c1cf21a7c772c71efed4cf42649526a8
    return this.http.get<Song[]>(urlEndPoint);
  }

  public deleteSong(songIdToDelete: number): Observable<any> {
    let urlEndPoint: string = this.url + 'songs/' + songIdToDelete;
    return this.http.delete<any>(urlEndPoint);
  }
}
