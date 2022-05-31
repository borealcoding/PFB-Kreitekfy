import { Component, OnInit } from '@angular/core';
import { Song } from '../model/song.model';
import { SongService } from '../services/song.service';

@Component({
  selector: 'app-song-list',
  templateUrl: './song-list.component.html',
  styleUrls: ['./song-list.component.scss']
})

export class SongListComponent implements OnInit {
  songs: Song[] = [];
  page: number = 0;
  size: number = 25;
  sort: string = 'releaseDate,desc';
  first: boolean = false;
  last: boolean = false;
  style: string = "";
  totalPages: number = 0;
  totalElements: number = 0;

  nameFilter?: string;
  artistNameFilter?: string;
  albumNameFilter?: string;
  styleNameFilter?: string;

  songIdToDelete?: number;

  constructor(private songsService: SongService) { }

  ngOnInit(): void {
    this.getAllSongs();
  }

  public searchByFilters(): void {
    this.getAllSongs();
  }

  private getAllSongs() {
    this.songsService.getAllSongs(this.page, this.size, this.sort).subscribe({
      next: (data: any) => {
        this.songs = data.content;
        this.first = data.first;
        this.last = data.last;
        this.totalPages = data.totalPages;
        this.totalElements = data.totalElements;
      },
      error: (error) => { this.handleError(error) }
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

  public prepareSongToDelete(songId: number): void {
    this.songIdToDelete = songId;
  }

  public deleteSong(): void {
    if (this.songIdToDelete) {
      this.songsService.deleteSong(this.songIdToDelete).subscribe({
        next: (data) => {
          this.getAllSongs();
        },
        error: (error) => { this.handleError(error) }
      })
    }
  }

  public handleError(error: any): void {
    console.log(error);
  }

}
