package br.com.amxsistemas.phoenix.entities;

import br.com.amxsistemas.phoenix.utils.UserLogger;
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
@Table(name="establishments")
public class Establishment {

    @Id
    @GeneratedValue
    @Column(name = "etb_id")
    private UUID id;

    @Column(name = "etb_code", unique = true, nullable = false)
    private int code;

    @Column(name = "etb_name", unique = true, nullable = false, length = 70)
    private String name;

    @Column(name = "dst_id", nullable = false)
    private int statusId;

    @Column(name = "etb_created", updatable = false)
    private LocalDateTime created;

    @Column(name = "use_created", updatable = false)
    private UUID userCreated;

    @Column(name = "etb_updated", nullable = false)
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
