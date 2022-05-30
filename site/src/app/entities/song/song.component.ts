import { Component, OnInit } from '@angular/core';
import { Song } from './model/song.model';
import { SongService } from './services/song.service';

@Component({
  selector: 'app-song',
  templateUrl: './song.component.html',
  styleUrls: ['./song.component.scss']
})
export class SongComponent implements OnInit {

  songs: Song[] = [];

  constructor(private songService: SongService) { }

  ngOnInit(): void {
    this.getAllSongs();
  }

  public getAllSongs(){
    this.songService.getAllSongs().subscribe(
      (data) =>{
        data.forEach((song)=>{
          this.songs.push(song);
          console.log(this.songs)
        }) 
      }
    )
  }

}
