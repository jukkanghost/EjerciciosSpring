package com.bananaapps.bananamusic.domain.user;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private ERole role;

    public User(Integer id) {
        this.id = id;
    }


}