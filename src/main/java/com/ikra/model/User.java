package com.ikra.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Entity
@Table(name = "account",schema = "public")
@Getter @Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true, nullable = false)
    Long id;

    @NotNull
    @Column(name = "name")
    String name;

    @Column(name = "last_name")
    String lastName;

    @NotNull
    @Column(name = "password")
    String password;

    @NotNull
    @Column(name = "email", unique = true)
    String email;

    @Column(name = "created_on")
    LocalDateTime created_on;

    @Column(name = "last_login")
    LocalDateTime last_login;

}
