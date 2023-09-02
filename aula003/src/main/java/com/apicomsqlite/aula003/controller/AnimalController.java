package com.apicomsqlite.aula003.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.apicomsqlite.aula003.enity.Animal;
import com.apicomsqlite.aula003.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info() {
        return "Aplicacao ativa";
    }

    @RequestMapping(value = "createanimal", method = RequestMethod.POST)
    public String createanimal(@RequestBody Animal animal) {
        return animalService.createanimal(animal);
    }

    @RequestMapping(value = "readanimal", method = RequestMethod.GET)
    public List<Animal> readanimal() {
        return animalService.readanimal();
    }

    @RequestMapping(value = "updateanimal/{id}", method = RequestMethod.PUT)
    public String updateaniamal(@PathVariable int id, @RequestBody Animal updatedAnimal) {
        updatedAnimal.setId(id);
        return animalService.updateanimal(updatedAnimal);
    }

    @RequestMapping(value = "deleteanimal/{id}", method = RequestMethod.DELETE)
    public String deleteanimal(@PathVariable int id) {
        return animalService.deleteanimal(id);
    }
}
