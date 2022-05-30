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
  page: number = 0;
  size: number = 5;
  sort: string = 'releaseDate,desc';
  first: boolean = false;
  last: boolean = false;
  style: string = "";
  totalPages: number = 0;
  totalElements: number = 0;


  constructor(private route: ActivatedRoute, private songsListService: SongListService) { }

  ngOnInit(): void {
    this.getAllSongs();
  }

  private getAllSongs() {
    this.songsListService.getAllSongs(this.page, this.size, this.sort).subscribe({
      next: (data: any) => {
        this.songs = data.content;
        this.first = data.first;
        this.last = data.last;
        this.totalPages = data.totalPages;
        this.totalElements = data.totalElements;
      },
      error: (error) => { console.log(error); }
    })
  }

  public nextPage(): void {
    this.page = this.page + 1;
    this.getAllSongs();
  }

  public previousPage(): void {
    this.page = this.page - 1;
    this.getAllSongs();
  }

}
