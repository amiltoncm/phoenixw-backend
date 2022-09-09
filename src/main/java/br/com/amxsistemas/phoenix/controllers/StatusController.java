package br.com.amxsistemas.phoenix.controllers;

import br.com.amxsistemas.phoenix.domains.Status;
import br.com.amxsistemas.phoenix.services.StatusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {

    final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @PostMapping
    Status save(@RequestBody Status status) {
        return statusService.save(status);
    }

    @PostMapping("/list")
    String saveList(@RequestBody List<Status> status) {
        return statusService.saveList(status);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") int id) {
        statusService.delete(id);
    }

    @GetMapping
    List<Status> getAll() {
        return statusService.getAll();
    }

    @GetMapping("/{id}")
    Status get(@PathVariable("id") int id) {
        return statusService.getById(id);
    }

}
