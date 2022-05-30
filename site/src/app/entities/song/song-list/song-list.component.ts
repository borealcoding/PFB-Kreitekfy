import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Song } from '../model/song.model';
import { SongListService } from './services/song-list.service';

@Component({
  selector: 'app-song-list',
  templateUrl: './song-list.component.html',
  styleUrls: ['./song-list.component.scss']
})
export class SongListComponent implements OnInit {

  songs: Song[] = [];

  constructor(private route: ActivatedRoute, private songsListService: SongListService) { }

  ngOnInit(): void {
    this.getAllSongs();
  }

  private getAllSongs() {
    this.songsListService.getAllSongs().subscribe({
      next: (songsRequest) => { this.songs = songsRequest; },
      error: (error) => { console.log(error); }
    })
  }

}
