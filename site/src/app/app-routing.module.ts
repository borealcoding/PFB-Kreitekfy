import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserListComponent } from './entities/user/user-list/user-list.component';
import { BackofficeComponent } from './layouts/backoffice/backoffice.component';
import { PlayerComponent } from './layouts/player/player.component';

const routes: Routes = [
  { path: '', component: UserListComponent },
  { path: 'backoffice', component: BackofficeComponent },
  { path: 'player', component: PlayerComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
