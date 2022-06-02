import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Song } from 'src/app/entities/song/model/song.model';
import { SongService } from 'src/app/entities/song/services/song.service';
import { Style } from 'src/app/entities/style/model/style.model';
import { StyleService } from 'src/app/entities/style/services/style.service';
import { User } from 'src/app/entities/user/model/user.model';
import { NavigationStart, Router, Event as NavigationEvent } from '@angular/router';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
  selectedStyle?: Style;
  styles: Style[] = [];
  song?: Song;
  url = "";
  dataUser: User = new User();

  constructor(private route: ActivatedRoute,
    private songService: SongService,
    private styleService: StyleService, private readonly router: Router
  ) { }

  ngOnInit(): void {
    this.comprobarPantalla();
  }

  public getAllStyles(event?: any): void {
    let styleSearch: string | undefined;
    if (event?.query) {
      styleSearch = event.query;
    }
    this.styleService.getAllStyles(styleSearch).subscribe({
      next: (stylesFiltered) => { this.styles = stylesFiltered; },
      error: (error) => { this.handleError(error); }
    });
  }

  public styleSelected(): void {
    let styleName: string | undefined = this.selectedStyle?.name;
    console.log("Estilo selecionado: " + styleName);
    localStorage.setItem('style', styleName!);
    window.location.href = 'user';
  }


  public comprobarPantalla() {

    this.router.events.subscribe((event: any) => {
      if (event instanceof NavigationStart) {
        if (event.url === "/") {
          this.url = event.url;
          this.dataUser.rol = "";
        } else {
          this.getLocalStorage();
        }
      }
    });
  }


  public getLocalStorage() {
    this.dataUser = JSON.parse(localStorage.getItem('user') as string);
    return localStorage.getItem('style');
  }

  public handleError(error: any): void {
    console.log(error);
  }

}
