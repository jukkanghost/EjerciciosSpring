package com.bananaapps.bananamusic.persistence.music;

import com.bananaapps.bananamusic.domain.music.Song;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

@Profile("prod")
public interface SongJpaRepository extends JpaRepository<Song, Long>, SongRepository {

    public default Song findOne(Long id) {
        return findById(id).orElse(null);
    }

}
