import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Canciones } from './model/canciones.model';
import { PlayerService } from './services/player.service';

@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.scss']
})
export class PlayerComponent implements OnInit {

  canciones : Canciones[] = [];

  constructor(
    private route: ActivatedRoute,
    private cancionesService: PlayerService
  ) { }

  ngOnInit(): void {
this.GetAllSongs();
  }
public GetAllSongs(){
  this.cancionesService.getAllSongs().subscribe(
    (data) =>{
      data.forEach((cancion)=>{
        this.canciones.push(cancion);
        console.log(this.canciones)
      }) 
    }
  )
}
  // public getOneSong(id : number){
  //   this.cancionesService.getOneSong(id).subscribe(
  //   (data:any) =>{
  //     this.cancion = data[0];
  //   }
  //   )

  // }
}
