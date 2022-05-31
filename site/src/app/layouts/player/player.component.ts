import { Component, OnInit } from '@angular/core';
import { Song } from 'src/app/entities/song/model/song.model';
import { SongListService } from 'src/app/entities/song/song-list/services/song-list.service';

@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.scss']
})
export class PlayerComponent implements OnInit {

  songsByReleaseDate: Song[] = [];
  songsByPlayedtimes: Song[] = [];
  songsByLikes: Song[] = [];
  page: number = 0;
  size: number = 5;
  playedTimes:number = 0; 
  sortByDate: string = 'releaseDate,desc';
  sortByPlayedTimes: string = 'playedTimes,desc';
  sortByLikes: string = 'likes,desc';

  first: boolean = false;
  last: boolean = false;
  style: string = "";
  totalPages: number = 0;
  totalElements: number = 0;

  constructor(private songListService: SongListService) { }

  ngOnInit(): void {
    this.getAllSongs();
  
  }


  public searchByFilters(): void {
    this.getAllSongs();
  
  }

  private getAllSongs() {
    this.songListService.getAllSongs(this.page, this.size, this.sortByDate).subscribe({

      next: (data: any) => {
        this.songsByReleaseDate = data.content;
        this.first = data.first;
        this.last = data.last;
        this.totalPages = data.totalPages;
        this.totalElements = data.totalElements;
      },
   
    })

    this.songListService.getAllSongs(this.page, this.size, this.sortByPlayedTimes).subscribe({


      next: (data: any) => {

        this.songsByPlayedtimes = data.content;
        this.first = data.first;
        this.last = data.last;
        this.totalPages = data.totalPages;
        this.totalElements = data.totalElements;
      },
   
    })

    this.songListService.getAllSongs(this.page, this.size, this.sortByLikes).subscribe({

      next: (data: any) => {
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
