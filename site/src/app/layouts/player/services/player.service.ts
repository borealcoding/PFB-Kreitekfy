import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Canciones } from '../model/canciones.model';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {
  url = environment.dev

  constructor(
    
    private http: HttpClient
  ) { 

  }
public getAllSongs(): Observable<Canciones[]>{
  const urlEndPoint: string = this.url + 'songs';
  return this.http.get<Canciones[]>(urlEndPoint)
}
  public getOneSong(id: number): Observable<Canciones> {
    const urlEndPoint: string = this.url + `song/${id}` ; 
    console.log(urlEndPoint);
    return this.http.get<Canciones>(urlEndPoint);
  }
}
