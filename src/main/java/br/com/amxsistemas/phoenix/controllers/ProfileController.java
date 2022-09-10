package br.com.amxsistemas.phoenix.controllers;

import br.com.amxsistemas.phoenix.entities.Profile;
import br.com.amxsistemas.phoenix.services.ProfileService;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    final ProfileService profileService;

    public ProfileController (ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping
    Profile save(@RequestBody Profile profile) throws ParseException {
        return profileService.save(profile);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") UUID id) {
        profileService.delete(id);
    }

    @GetMapping
    public List<Profile> getAll() {
        return profileService.getAll();
    }

    @GetMapping("/{id}")
    public Profile getById(@PathVariable("id") UUID id) {
        return profileService.getById(id);
    }

}
