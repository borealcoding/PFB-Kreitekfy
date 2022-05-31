export class Artist {
    id: number | undefined;
    name: string;
    styleId?: number;
    styleName?: string;



  constructor(
    id: number , 
    name: string, 
    styleId?: number, 
    styleName?: string
) {
    this.id = id
    this.name = name
    this.styleId = styleId
    this.styleName = styleName
  }

}