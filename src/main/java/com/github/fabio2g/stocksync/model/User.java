package com.github.fabio2g.stocksync.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name ="tb_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String login;
    private String password;
    private String registration;
    private String role;

    public User(String name, String login, String password, String registration, String role) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.registration = registration;
        this.role = role;
    }
}
