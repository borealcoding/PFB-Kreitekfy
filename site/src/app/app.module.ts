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
import { ModalComponent } from './auth/modal/modal.component';

import { CommonModule } from '@angular/common';





@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    PlayerComponent,
    CardSongComponent,
    CardUserComponent,
    AuthComponent,
    ModalComponent
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
