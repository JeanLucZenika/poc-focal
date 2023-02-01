package com.coveo.globalauroradatabase.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.coveo.globalauroradatabase.entities.dynamo.Playlist;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Profile("Dynamo")
public class DynamoPlaylistService implements PlaylistServiceInterface<Playlist>{

    private final DynamoDBMapper dynamoDBMapper;


    public DynamoPlaylistService(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    @Transactional
    @Override
    public void create(Playlist playlist) {
        dynamoDBMapper.save(playlist);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Playlist> getAll() {
        return dynamoDBMapper.scan(Playlist.class, new DynamoDBScanExpression());
    }
}
