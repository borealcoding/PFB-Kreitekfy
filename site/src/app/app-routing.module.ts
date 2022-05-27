import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserAdminComponent } from './entities/user/user-admin/user-admin.component';
import { UserListComponent } from './entities/user/user-list/user-list.component';
import { UserPlayerComponent } from './entities/user/user-player/user-player.component';
import { PlayerComponent } from './layouts/player/player.component';
const routes: Routes = [
  { path: '', component: UserListComponent },
  { path: 'player', component: PlayerComponent },
  { path: 'admin', component: UserAdminComponent },
  { path: 'user', component: UserPlayerComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
