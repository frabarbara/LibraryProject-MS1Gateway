package it.gammainnovation.ms1gateway;

import it.gammainnovation.librarymodel.User;
import it.gammainnovation.librarymodel.Book;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@RestController
public class Controller {

    @PostMapping("/signup")
    public User signUp(@RequestBody User newUser) {     //Angular service will send JSON object

        RestTemplate myRestTemplate = new RestTemplate();
        User signedUpUser = myRestTemplate.postForObject(
                "http://localhost:8083/signup",
                newUser,
                User.class
        );

        return signedUpUser;
    }

    @PostMapping("/login")
    public String signIn(@RequestBody Object credentials) {
        return "ciao";
    }

    @GetMapping("/library/booksearch")
    public ArrayList<Book> searchBook(
            @RequestParam String title,
            @RequestParam String author,
            @RequestParam int edition,
            @RequestParam String theme,
            @RequestParam int pubYear
    ) {
        ArrayList<Book> foundBooks = new ArrayList<>();
        /* [...] */
        return foundBooks;
    }
}
