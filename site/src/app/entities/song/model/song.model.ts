export class Song {
    id: number;
    name: string;
    duration: number;
    releaseDate: Date;
    likes: number;
    playedTimes: number;
    artistId: number;
    artistName: String;
    albumId: number;
    albumName: string;
    totalSongs: number;
    albumReleaseDate: Date;
    albumImage: string;

    constructor() {
        this.id = 0;
        this.name = "";
        this.duration = 0;
        this.releaseDate = new Date();
        this.likes = 0;
        this.playedTimes = 0;
        this.artistId = 0;
        this.artistName = ""
        this.albumId = 0;
        this.albumName = "";
        this.totalSongs = 0;
        this.albumReleaseDate = new Date();
        this.albumImage = "";
    }
}



