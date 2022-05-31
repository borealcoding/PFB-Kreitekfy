import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Album } from '../model/album.model';

@Injectable({
  providedIn: 'root'
})
export class AlbumService {
  url = environment.dev;

  constructor(private http: HttpClient) { }

  public getAllAlbums(artistName?: string): Observable<Album[]> {
    let urlEndPoint: string = this.url + 'album?filter=artist.name:EQUAL:' + artistName;
    return this.http.get<Album[]>(urlEndPoint);
  }
}
