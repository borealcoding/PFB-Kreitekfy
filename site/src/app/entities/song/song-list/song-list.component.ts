import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Songs } from '../song.model';
import { SongListService } from './services/song-list.service';

@Component({
  selector: 'app-song-list',
  templateUrl: './song-list.component.html',
  styleUrls: ['./song-list.component.scss']
})
export class SongListComponent implements OnInit {
  songs: Songs[] = [];

  constructor(private route: ActivatedRoute, private songsListService: SongListService) { }

  ngOnInit(): void {

  }

  public getAllSongs() {
    this.songsListService.getAllSongs().subscribe(
      (data) => {
        data.forEach((song) => {
          this.songs.push(song);
          console.log(this.songs)
        })
      }
    )
  }
}
