package com.bananaapps.bananamusic.domain.user;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Email(message = "Must be a valid email")
    private String email;
    @NotBlank(message = "Must set a password")
    private String password;

    @Enumerated(EnumType.STRING)
    private ERole role;

    public User(Integer id) {
        this.id = id;
    }


}