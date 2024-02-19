package com.bananaapps.bananamusic.domain.music;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "downloadable_item")
@PrimaryKeyJoinColumn(name = "tune_id")
public class OfflineSong extends Song {

    private String url;
    private String fileType;

    public OfflineSong(String num, String title,
                       String artist, LocalDate releaseDate, BigDecimal price) {
        setTitle(title);
        setArtist(artist);
        setReleaseDate(releaseDate);
        setPrice(price);
    }

}
