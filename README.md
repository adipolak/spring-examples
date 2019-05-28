# README

## Instruction

- Initial folder contains with original () solution with pet views added for lab usage. 
- Complete folder contains the solution that for reference

## Setup
- Install VSCode 
- Install VSCode Java extension pack
- git clone https://github.com/yaohaizh/spring-examples.git
- cd spring-examples


## Labs

### Run the application 
- On workspace root, open the initial folder on the VSCode
```bash
cd initial
code . 
``` 
- Open "Maven Projects" from the file explorer view
- Execute "wro4j:run" from the plugin wro4j in the tree explorer. This operation will generate the required css for appliction.
- Open PetClinicApplication.java, find the code lens on the main function in the editor window, click "Run" or "Debug" to trigger the application. 
- After the application ready (See more information from the debug console), you can open http://localhost:8080 on your browser. Now a basic spring-boot application is ready. 
- When you click "Pets" tab, it will show errors on the webpage. We will complete the code to show all the pets in this lesson. 

### Edit code 

> The complete code is under spring-examples/complete/src/main/java/org/springframework/samples/petclinic/pet for your reference

- Stop previous running/debugging session. 
- Create folder `pet` under src/main/java/org/springframework/samples/petclinic
- Create file `MyPetController.java` under the `pet` folder 
- Input `class` snippet to generate the main class body
- Add annotion `@Controller("Controller example")` above class `MyPetController` to generate the code to avoid the beans confliction.
- Create file `MyPetRepository.java` under the `pet` folder
- Input `interface` to trigger snippet to generate the interface code. 
- Extends the interface from `Repository` class with generic type `Pet` & `Integer`, and resolve the type by context menu `Source Action...` ==> `Organize imports`
- Complete the remaining code in the `MyPetRepositgory.java` following the file `spring-examples/complete/src/main/java/org/springframework/samples/petclinic/pet/MyPetRepositgory.java`
Here is the complete interface code: 

    ```java
    package org.springframework.samples.petclinic.pet;

    import java.util.Collection;

    import org.springframework.dao.DataAccessException;
    import org.springframework.data.repository.Repository;
    import org.springframework.samples.petclinic.owner.Pet;
    import org.springframework.transaction.annotation.Transactional;

    /**
    * PetRepository
    * 
    * @param <Pet>
    */
    public interface MyPetRepository extends Repository<Pet, Integer> {

        /**
        * Retrieve all <code>Pet</code>s from the data store.
        *
        * @return a <code>Collection</code> of <code>Pet</code>s
        */
        @Transactional(readOnly = true)
        Collection<Pet> findAll() throws DataAccessException;
    }
    ```

- Complete the remaining code in the `MyPetController.java` following the file `spring-examples/complete/src/main/java/org/springframework/samples/petclinic/pet/MyPetController.java`
    ```java
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
    ```
- Go to file `Pet.java`
- Add a method `getOwnerName()` in the `Pet` class
    ```java
        public String getOwnerName() {
            return this.owner.getFirstName() + ' ' + this.owner.getLastName();
        }
    ```
- After the code ready, rerun the application by trigger code lens from the `PetClinicApplication.java`
- Open `http://localhost:8080`, now when you click the Pets tab in the layout view, you can find all the pets in this application store.
