package org.springframework.samples.petclinic.pet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * MyPetController
 */
@Controller("Controller example")
public class MyPetController {

    private final MyPetRepository pets;

    public MyPetController(MyPetRepository petService) {
        this.pets = petService;
    }

    @GetMapping("/pets.html")
    public String showPetList(Map<String, Object> model) {
        List<Pet> pets = new ArrayList<>();
        pets.addAll(this.pets.findAll());
        model.put("pets", pets);
        return "pets/petList";
    }

    public MyPetRepository getPets() {
        return pets;
    }
}