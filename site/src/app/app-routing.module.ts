import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SongFormComponent } from './entities/song/song-form/song-form/song-form.component';
import { SongListComponent } from './entities/song/song-list/song-list.component';
import { UserAdminComponent } from './entities/user/user-admin/user-admin.component';
import { UserListComponent } from './entities/user/user-list/user-list.component';
import { PlayerComponent } from './layouts/player/player.component';

const routes: Routes = [
  { path: '', component: UserListComponent },
  { path: 'player', component: PlayerComponent },
  { path: 'admin', component: UserAdminComponent },
  { path: 'user', component: PlayerComponent },
  { path: 'song-list', component: SongListComponent },
  { path: 'song-form', component: SongFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
