package br.com.amxsistemas.phoenix.controllers;

import br.com.amxsistemas.phoenix.entities.Establishment;
import br.com.amxsistemas.phoenix.services.EstablishmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/establishment")
public class EstablishmentController {

    final EstablishmentService establishmentService;

    public EstablishmentController (EstablishmentService establishmentService) {
        this.establishmentService = establishmentService;
    }

    @PostMapping
    Establishment save(@RequestBody Establishment establishment) {
        return establishmentService.save(establishment);
    }

    @DeleteMapping("/{id}")
    void delete (@PathVariable("id") UUID id) {
        establishmentService.delete(id);
    }

    @GetMapping
    public List<Establishment> getAll() {
        return establishmentService.getAll();
    }

    @GetMapping("/{id}")
    public Establishment getById(@PathVariable("id") UUID id) {
        return establishmentService.getById(id);
    }

}
