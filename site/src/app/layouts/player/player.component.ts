import { Component, OnInit } from '@angular/core';
import { Song } from 'src/app/entities/song/model/song.model';
import { SongService } from 'src/app/entities/song/services/song.service';
import { Style } from 'src/app/entities/style/model/style.model';


@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.scss']
})
export class PlayerComponent implements OnInit {
  songsByStyle: Style[] = [];
  songsByReleaseDate: Song[] = [];
  songsByPlayedtimes: Song[] = [];
  songsByLikes: Song[] = [];

  page: number = 0;
  size: number = 5;
  first: boolean = false;
  last: boolean = false;
  totalPages: number = 0;
  totalElements: number = 0;

  sortByDate: string = 'releaseDate,desc';
  sortByPlayedTimes: string = 'playedTimes,desc';
  sortByLikes: string = 'likes,desc';

  styleObtained: string | null = localStorage.getItem('style');
  filterByStyle: string = (this.styleObtained) ? this.styleObtained : "";


  constructor(private songService: SongService) { }

  ngOnInit(): void {
    this.getAllSongs();
  }

  public searchByFilters(): void {
    this.getAllSongs();
  }

  private getAllSongs() {
    this.songService.getAllSongs(this.page, this.size, this.sortByDate, this.filterByStyle).subscribe({
      next: (data: any) => {
        this.filterByStyle = data.content;
        this.songsByReleaseDate = data.content;
        this.first = data.first;
        this.last = data.last;
        this.totalPages = data.totalPages;
        this.totalElements = data.totalElements;
      },

    })

    this.songService.getAllSongs(this.page, this.size, this.sortByPlayedTimes, this.filterByStyle).subscribe({
      next: (data: any) => {
        this.filterByStyle = data.content;
        this.songsByPlayedtimes = data.content;
        this.first = data.first;
        this.last = data.last;
        this.totalPages = data.totalPages;
        this.totalElements = data.totalElements;
      },

    })

    this.songService.getAllSongs(this.page, this.size, this.sortByLikes, this.filterByStyle).subscribe({

      next: (data: any) => {
        this.filterByStyle = data.content;
        this.songsByLikes = data.content;
        this.first = data.first;
        this.last = data.last;
        this.totalPages = data.totalPages;
        this.totalElements = data.totalElements;
      },

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
