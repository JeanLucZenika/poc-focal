package com.coveo.globalauroradatabase.entities.dynamo;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import org.springframework.context.annotation.Profile;

@Profile("Dynamo")
@DynamoDBTable(tableName = "playlist")
public class Playlist {
    @DynamoDBHashKey(attributeName = "id")
    private Long id;

    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

