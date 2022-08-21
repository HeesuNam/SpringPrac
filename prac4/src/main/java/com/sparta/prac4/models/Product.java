package com.sparta.prac4.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Product extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private int lprice;

    @Column(nullable = false)
    private int myprice;

    public Product(ProductRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.link = requestDto.getLink();
        this.image = requestDto.getImage();
        this.lprice = requestDto.getLprice();
        this.myprice = 0;
    }

    public void update(ProductMypriceRequestDto mypriceRequestDto) {
        this.myprice = mypriceRequestDto.getMyprice();
    }

    public void updateBySearch(ItemDto itemDto) {
        this.lprice = itemDto.getLprice();
    }
}
