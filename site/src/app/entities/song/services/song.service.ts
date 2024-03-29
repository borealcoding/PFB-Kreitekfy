import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Song } from '../model/song.model';

@Injectable({
  providedIn: 'root'
})

export class SongService {
  url = environment.dev

  constructor(private http: HttpClient) { }

  public getAllSongs(page: number, size: number, sort: string, style: string): Observable<Song[]> {
    let urlEndPoint: string = this.url + 'songs?page=' + page + '&size=' + size + '&sort=' + sort;
    console.log("------------------- "+urlEndPoint);
    return this.http.get<Song[]>(urlEndPoint);
  }

  public getAllSongsFiltered(page: number, size: number, sort: string, style: string): Observable<Song[]> {
    let urlEndPoint: string = this.url + 'songs?page=' + page + '&size=' + size + '&sort=' + sort + '&filter=style.name:EQUAL:' + style;
    console.log("------------------- "+urlEndPoint);
    return this.http.get<Song[]>(urlEndPoint);
  }

  public getAllSongsByStyle(partialStyle?: string): Observable<Song[]> {
    let urlEndPoint: string = this.url + 'song';
    if(partialStyle) {
      urlEndPoint = urlEndPoint + "?partialName=" + partialStyle;
      console.log(urlEndPoint);
    }
    return this.http.get<Song[]>(urlEndPoint);
  }

  public getSongById(id: number): Observable<Song> {
    let urlEndPoint: string = this.url + 'songs/' + id;
    return this.http.get<Song>(urlEndPoint);
  }

  public deleteSong(songIdToDelete: number): Observable<any> {
    let urlEndPoint: string = this.url + 'songs/' + songIdToDelete;
    return this.http.delete<any>(urlEndPoint);
  }

  public insertSong(song: Song): Observable<Song> {
    let urlEndPoint: string = this.url + 'songs/';
    return this.http.post<Song>(urlEndPoint, song);
  }

  public updateSong(song: Song): Observable<Song> {
    let urlEndPoint: string = this.url + 'songs/';
    return this.http.patch<Song>(urlEndPoint, song);
  }
}
