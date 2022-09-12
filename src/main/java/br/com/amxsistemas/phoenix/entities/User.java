package br.com.amxsistemas.phoenix.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class User {

    @Id
    @Column(name = "use_id")
    @GeneratedValue
    private UUID id;

    @Column(name = "use_code", unique = true, nullable = false)
    private int code;

    @Column(name = "use_name", unique = true, nullable = false, length = 25)
    private String name;

    @Column(name = "use_password", nullable = false, length = 128)
    private String password;

    @Column(name = "use_email", nullable = false, length = 128)
    private String email;

    @Column(name = "etb_id")
    private UUID establishmentId;

    @Column(name = "prf_id", nullable = false)
    private UUID profileId;

    @Column(name = "dst_id", nullable = false)
    private int statusId;

    @Column(name = "use_created", updatable = false)
    private LocalDateTime created;

    @Column(name = "use_updated", nullable = false)
    private LocalDateTime updated;

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updated = LocalDateTime.now();
    }

}
