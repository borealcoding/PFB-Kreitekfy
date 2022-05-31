import { TestBed } from '@angular/core/testing';

import { CardSongService } from './card-song.service';

describe('CardSongService', () => {
  let service: CardSongService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CardSongService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
