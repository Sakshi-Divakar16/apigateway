package com.cinebuzz.apigateway.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cinebuzz.apigateway.model.LoginForm;
import com.cinebuzz.dto.ShowDto;
import com.cinebuzz.dto.TheatreDto;

import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UIController {

    private static final Logger logger = LoggerFactory.getLogger(UIController.class);

    private final RestTemplate restTemplate;

    @Value("${cinebuzz.api.base-url}") 
    private String baseApiUrl;

    public UIController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @GetMapping("/")
    public String home(Model model) {
        return "home"; 
    }
    @GetMapping("/index")
    public String redirectToIndex() {
        return "index"; // Redirect to index.html after home.html
    }
    
//
////    // Show login page
//    @GetMapping("/admin_login")
//    public String showAdminLoginPage() {
//        return "admin_login";  // Load login page
//    }
//   
//
//   private static final String ADMIN_USERNAME = "Shivani";
//    private static final String ADMIN_PASSWORD = "123";
//
////    @PostMapping("/admin_login")
////    public String processAdminLogin(@RequestParam String username, 
////                                    @RequestParam String password, 
////                                    Model model) {
////    	System.out.println(username);
////        if (ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password)) {
////            return "redirect:/dashboard"; // Redirect to dashboard
////        } else {
////            model.addAttribute("error", "Invalid username or password!");
////            return "admin_login"; 
////        }
////    }
//    @PostMapping("/admin_login")
//    public String handleLogin(@Valid LoginForm loginForm, BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            return "admin_login";
//        }
// 
//        // Hardcoded validation for username and password
//        if ("user".equals(loginForm.getUsername()) && "password123".equals(loginForm.getPassword())) {
//            model.addAttribute("message", "Login successful!");
//            return "welcome";  // A welcome page or dashboard
//        } else {
//            model.addAttribute("error", "Invalid username or password");
//            return "admin_login";
//        }
//    }
    
    @PostMapping("/admin_login")
    public String handleLogin(@Valid @ModelAttribute("loginForm") LoginForm loginForm, 
                              BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "admin_login";
        }

        // Hardcoded credentials
        final String ADMIN_USERNAME = "Shivani";
        final String ADMIN_PASSWORD = "123";

        if (ADMIN_USERNAME.equals(loginForm.getUsername()) && ADMIN_PASSWORD.equals(loginForm.getPassword())) {
            return "redirect:/dashboard";  // Redirect to dashboard if login is successful
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "admin_login"; // Stay on login page and show error
        }
    }

    @GetMapping("/admin_login")
    public String showAdminLoginPage(Model model) {
        model.addAttribute("loginForm", new LoginForm()); // Add empty login form object
        return "admin_login";
    }

        
        @GetMapping("/dashboard")
        public String dashboard() {
            return "dashboard";
        }
        
//        @GetMapping("/manage_theatre")
//        public String showManageTheatresPage() {
//            return "manage_theatre"; // Ensure you have manage-theatres.html in templates
//        }


        @GetMapping("/manage_theatre")
        public String showManageTheatresPage(Model model) {
            String apiUrl = baseApiUrl + "/theatres";
            List<Map<String, Object>> theatres = fetchApiData(apiUrl);
            model.addAttribute("theatres", theatres);
            return "manage_theatre";
        }

//        @PostMapping("/add-theatre")
//        public String addTheatre(@RequestParam String theatreName, @RequestParam int capacity,
//                                 @RequestParam int screens, @RequestParam String country,
//                                 @RequestParam String state, @RequestParam String city, 
//                                 @RequestParam String addressLine) {
//            String apiUrl = baseApiUrl + "/theatres";
//            
//            Map<String, Object> newTheatre = Map.of(
//                "theatreName", theatreName,
//                "capacity", capacity,
//                "screens", screens,
//                "address", Map.of(
//                    "country", country,
//                    "state", state,
//                    "city", city,
//                    "addressLine", addressLine
//                )
//            );
//            
//            restTemplate.postForEntity(apiUrl, newTheatre, Void.class);
//            return "redirect:/manage_theatre";
//        }
        @PostMapping("/add-theatre")
        public ResponseEntity<String> addTheatre(@RequestBody TheatreDto theatre) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);  

            HttpEntity<TheatreDto> requestEntity = new HttpEntity<>(theatre, headers);

            // Forward request to Theatre Service
            ResponseEntity<String> response = restTemplate.postForEntity(baseApiUrl, requestEntity, String.class);

            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        }
    


        @GetMapping("/edit-theatre/{id}")
        public String editTheatreForm(@PathVariable Long id, Model model) {
            String apiUrl = baseApiUrl + "/theatres/" + id;
            Map<String, Object> theatre = restTemplate.getForObject(apiUrl, Map.class);
            model.addAttribute("theatre", theatre);
            return "edit_theatre";
        }

        @PostMapping("/update-theatre/{id}")
        public String updateTheatre(@PathVariable Long id, @RequestParam String theatreName,
                                    @RequestParam int capacity, @RequestParam int screens,
                                    @RequestParam String country, @RequestParam String state, 
                                    @RequestParam String city, @RequestParam String addressLine) {
            String apiUrl = baseApiUrl + "/theatres/" + id;
            
            Map<String, Object> updatedTheatre = Map.of(
                "theatreName", theatreName,
                "capacity", capacity,
                "screens", screens,
                "address", Map.of(
                    "country", country,
                    "state", state,
                    "city", city,
                    "addressLine", addressLine
                )
            );
            
            restTemplate.exchange(apiUrl, HttpMethod.PUT, new HttpEntity<>(updatedTheatre), Void.class);
            return "redirect:/manage_theatre";
        }

        @GetMapping("/delete-theatre/{id}")
        public String deleteTheatre(@PathVariable Long id) {
            String apiUrl = baseApiUrl + "/theatres/" + id;
            restTemplate.delete(apiUrl);
            return "redirect:/manage_theatre";
        }
        @GetMapping("/manage_movies")
        public String showManageMoviesPage(Model model) {
            String apiUrl = baseApiUrl + "/api/movies";
            List<Map<String, Object>> movies = fetchApiData(apiUrl);
            
            System.out.println("Fetched movies: " + movies); // Debugging line

            model.addAttribute("movies", movies);
            return "manage_movies";
        }

        @PostMapping("/add-movie")
        public String addMovie(@RequestParam String title, @RequestParam String genre, @RequestParam int duration) {
            String apiUrl = baseApiUrl + "/api/movies";
            
            Map<String, Object> newMovie = Map.of(
                "title", title,
                "genre", genre,
                "duration", duration
            );
            
            restTemplate.postForEntity(apiUrl, newMovie, Void.class);
            return "redirect:/manage_movies";
        }

        @GetMapping("/delete-movie/{id}")
        public String deleteMovie(@PathVariable Long id) {
            String apiUrl = baseApiUrl + "/api/movies/" + id;
            restTemplate.delete(apiUrl);
            return "redirect:/manage_movies";
        }
        
        
//        @GetMapping
//        public String getOffers(Model model) {
//            String apiUrl = baseApiUrl + "/offers";
//            logger.info("Fetching offers from API: {}", apiUrl);
//     
//            List<Map<String, Object>> offers = fetchApiData(apiUrl);
//            model.addAttribute("offers", offers);
//     
//            return "manage_offer";
//        }
//     
//        @PostMapping("/add")
//        public String addOffer(@RequestParam Long showId, @RequestParam String offerDetails, @RequestParam BigDecimal discountPercentage) {
//            String apiUrl = baseApiUrl + "/offers";
//            Map<String, Object> request = new HashMap<>();
//            request.put("showId", showId);
//            request.put("offerDetails", offerDetails);
//            request.put("discountPercentage", discountPercentage);
//     
//            logger.info("Adding new offer: {}", request);
//     
//            ResponseEntity<Void> response = restTemplate.postForEntity(apiUrl, request, Void.class);
//            if (response.getStatusCode() == HttpStatus.CREATED) {
//                logger.info("Offer added successfully.");
//            }
//     
//            return "redirect:/offers";
//        }
//     
//        @GetMapping("/edit/{id}")
//        public String editOffer(@PathVariable Long id, Model model) {
//            String apiUrl = baseApiUrl + "/offers/" + id;
//            logger.info("Fetching offer for edit: {}", apiUrl);
//     
//            Map<String, Object> offer = restTemplate.getForObject(apiUrl, Map.class);
//            model.addAttribute("offer", offer);
//     
//            return "offer-edit"; 
//        }
//     
//        @PostMapping("/update/{id}")
//        public String updateOffer(@PathVariable Long id, @RequestParam Long showId, @RequestParam String offerDetails, @RequestParam BigDecimal discountPercentage) {
//            String apiUrl = baseApiUrl + "/offers/" + id;
//            Map<String, Object> request = new HashMap<>();
//            request.put("showId", showId);
//            request.put("offerDetails", offerDetails);
//            request.put("discountPercentage", discountPercentage);
//     
//            logger.info("Updating offer ID {}: {}", id, request);
//     
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_JSON);
//            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(request, headers);
//     
//            restTemplate.exchange(apiUrl, HttpMethod.PUT, entity, Void.class);
//            return "redirect:/offers";
//        }
//     
//        @GetMapping("/delete/{id}")
//        public String deleteOffer(@PathVariable Long id) {
//            String apiUrl = baseApiUrl + "/offers/" + id;
//            logger.info("Deleting offer ID: {}", id);
//     
//            restTemplate.delete(apiUrl);
//            return "redirect:/offers";
//        }
//        
//        
        
    @GetMapping("/movies")
    public String getMovies(Model model) {
        String apiUrl = baseApiUrl + "/movies";
        logger.info("Fetching movies from API: {}", apiUrl);

        List<Map<String, Object>> movies = fetchApiData(apiUrl);
        model.addAttribute("movies", movies);

        return "movie-list";  // Thymeleaf template
    }
    

    @GetMapping("/theatres")
    public String getTheatres(Model model) {
        String apiUrl = baseApiUrl + "/theatres";
        logger.info("Fetching theatres from API: {}", apiUrl);

        List<Map<String, Object>> theatres = fetchApiData(apiUrl);
        model.addAttribute("theatres", theatres);

        return "theatre-list";
    }

    @GetMapping("/tickets")
    public String getTickets(Model model) {
        String apiUrl = baseApiUrl + "/tickets";
        logger.info("Fetching tickets from API: {}", apiUrl);

        List<Map<String, Object>> tickets = fetchApiData(apiUrl);
        model.addAttribute("tickets", tickets);

        return "ticket-list";
    }
    
    
    @GetMapping("/manage_movie_show")
    public ModelAndView manageMovieShows(@ModelAttribute("MovieShowObj") ShowDto movieShow) {
        // Fetching the list of shows from the backend API
        String apiUrl = baseApiUrl + "/shows";
        List<Map<String, Object>> shows = fetchApiData(apiUrl);

        // Creating a new instance of MovieShow (could be an empty object or populated with some data)
        ShowDto tempMovieShow = new ShowDto();
        
        // Creating ModelAndView instance and passing the shows data and the MovieShow object to the view
        ModelAndView modelAndView = new ModelAndView("manage_movie_show");
        modelAndView.addObject("shows", shows);  // Passing shows data
        modelAndView.addObject("MovieShowObj", tempMovieShow);  // Passing the MovieShow object to the view
        
        return modelAndView;  // Return the ModelAndView
    }

    

    @GetMapping("/edit/{id}")
    public String editShow(@PathVariable("id") Long id, Model model) {
        String apiUrl = baseApiUrl + "/shows/" + id;
        
        // Fetch the show from backend
        ShowDto showDto = restTemplate.getForObject(apiUrl, ShowDto.class);
        
        if (showDto != null) {
            model.addAttribute("MovieShowObj", showDto);
            return "editShow";  // Return the view name for editing
        } else {
            // If the show is not found, redirect or show an error page
            return "redirect:/manage_movie_show";  // Redirect to show list page
        }
    }
    
    @GetMapping("/delete/{id}")
    public String deleteShow(@PathVariable("id") Long id) {
        String apiUrl = baseApiUrl + "/shows/" + id;
        
        // Log and send a DELETE request to remove the show
        restTemplate.delete(apiUrl);
        
        // After deleting, redirect to the list of shows
        return "redirect:/manage_movie_show";
    }



    
    
    private List<Map<String, Object>> fetchApiData(String url) {
        try {
            ResponseEntity<List<Map<String, Object>>> response = restTemplate.exchange(
                url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Map<String, Object>>>() {}
            );

            return response.getBody() != null ? response.getBody() : Collections.emptyList();
        } catch (Exception e) {
            logger.error("Error fetching data from API: {}", url, e);
            return Collections.emptyList(); 
        }
    }
    
}


