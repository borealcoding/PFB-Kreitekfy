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

<<<<<<< HEAD
  public getAllSongs() {
    this.songListService.getAllSongs().subscribe(
      (data) => {
        data.forEach((song) => {
          this.songs.push(song);
          console.log(this.songs)
        })
      }
    )
  }
=======
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
>>>>>>> 570dab64c1cf21a7c772c71efed4cf42649526a8
}
