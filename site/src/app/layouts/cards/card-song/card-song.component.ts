import { Component, OnInit } from '@angular/core';
import { Song } from 'src/app/entities/song/model/song.model';
import { ActivatedRoute } from '@angular/router';
import { SongService } from 'src/app/entities/song/services/song.service';


@Component({
  selector: 'app-card-song',
  templateUrl: './card-song.component.html',
  styleUrls: ['./card-song.component.scss']
})
export class CardSongComponent implements OnInit {
  countRate!: number;
  playedTimes!: number;
  id!: number;
  song!: Song;
  val!: number;
  constructor(private songService: SongService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = +this.route.snapshot.paramMap.get("songId")!;
    this.getOneSong(this.id);
  }

  public handleError(err: String) {
    console.log(err)
  }

  public getOneSong(id: number) {
    this.songService.getSongById(id).subscribe({
      next: (data: Song) => {
        this.song = data;
      },
      error: (err) => { this.handleError(err); }
    })
  }

  public reproducir() {
    this.song.playedTimes += 1;
    this.updateSong();

  }

  private updateSong(): void {
    this.songService.updateSong(this.song).subscribe({
      next: (songUpdate) => {
      }
    })
  }

  public valorar() {
    this.song.likes += this.val;
    this.song.countRate += 1;
    this.updateSong();
  }
}
