export class Song {
    id: number | undefined;
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
    image: string;
    styleId: number;
    styleName: string;

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
        this.image = "";
        this.styleId = 0;
        this.styleName = "";
    }
}



