package RomanoPietro.unit5week2day2.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ExampleBlogPost")
public class ExampleBlogPostController {

    @GetMapping
    public String getExample1() {
        return "Ciao io sono l'example che risponde alle richieste GET numero 1"; // GET ->http://localhost:3003/ExampleBlogPost
    }

    @GetMapping("/getExampleBlogPost2")
    public String getExampleBlogPost2() {
        return "Ciao io sono l'example che risponde alle richieste GET numero 2"; //GET ->http://localhost:3003/example/getExampleBlogPost2
    }

    @PostMapping
    public String postExample() {
        return "Ciao io sono l'example che risponde alle richieste POST"; //POST ->http://localhost:3003/ExampleBlogPost
    }

    @PutMapping
    public String putExample() {
        return "Ciao io sono l'example che risponde alle richieste PUT"; //PUT ->http://localhost:3003/ExampleBlogPost
    }

    @PatchMapping
    public String patchExample() {
        return "Ciao io sono l'example che risponde alle richieste PATCH"; //PATCH ->http://localhost:3003/ExampleBlogPost
    }

    @DeleteMapping
    public String deleteExample() {
        return "Ciao io sono l'example che risponde alle richieste DELETE"; //DELETE ->http://localhost:3003/ExampleBlogPost
    }
}
