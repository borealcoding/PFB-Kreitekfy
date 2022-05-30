import { Component, OnInit } from '@angular/core';
import { Song } from 'src/app/entities/song/model/song.model';
import { PlayerService } from './services/player.service';

@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.scss']
})
export class PlayerComponent implements OnInit {

  songs: Song[] = [];

  constructor(private cancionesService: PlayerService) { }

  ngOnInit(): void {
    this.getAllSongs();
  }

  public getAllSongs() {
    this.cancionesService.getAllSongs().subscribe(
      (data) => {
        data.forEach((cancion) => {
          this.songs.push(cancion);
          console.log(this.songs)
        })
      }
    )
  }
}
