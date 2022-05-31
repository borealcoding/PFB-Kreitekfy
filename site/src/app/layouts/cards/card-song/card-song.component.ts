import { Component, OnInit } from '@angular/core';
import { Song } from 'src/app/entities/song/model/song.model';
import { CardSongService } from './services/card-song.service';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-card-song',
  templateUrl: './card-song.component.html',
  styleUrls: ['./card-song.component.scss']
})
export class CardSongComponent implements OnInit {

 id!: number;
  song!: Song;
  constructor(private songCardService: CardSongService, private route: ActivatedRoute ) { }

  ngOnInit(): void {
    // this.getAllSongs()

      this.id = +this.route.snapshot.paramMap.get("songId")!;

    
    this.getOneSong(this.id);


  }

  public handleError(err: String) {
    console.log("error")
  }

  public getOneSong(id:number) {
    this.songCardService.getOneSong(id).subscribe({
  next: (data: Song) =>{
    this.song = data;
  },
  error: (err) => {this.handleError(err);}
  })
  }

  // public getAllSongs(){
  //   this.songCardService.getAllSongs().subscribe(
  //     (data) =>{
  //       data.forEach((song)=>{
  //         this.songs.push(song);
  //         console.log(this.songs)
  //       }) 
  //     }
  //   )
  // }
}
