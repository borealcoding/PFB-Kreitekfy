import { Component, OnInit } from '@angular/core';
import { Song } from 'src/app/entities/song/model/song.model';
import { SongService } from 'src/app/entities/song/services/song.service';

@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.scss']
})
export class PlayerComponent implements OnInit {

  songs: Song[] = [];

  constructor(private songService: SongService) { }

  ngOnInit(): void {
    //this.getAllSongs();
  }

  // public getAllSongs() {
  //   this.songListService.getAllSongs().subscribe(
  //     (data) => {
  //       data.forEach((song) => {
  //         this.songs.push(song);
  //         console.log(this.songs)
  //       })
  //     }
  //   )
  // }
}
