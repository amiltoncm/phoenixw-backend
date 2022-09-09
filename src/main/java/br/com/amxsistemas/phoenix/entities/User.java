package br.com.amxsistemas.phoenix.entities;

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
public class User {

    @Id
    private UUID id;

    private int code;

    private String name;

    private String password;

    private UUID establishmentId;

    private UUID profileID;

    private int statusId;

}
