package com.coveo.globalauroradatabase.service;

import java.util.List;

public interface PlaylistServiceInterface<T> {
    void create(T playlist);

    List<T> getAll();
}
