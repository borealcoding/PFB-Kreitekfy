import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Artist } from '../model/artist.model';

@Injectable({
  providedIn: 'root'
})
export class ArtistService {

  url = environment.dev;

  constructor(private http: HttpClient) { }

  public getAllArtist(): Observable<Artist[]> {
    let urlEndPoint: string = this.url + 'artists';
    return this.http.get<Artist[]>(urlEndPoint);
  }
}
