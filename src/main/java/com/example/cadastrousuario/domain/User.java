package com.example.cadastrousuario.domain;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")


@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    @Column(unique = true)
    private String email;

    public User(@Valid RequestUser requestUser) {
        this.name = requestUser.name();
        this.email = requestUser.email();
    }
}
