package com.bananaapps.bananamusic.domain.music;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "purchase_order_line_song")
public class PurchaseOrderLineSong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lineNumber;

    @OneToOne
    @JoinColumn(name = "song_id")
    private Song song;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private PurchaseOrder order;
    private Integer quantity;
    private Double unitPrice;

    public PurchaseOrderLineSong(Long lineNumber, Song song, Integer quantity, Double unitPrice) {
        this.lineNumber = lineNumber;
        this.song = song;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

}
