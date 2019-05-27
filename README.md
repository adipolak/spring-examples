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
- Open "Maven Projects" from the file explorer view
- Execute "wro4j:run" from the plugin wro4j in the tree explorer. This operation will generate the required css for appliction
- Open PetClinicApplication.java, find the code lens on the main function, click "Run" or "Debug" to trigger the application. 
- After the application ready(See the information from the debug console), you can open http://localhost:8080 on your browser. You can find when click "Pets" tab, it will show errors. We will complete the code to show all the pets in this lesson. 

### Edit code 

The complete is under spring-examples/complete/src/main/java/org/springframework/samples/petclinic/pet for your reference

- Stop previous running/debugging session. 
- Create folder `pet` under src/main/java/org/springframework/samples/petclinic
- Create file `MyPetController.java` under the `pet` folder 
- Input `class` snippet to generate the main class body
- Add `@Controller("Controller example")` to generate the code to avoid the beans conflication
- Create file `MyPetRepository.java` under the `pet` folder
- Input `interface` to trigger snippet to generate the interface code. 
- Extends the interface from `Repository` class.
- Complete the remaining code in the `MyPetRepositgory.java` following the file `spring-examples/complete/src/main/java/org/springframework/samples/petclinic/pet/MyPetRepositgory.java`
- Complete the remaing code i the `MyPetController.java` following the file `spring-examples/complete/src/main/java/org/springframework/samples/petclinic/pet/MyPetController.java`
- Go to file `Pet.java`
- Add a method `getOwnerName()` in the `Pet` class
- After the code ready, rerun the application by trigger code lens from the `PetClinicApplication.java`
- Open `http://localhost:8080`, now when you click the Pets tab in the layout view, you can find all the pets in this application.

