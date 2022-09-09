package br.com.amxsistemas.phoenix.domains;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="dom_status")
public class Status {

    @Id
    @Column(name="dst_id")
    private int id;

    @Column(name="dst_name", unique = true, nullable=false)
    private String name;

}
