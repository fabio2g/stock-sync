package com.github.fabio2g.stocksync.model;

import com.github.fabio2g.stocksync.enums.RoleEnum;
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
@Table(name = "tb_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String login;
    private String password;
    private String registration;
    private RoleEnum role;
    private Boolean isDeleted;

    public User(String name, String login, String password, String registration) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.registration = registration;
        this.role = RoleEnum.USER;
        this.isDeleted = false;
    }
}
