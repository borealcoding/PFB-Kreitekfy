import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User } from '../model/user.model';
import { UserListService } from './service/user-list.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit {

  users: User[] = []; 

  constructor(private userListService: UserListService) { }

  ngOnInit(): void {
    this.getAllUsers();
  }

  public getAllUsers() {
    this.userListService.getAllUsers().subscribe(
      (data) => {
        data.forEach((user) => {
          this.users.push(user);
          console.log(this.users);
        })
      }
    )
  }

}