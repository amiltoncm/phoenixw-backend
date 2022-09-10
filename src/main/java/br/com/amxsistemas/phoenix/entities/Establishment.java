package br.com.amxsistemas.phoenix.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="establishments")
public class Establishment {

    @Id
    @Column(name = "etb_id")
    private UUID id;

    @Column(name = "etb_code", unique = true, nullable = false)
    private int code;

    @Column(name = "etb_name", unique = true, nullable = false, length = 70)
    private String name;

    @Column(name = "dst_id", nullable = false)
    private int statusId;

}
