// Le package définit l'organisation de votre projet.
package com.sidoCoop.mon_premier_webservice;

// Importations des classes nécessaires depuis le framework Spring et Java.
import org.springframework.web.bind.annotation.GetMapping;      // Pour mapper les requêtes HTTP GET.
import org.springframework.web.bind.annotation.RequestParam;    // Pour extraire les paramètres d'une requête URL.
import org.springframework.web.bind.annotation.RestController;   // Pour déclarer que cette classe est un contrôleur REST.

import java.util.concurrent.atomic.AtomicLong; // Pour créer un compteur thread-safe (sécurisé en environnement multi-thread).

/**
 * L'annotation @RestController combine @Controller et @ResponseBody.
 * Elle indique à Spring que cette classe est un contrôleur web et que les valeurs
 * retournées par ses méthodes doivent être écrites directement dans le corps de la
 * réponse HTTP (généralement en format JSON), sans passer par un système de vues.
 */
@RestController
public class GreetingController1 {

    // Un modèle de message (template) statique et final.
    // Le "%s" est un emplacement réservé (placeholder) qui sera remplacé
    // par une valeur dynamique (le nom de la personne à saluer).
    public static final String template = "hello, %s!";

    // Un compteur atomique pour générer des identifiants uniques de manière thread-safe.
    // AtomicLong garantit que même si plusieurs requêtes arrivent en même temps,
    // chaque salutation aura un ID unique sans risque de conflit.
    private final AtomicLong counter = new AtomicLong();

    /**
     * Cette annotation mappe les requêtes HTTP GET faites à l'URL "/greeting1"
     * à la méthode greeting() ci-dessous. Quand un utilisateur visite
     * http://localhost:8080/greeting1, cette méthode est exécutée.
     */
    @GetMapping("/greeting1")
    // La signature de la méthode qui sera exécutée pour l'endpoint /greeting1.
    // Elle retourne un objet 'Greeting' qui sera automatiquement sérialisé en JSON.
    public Greeting greeting(
            /**
             * L'annotation @RequestParam lie la valeur d'un paramètre de la requête HTTP
             * à un paramètre de la méthode.
             * - value = "name": Indique que nous cherchons le paramètre nommé "name" dans l'URL (ex: ...?name=Sidonie).
             * - defaultValue = "world": Si le paramètre "name" n'est pas fourni, la valeur par défaut "world" sera utilisée.
             * - String name: La valeur extraite (ou la valeur par défaut) est stockée dans la variable 'name' de type String.
             */
            @RequestParam(value = "name", defaultValue = "world") String name) {

        // Crée et retourne une nouvelle instance de l'objet Greeting.
        return new Greeting(
                // 1er argument du constructeur Greeting : l'ID.
                // Incrémente le compteur atomique de 1 et retourne la nouvelle valeur.
                // Ceci sert d'ID unique pour la salutation.
                counter.incrementAndGet(),

                // 2ème argument du constructeur Greeting : le contenu du message.
                // Utilise le modèle 'template' ("hello, %s!") et remplace le placeholder "%s"
                // par la valeur de la variable 'name'.
                String.format(template, name)
        );
    }
}