package com.coveo.globalauroradatabase.controller;


import com.coveo.globalauroradatabase.entities.postgres.Playlist;
import com.coveo.globalauroradatabase.service.PlaylistServiceInterface;
import com.coveo.globalauroradatabase.service.PostgresPlaylistService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlist")
@Profile("postgres")
public class PostgresPlaylistController {

    private final PlaylistServiceInterface playlistService;

    public PostgresPlaylistController(PostgresPlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void savePlaylist(@RequestBody Playlist playlist) {
        this.playlistService.create(playlist);
    }

    @GetMapping()
    public List<Playlist> getAll() {
        return this.playlistService.getAll();
    }

}
