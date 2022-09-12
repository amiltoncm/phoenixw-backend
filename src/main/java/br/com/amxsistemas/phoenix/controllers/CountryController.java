package br.com.amxsistemas.phoenix.controllers;

import br.com.amxsistemas.phoenix.entities.Country;
import br.com.amxsistemas.phoenix.services.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/country")
public class CountryController {

    final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping
    Country save(@RequestBody Country country) {
        return countryService.save(country);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") UUID id) {
        countryService.delete(id);
    }

    @GetMapping
    List<Country> getAll() {
        return countryService.getAll();
    }

    @GetMapping("/id")
    Country getById(@PathVariable("id") UUID id) {
        return countryService.getById(id);
    }

}
