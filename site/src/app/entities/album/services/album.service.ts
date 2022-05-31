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

  public getAllAlbums(partialName?: string): Observable<Album[]> {
    let urlEndPoint: string = this.url + 'albums';
    if (partialName) {
      urlEndPoint = urlEndPoint + "?partialName=" + partialName;
      console.log(urlEndPoint);
    }
    return this.http.get<Album[]>(urlEndPoint);
  }
}
