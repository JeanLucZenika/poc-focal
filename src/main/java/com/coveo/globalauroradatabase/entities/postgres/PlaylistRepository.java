package com.coveo.globalauroradatabase.entities.postgres;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

@Profile("postgres")
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
}
