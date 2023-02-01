package com.coveo.globalauroradatabase.service;

import com.coveo.globalauroradatabase.entities.postgres.Playlist;
import com.coveo.globalauroradatabase.entities.postgres.PlaylistRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Profile("postgres")
public class PostgresPlaylistService implements PlaylistServiceInterface<Playlist>{

    private final PlaylistRepository playlistRepository;

    public PostgresPlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @Override
    @Transactional
    public void create(Playlist playlist) {
        this.playlistRepository.save(playlist);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Playlist> getAll() {
        return playlistRepository.findAll();
    }
}
