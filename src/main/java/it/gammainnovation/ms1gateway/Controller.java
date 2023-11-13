package it.gammainnovation.ms1gateway;

import it.gammainnovation.librarymodel.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Controller {

    @PostMapping("/signup")
    public void signUp(@RequestBody User newUser) {     //Angular service will send JSON object

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
