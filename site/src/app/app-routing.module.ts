import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SongFormComponent } from './entities/song/song-form/song-form/song-form.component';
import { SongListComponent } from './entities/song/song-list/song-list.component';
import { UserAdminComponent } from './entities/user/user-admin/user-admin.component';
import { UserListComponent } from './entities/user/user-list/user-list.component';
import { PlayerComponent } from './layouts/player/player.component';
import { CardSongComponent } from './layouts/cards/card-song/card-song.component';

const routes: Routes = [
  { path: '', component: UserListComponent },
  { path: 'player', component: PlayerComponent },
  { path: 'admin', component: UserAdminComponent },
  { path: 'user', component: PlayerComponent },
  { path: 'song-list', component: SongListComponent },
<<<<<<< HEAD
  { path: 'song-form', component: SongFormComponent },
  { path: 'songs/:songId', component: CardSongComponent }
 
=======
  { path: 'song-form', component: SongFormComponent }
>>>>>>> 570dab64c1cf21a7c772c71efed4cf42649526a8
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
