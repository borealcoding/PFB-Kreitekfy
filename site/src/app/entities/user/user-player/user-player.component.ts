import { Component, OnInit } from '@angular/core';
import { User } from '../model/user.model';

@Component({
  selector: 'app-user-player',
  templateUrl: './user-player.component.html',
  styleUrls: ['./user-player.component.scss']
})
export class UserPlayerComponent implements OnInit {

  dataUser: User = new User();

  constructor() { }

  ngOnInit(): void {
    this.getLocalStorage();
  }

  public getLocalStorage() {
    this.dataUser = JSON.parse(localStorage.getItem('user') as string);
    console.log(this.dataUser);
    console.log(this.dataUser.id);
  }

}
