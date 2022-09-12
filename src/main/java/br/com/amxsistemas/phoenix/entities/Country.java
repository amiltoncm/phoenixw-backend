package br.com.amxsistemas.phoenix.entities;

import br.com.amxsistemas.phoenix.utils.UserLogger;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="countries")
public class Country {

    @Id
    @GeneratedValue
    @Column(name = "con_id")
    private UUID id;

    @Column(name = "con_code", unique = true, nullable = false)
    private int code;

    @Column(name = "con_name", unique = true, nullable = false, length = 75)
    private String name;

    @Column(name = "con_iso2", unique = true, length = 2)
    private String iso2;

    @Column(name = "con_iso3", unique = true, length = 3)
    private String iso3;

    @Column(name = "dst_id", nullable = false)
    private int statusId;

    @Column(name = "con_created", updatable = false)
    private LocalDateTime created;

    @Column(name = "use_created", updatable = false)
    private UUID userCreated;

    @Column(name = "con_updated", nullable = false)
    private LocalDateTime updated;

    @Column(name = "use_updated", nullable = false)
    private UUID userUpdated;

    @PrePersist
    public void prePersist() {

        created = LocalDateTime.now();
        userCreated = UserLogger.getUserLog();
    }

    @PreUpdate
    public void preUpdate() {

        updated = LocalDateTime.now();
        userUpdated = UserLogger.getUserLog();
    }

}
