import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Style } from '../model/style.model';

@Injectable({
  providedIn: 'root'
})
export class StyleService {
  
  url = environment.dev;

  constructor(private http: HttpClient) { }

  public getAllStyles(partialName?: string): Observable<Style[]> {

    let urlEndPoint: string = this.url + 'styles';
    if (partialName) {
      urlEndPoint = urlEndPoint + "?partialName=" + partialName;
    }
    return this.http.get<Style[]>(urlEndPoint);
  }
}
