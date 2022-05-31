export class Song {
    id: number | undefined;
    name: string;
    duration: number;
    countRate :number;
    releaseDate: Date;
    likes: number;
    playedTimes: number;
    artistId?: number;
    artistName?: string;
    albumId?: number;
    albumName?: string;
    image: string;
<<<<<<< HEAD
    styleId: number;
    styleName: string;
  
=======
    styleId?: number;
    styleName?: string;
>>>>>>> dbe4d5cb9a11631fbff83944e16f4c3ba9eac6d9

    constructor() {
        this.id = 0;
        this.name = "";
        this.duration = 0;
        this.countRate = 0;
        this.releaseDate = new Date();
        this.likes = 0;
        this.playedTimes = 0;
        this.artistId = 0;
        this.artistName = ""
        this.albumId = 0;
        this.albumName = "";
        this.image = "";
        this.styleId = 0;
        this.styleName = "";
    }
}



