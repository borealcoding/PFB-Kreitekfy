package com.kreitek.kreitekfy.application.service;

import com.kreitek.kreitekfy.application.dto.AlbumDTO;

import java.util.List;
import java.util.Optional;

public interface AlbumService {
    List<AlbumDTO> getAllAlbums();
    AlbumDTO saveAlbum(AlbumDTO albumDTO);
}
