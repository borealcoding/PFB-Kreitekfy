import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { throwError } from 'rxjs';
import { Song } from '../../model/song.model';
import { SongService } from '../../services/song.service';


@Component({
  selector: 'app-song-form',
  templateUrl: './song-form.component.html',
  styleUrls: ['./song-form.component.scss']
})
export class SongFormComponent implements OnInit {

  //song: Song = new Song;

  constructor(private songService: SongService) { }

  ngOnInit(): void {
  }

  // public createSong(song: Song): void {
  //   this.songService.createSong(song).subscribe({
  //     next: (newSong) => {
  //       console.log("Song created: ", newSong);
  //     },
  //     error: (err) => { console.log(err) }
  //   })
  // }
}
