import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';

import { PlayerComponent } from './layouts/player/player.component';

import { CardSongComponent } from './layouts/cards/card-song/card-song.component';
import { CardUserComponent } from './layouts/cards/card-user/card-user.component';
import { AuthComponent } from './auth/auth.component';

import { CommonModule } from '@angular/common';
import { SongComponent } from './entities/song/song.component';
import { AlbumComponent } from './entities/album/album.component';
import { StyleComponent } from './entities/style/style.component';
import { ArtistComponent } from './entities/artist/artist.component';
import { BackofficeComponent } from './layouts/backoffice/backoffice.component';
import { UserListComponent } from './entities/user/user-list/user-list.component';
import { UserAdminComponent } from './entities/user/user-admin/user-admin.component';
import { SongListComponent } from './entities/song/song-list/song-list.component';
import { UserPlayerComponent } from './entities/user/user-player/user-player.component';





@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    PlayerComponent,
    CardSongComponent,
    CardUserComponent,
    AuthComponent,
    SongComponent,
    AlbumComponent,
    StyleComponent,
    ArtistComponent,
    BackofficeComponent,
    UserListComponent,
    UserAdminComponent,
    SongListComponent,
    UserPlayerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    CommonModule
  ],
  providers: [],
  bootstrap: [AppComponent],

})
export class AppModule { }
