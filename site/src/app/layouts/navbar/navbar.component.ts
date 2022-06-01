import { Component, OnDestroy, OnInit, } from '@angular/core';
import { User } from 'src/app/entities/user/model/user.model';
import {  NavigationStart, Router , Event as NavigationEvent } from '@angular/router';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit{
 url ="";
 dataUser: User = new User();
  constructor(private readonly router:Router) {
    
  }


  ngOnInit(): void {
    this.comprobarPantalla();
      }


public comprobarPantalla(){

  this.router.events.subscribe((event: any) => {
    if (event instanceof NavigationStart) {
      if (event.url==="/"){
          this.url=event.url;
           this.dataUser.rol="";
     }else{
        this.getLocalStorage();
     }
      //debugger
    }
  });
}


  public getLocalStorage() {
    this.dataUser = JSON.parse(localStorage.getItem('user') as string);
    console.log(this.dataUser);
    console.log(this.dataUser.id);
    console.log(this.dataUser.name);
    console.log(this.dataUser.rol);
  

   
   }

}
