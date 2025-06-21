// On déclare que cette classe appartient au package 'controller'
package com.sidoCoop.mon_premier_webservice;

// On importe les classes Spring dont nous avons besoin
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController est une annotation Spring très importante.
 * Elle indique que cette classe est un contrôleur REST.
 * Cela signifie qu'elle va gérer des requêtes HTTP et que les réponses
 * seront directement écrites dans le corps de la réponse HTTP (souvent en JSON ou texte simple),
 * sans passer par un système de templates HTML.
 */
@RestController
public class GreetingController {

    /**
     * @GetMapping est une autre annotation essentielle.
     * Elle lie une méthode à une requête HTTP de type GET.
     * Le chemin "/greeting" signifie que cette méthode sera appelée quand quelqu'un
     * accédera à l'URL : http://localhost:8080/greeting
     */
    @GetMapping("/greeting")
    public String getGreeting() {
        // C'est une méthode Java tout à fait normale.
        // Elle retourne une simple chaîne de caractères (String).
        // C'est cette chaîne qui sera affichée dans le navigateur.
        return "Félicitations ! Vous avez créé votre premier web service avec Spring Boot.";
    }

    /**
     * Ajoutons une autre route pour bien comprendre le principe.
     * Celle-ci sera accessible via http://localhost:8080/hello
     */
    @GetMapping("/hello")
    public String sayHello() {
        return "Bonjour tout le monde !";
    }
}