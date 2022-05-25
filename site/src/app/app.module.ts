import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';

import { PlayerComponent } from './layouts/player/player.component';

import { CardSongComponent } from './layouts/cards/card-song/card-song.component';
import { CardUserComponent } from './layouts/cards/card-user/card-user.component';
import { AuthComponent } from './auth/auth.component';
1

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,

    PlayerComponent,

    CardSongComponent,
    CardUserComponent,
    AuthComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
