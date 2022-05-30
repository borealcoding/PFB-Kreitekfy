import { Component, OnInit } from '@angular/core';
import { Song } from 'src/app/entities/song/model/song.model';
import { SongListService } from 'src/app/entities/song/song-list/services/song-list.service';

@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.scss']
})
export class PlayerComponent implements OnInit {

  songs: Song[] = [];

  constructor(private songListService: SongListService) { }

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
