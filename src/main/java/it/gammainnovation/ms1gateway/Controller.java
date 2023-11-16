package it.gammainnovation.ms1gateway;

import it.gammainnovation.librarymodel.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@RestController
public class Controller {

    RestTemplate rt;

    public Controller() {
        this.rt = new RestTemplate();
    }

    @CrossOrigin(origins = {"http://localhost:4200"})
    @PostMapping("/signup")
    public User signup(@RequestBody User newUser) {     //Angular service will send JSON object
        User signedUpUser;

        signedUpUser = rt.postForObject(
                "http://localhost:8083/signup",
                newUser,
                User.class
        );

        return signedUpUser;
    }

    @PostMapping("/login")
    public User login(@RequestBody User credentials) {
        User loggedUser;

        System.out.println("[MS2Controller:login] credentials: email " + credentials.getEmail() + "; password " + credentials.getPassword());

        loggedUser = rt.postForObject(
                "http://localhost:8083/login",
                credentials,
                User.class
        );

        return loggedUser;
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

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getDailyMenu")
    public DailyMenu getMenu(){
        RestTemplate restTemplate = new RestTemplate();
        DailyMenu dailyMenu = restTemplate.getForObject("http://localhost:8082/getDailyMenuDB",DailyMenu.class);
        /*chiamerò il microservizio 2
         * Lui mi restiuirà il contenuto, lo memorizzo nel model menu
         * ma il service di visual studio, deve chiamare i metodi del back end*/
        return dailyMenu;
    }

    @PostMapping("/booktable")
    public void bookSeat(@RequestBody RestaurantTurn restaurantTurn){

    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getRestaurantTurn")
    public ArrayList<RestaurantTurn> getRestaurantTurn(){
        RestTemplate restTemplate = new RestTemplate();
        ArrayList<RestaurantTurn> restaurantTurn = restTemplate.getForObject("http://localhost:8082/getRestaurantTurn",ArrayList.class);
        return restaurantTurn;
    }
}
