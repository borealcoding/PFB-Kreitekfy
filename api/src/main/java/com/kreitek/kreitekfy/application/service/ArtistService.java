package com.kreitek.kreitekfy.application.service;

import com.kreitek.kreitekfy.application.dto.ArtistDTO;

import java.util.List;

public interface ArtistService {
    List<ArtistDTO> getAllArtist();
    ArtistDTO saveArtist(ArtistDTO artistDTO);
    List<ArtistDTO> getAllArtistByPartialName(String partialName);
}
