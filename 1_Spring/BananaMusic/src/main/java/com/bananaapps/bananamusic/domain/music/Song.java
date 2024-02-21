package com.bananaapps.bananamusic.domain.music;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tune")
@Inheritance(strategy = InheritanceType.JOINED)
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 1, max = 30, message = "Title and artist must be between 1 and 20 characters")
    private String title, artist;
    private LocalDate releaseDate;
    @Column(name = "cost")
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private SongCategory songCategory;
    private int version;
    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Collection<Backlog> backlogRecords = new ArrayList<Backlog>();

    public void addBacklogRecord(String location, int quantity) {
        Backlog iv = new Backlog(location, quantity);

        getBacklogRecords().add(iv);
        iv.setItem(this);
    }

    @Transient
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Song(Long id) {
        setId(id);
    }

    public Song(String title, String artist, String releaseDate, BigDecimal price, SongCategory musicCategory) {
        this.setTitle(title);
        this.setArtist(artist);
        this.setReleaseDateAsString(releaseDate);
        this.setPrice(price);
        this.setSongCategory(musicCategory);
    }

    public Song(Long id, String title, String artist, String releaseDate, BigDecimal price, SongCategory musicCategory) {
        this.setId(id);
        this.setTitle(title);
        this.setArtist(artist);
        this.setReleaseDateAsString(releaseDate);
        this.setPrice(price);
        this.setSongCategory(musicCategory);
    }

    public void setReleaseDateAsString(String releaseDateString) {
        releaseDate = LocalDate.parse(releaseDateString, formatter);
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (o == this) {
            result = true;
        } else if (o instanceof Song) {
            Song other = (Song) o;
            result = Objects.equals(this.getTitle(), other.getTitle()) &&
                    Objects.equals(this.getArtist(), other.getArtist()) &&
                    Objects.equals(this.getReleaseDate(), other.getReleaseDate());
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.title, this.artist, this.releaseDate);
    }

}
