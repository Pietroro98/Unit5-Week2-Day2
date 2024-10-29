package RomanoPietro.unit5week2day2.controllers;
import RomanoPietro.unit5week2day2.entites.Author;
import RomanoPietro.unit5week2day2.payloads.NewAuthorPayLoad;
import RomanoPietro.unit5week2day2.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//***********************USERS CRUD*************************

/*
 1. GET http://localhost:3003/Author
 2. GET http://localhost:3003/Author/:{AuthorId}
 3. POST http://localhost:3003/Author (+ payLoad)
 4. PUT http://localhost:3003/Author/:{AuthorId} (+ payLoad)
 5. DELETE http://localhost:3003/Author/:{AuthorId}
 */

//**********************************************************

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    // 1. GET http://localhost:3003/Author
    @GetMapping
    public List<Author> getAuthor() {
        return authorService.findAll();
    }

    // 2. GET http://localhost:3003/Author:{AuthorId}
    @GetMapping("/{AuthorId}")
    public Author findAuthorById(@PathVariable int AuthorId) {
        return this.authorService.findById(AuthorId);
    }

    //3. POST http://localhost:3003/Author (+ payLoad)
    @PostMapping
    public Author createAuthor(@RequestBody NewAuthorPayLoad body) {
        return this.authorService.saveAuthor(body);
    }

    // 4. PUT http://localhost:3003/Author/:{AuthorId} (+ payLoad)
    @PutMapping("/{AuthorId}")
    public Author findAuthorByIdAndUpdate(@PathVariable int AuthorId, @RequestBody NewAuthorPayLoad body){
        return this.authorService.findAuthorByIdAndUpdate(AuthorId, body);
    }

    //5. DELETE http://localhost:3003/Author/:{AuthorId}
    @DeleteMapping("/{AuthorId}")
    public void findAuthorByIdAndDelete(@PathVariable int AuthorId) {
        this.authorService.findByIdAndDelete(AuthorId);
    }
}
