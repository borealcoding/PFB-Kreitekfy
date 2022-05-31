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
  mode: "NEW" | "UPDATE" = "NEW";
  id?: number;
  song?: Song;

  constructor(private route: ActivatedRoute, private songService: SongService) { }

  ngOnInit(): void {
    const entryParam: string = this.route.snapshot.paramMap.get('id') ?? "new";
    if (entryParam !== "new") {
      this.id = +this.route.snapshot.paramMap.get("id")!;
      this.mode = "UPDATE";
      this.getSongById(this.id!);
    } else {
      this.mode = "NEW";
      this.initializeSong();
    }
  }

  private getSongById(id: number) {
    this.songService.getSongById(id).subscribe({
      next: (songRequest) => { this.song = songRequest; },
      error: (error) => { this.handleError(error) }
    })
  }

  private initializeSong(): void {
    this.song = new Song();
  }

  public saveSong(): void {
    if (this.mode === "NEW") {
      this.insertSong();
    }

    if (this.mode === "UPDATE") {
      this.updateSong();
    }
  }

  private insertSong(): void {
    this.songService.insertSong(this.song!).subscribe({
      next: (insertedSong) => { 
        console.log("Canción añadida!");
        console.log(insertedSong);
       },
      error: (error) => { this.handleError(error) }
    })
  }

  private updateSong(): void {
    this.songService.updateSong(this.song!).subscribe({
      next: (updatedSong) => { 
        console.log("Canción modificada!");
        console.log(updatedSong);
       },
      error: (error) => { this.handleError(error) }
    })
  }

  public handleError(error: any): void {
    console.log(error);
  }
}
