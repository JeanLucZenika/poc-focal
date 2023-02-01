package com.coveo.globalauroradatabase.controller;


import com.coveo.globalauroradatabase.entities.dynamo.Playlist;
import com.coveo.globalauroradatabase.service.DynamoPlaylistService;
import com.coveo.globalauroradatabase.service.PlaylistServiceInterface;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlist")
@Profile("Dynamo")
public class DynamoPlaylistController {

    private final PlaylistServiceInterface playlistService;

    public DynamoPlaylistController(DynamoPlaylistService playlistService) {
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
