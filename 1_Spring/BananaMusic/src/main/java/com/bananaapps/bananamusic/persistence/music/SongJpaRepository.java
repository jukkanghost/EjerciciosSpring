package com.bananaapps.bananamusic.persistence.music;

import com.bananaapps.bananamusic.domain.music.Song;
import com.bananaapps.bananamusic.domain.music.SongCategory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.Collection;

@Repository
@Profile("prod")
public class SongJpaRepository implements SongRepository{

    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public Song findOne(Long id) {
        return em.find(Song.class, id);
    }

    @Override
    @Transactional
    public Collection<Song> findAll() {
        TypedQuery<Song> q = em.createQuery("SELECT s FROM Song", Song.class);
        return q.getResultList();
    }

    @Override
    @Transactional
    public Collection<Song> findByArtistContainingOrTitleContainingAllIgnoreCase(String artist, String title) {
        TypedQuery<Song> q = em.createQuery("SELECT s FROM Song s WHERE s.artist LIKE CONCAT('%',:artist,'%') OR s.title LIKE CONCAT('%',:title,'%')", Song.class);
        q.setParameter("artist", artist);
        q.setParameter("title", title);
        return q.getResultList();
    }

    @Override
    @Transactional
    public Collection<Song> findBySongCategory(SongCategory category) {
        TypedQuery<Song> q = em.createQuery("SELECT s FROM Song s WHERE s.category = :category", Song.class);
        q.setParameter("category", category);
        return q.getResultList();
    }

    @Override
    @Transactional
    public long count() {
        Query q = em.createQuery("SELECT COUNT(*) FROM Song");
        return (long) q.getSingleResult();
    }

    @Override
    @Transactional
    public Song save(Song song) {
        em.persist(song);
        return song;
    }

    @Override
    @Transactional
    public void delete(Song song) {
        em.remove(song);
    }
}
