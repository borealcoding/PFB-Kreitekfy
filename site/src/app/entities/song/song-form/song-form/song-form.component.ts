import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Album } from 'src/app/entities/album/model/album.model';
import { AlbumService } from 'src/app/entities/album/services/album.service';
import { Artist } from 'src/app/entities/artist/model/artist.model';
import { Style } from 'src/app/entities/style/model/style.model';
import { StyleService } from 'src/app/entities/style/services/style.service';
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
  album?: Album;
  artist?: Artist;
  selectedArtist?: Artist;
  selectedStyle?: Style;
  styles: Style[] = [];
  selectedAlbum?: Album;
  albums: Album[] = [];

  constructor(private route: ActivatedRoute,
    private songService: SongService,
    private styleService: StyleService,
    private albumService: AlbumService) { }

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

  public getAllStyles(event?: any): void{
    let styleSearch: string | undefined;
    if (event?.query) {
      styleSearch = event.query;
    }
    this.styleService.getAllStyles(styleSearch).subscribe({
      next: (stylesFiltered) => { this.styles = stylesFiltered; },
      error: (error) => { this.handleError(error); }
    });
  }

  public styleSelected(): void {
    this.song!.styleId = this.selectedStyle!.id;
    this.song!.styleName = this.selectedStyle!.name;
  }

  public unselectedStyle(): void {
    this.song!.styleId = undefined;
    this.song!.styleName = undefined;
  }

  public albumSelected(): void {
    this.album!.id = this.selectedAlbum!.id;
    this.album!.name = this.selectedAlbum!.name;
  }

  public unselectedAlbum(): void {
    this.album!.id = undefined;
    this.album!.name = undefined;
  }

  public artistSelected(): void {
    this.artist!.id = this.selectedArtist?.id!;
    this.artist!.name = this.selectedArtist?.name!;
  }

  public unselectedArtist(): void {
    this.artist!.id = undefined;
    this.artist!.name = undefined;
  }

  private getSongById(id: number) {
    this.songService.getSongById(id).subscribe({
      next: (songRequest) => { 
        this.song = songRequest;
        this.selectedStyle = new Style(songRequest.styleId!, songRequest.styleName!);
        this.selectedAlbum = new Album(songRequest.albumId!, songRequest.albumName!, songRequest.image);
        this.selectedArtist = new Artist(songRequest.artistId!, songRequest.artistName!);

        this.getAllAlbums(this.selectedArtist!.name!);

       },
      error: (error) => { this.handleError(error); }
    });
  } 

  public getAllAlbums(nameArtist: string){
    console.log(nameArtist);
    this.albumService.getAllAlbums(nameArtist).subscribe({
      next: (albumsFiltered) => { this.albums = albumsFiltered; },
      error: (error) => { this.handleError(error); }
    });
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
