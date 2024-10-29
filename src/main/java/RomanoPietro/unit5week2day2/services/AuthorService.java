package RomanoPietro.unit5week2day2.services;

import RomanoPietro.unit5week2day2.entites.Author;
import RomanoPietro.unit5week2day2.exceptions.NotFoundException;
import RomanoPietro.unit5week2day2.payloads.NewAuthorPayLoad;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AuthorService {
    private List<Author> AuthorList = new ArrayList<>();

    public List<Author> findAll(){
        return this.AuthorList;
    }

    public Author findById (int authorId ) {
        Author foundAuthor = null;
        for (Author author : this.AuthorList){
            if(author.getId() == authorId) foundAuthor = author;
        }
        if (foundAuthor == null) throw new NotFoundException(authorId);
        return foundAuthor;
    }

    public Author saveAuthor(NewAuthorPayLoad body) {
        Random rndm = new Random();
        Author newAuthor = new Author(body.getName(),body.getSurname(),body.getEmail(),body.getDateOfBirth());
        newAuthor.setId(rndm.nextInt(1, 1000));
        newAuthor.setAvatar("https://ui-avatars.com/api/?name=Mario+Rossi" + body.getName() + " + " + body.getSurname());
        this.AuthorList.add(newAuthor);
        return newAuthor;
    }

    public Author findAuthorByIdAndUpdate(int authorId, NewAuthorPayLoad body) {
        Author foundAuthor = null;
        for (Author author : this.AuthorList) {
            if (author.getId() == authorId) {
                foundAuthor = author;
                foundAuthor.setName(body.getName());
                foundAuthor.setSurname(body.getSurname());
                foundAuthor.setDateOfBirth(body.getDateOfBirth());

                return foundAuthor;
            }
        }
        if (foundAuthor == null) throw new NotFoundException(authorId);
        return foundAuthor;
    }

    public void findByIdAndDelete(int AuthorId) {
        Author foundAuthor = null;
        for (Author author : this.AuthorList) {
            if (author.getId() == AuthorId){
                foundAuthor = author;

            }
        }
            if (foundAuthor == null) throw new NotFoundException(AuthorId);
            this.AuthorList.remove(foundAuthor);
    }
}
