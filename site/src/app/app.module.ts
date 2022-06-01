import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { CalendarModule } from 'primeng/calendar';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { DropdownModule } from 'primeng/dropdown';
import {RatingModule} from 'primeng/rating';

import { AppComponent } from './app.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { PlayerComponent } from './layouts/player/player.component';
import { CardSongComponent } from './layouts/cards/card-song/card-song.component';
import { AuthComponent } from './auth/auth.component';
import { SongComponent } from './entities/song/song.component';
import { AlbumComponent } from './entities/album/album.component';
import { StyleComponent } from './entities/style/style.component';
import { ArtistComponent } from './entities/artist/artist.component';
import { UserListComponent } from './entities/user/user-list/user-list.component';
import { UserAdminComponent } from './entities/user/user-admin/user-admin.component';
import { SongListComponent } from './entities/song/song-list/song-list.component';
import { UserPlayerComponent } from './entities/user/user-player/user-player.component';
import { SongFormComponent } from './entities/song/song-form/song-form/song-form.component';
import { HttpRequestIntercept } from './config/interceptors/http-request-interceptor.interceptor';
import { AutoCompleteModule } from 'primeng/autocomplete';
import {ToastModule} from 'primeng/toast';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    PlayerComponent,
    CardSongComponent,
    AuthComponent,
    SongComponent,
    AlbumComponent,
    StyleComponent,
    ArtistComponent,
    UserListComponent,
    UserAdminComponent,
    SongListComponent,
    UserPlayerComponent,
    SongFormComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    CommonModule,
    CalendarModule,
    FormsModule,
    DropdownModule,
    AutoCompleteModule,
    RatingModule,
    ToastModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: HttpRequestIntercept, multi: true }
  ],
  bootstrap: [AppComponent],

})
export class AppModule { }
