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
@Table(name="profiles")
public class Profile {

    @Id
    @GeneratedValue()
    @Column(name = "prf_id")
    private UUID id;

    @Column(name = "prf_code", unique = true, nullable = false)
    private int code;

    @Column(name = "prf_name", unique = true, nullable = false, length = 50)
    private String name;

    @Column(name = "dst_id", unique = true, nullable = false)
    private int statusId;

    @Column(name = "prf_created", updatable = false)
    private LocalDateTime created;

    @Column(name = "prf_updated", nullable = false)
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
