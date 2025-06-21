# Mon Premier Web Service avec Spring Boot

Ce projet est une application de démonstration développée avec Spring Boot. Son objectif est de servir de point de départ pour comprendre les concepts fondamentaux de la création d'une API REST en Java.

L'application expose deux points d'accès (endpoints) pour illustrer comment retourner différents types de réponses : du texte simple (HTML) et un objet structuré (JSON).

## Prérequis

Pour compiler et exécuter ce projet, vous aurez besoin de :
-   [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) ou une version plus récente.
-   [Apache Maven](https://maven.apache.org/) (optionnel, car le projet inclut le wrapper Maven).

## Comment Lancer l'Application

Vous avez deux manières principales de lancer l'application.

---

### Option 1 : Depuis le code source (pour le développement)

Cette méthode est idéale pendant la phase de développement, car elle permet des redémarrages rapides sans avoir à reconstruire un package complet à chaque modification.

Ouvrez un terminal à la racine du projet et exécutez la commande suivante :

-   Sur **Windows** :
    ```bash
    mvnw.cmd spring-boot:run
    ```
-   Sur **macOS ou Linux** :
    ```bash
    ./mvnw spring-boot:run
    ```

---

### Option 2 : Depuis le fichier JAR (pour le déploiement)

Cette méthode simule la manière dont l'application serait déployée sur un serveur.

1.  **Construisez le projet** : Tout d'abord, vous devez empaqueter l'application dans un fichier JAR exécutable.
    ```bash
    # Sur Windows
    mvnw.cmd clean package
    ```

2.  **Lancez le fichier JAR** : Une fois le build terminé avec succès, un fichier `.jar` sera créé dans le dossier `target`. Lancez-le avec Java.
    ```bash
    java -jar target/mon-premier-webservice-0.0.1-SNAPSHOT.jar
    ```

---

Quelle que soit la méthode choisie, l'application démarrera et sera accessible sur `http://localhost:8080`.

## Points d'Accès de l'API (Endpoints)

L'application propose les deux endpoints suivants :

### 1. Salutation Simple (HTML)

-   **URL** : `http://localhost:8080/greeting`
-   **Méthode** : `GET`
-   **Réponse** : `Félicitations ! Vous avez créé votre premier web service avec Spring Boot.`

### 2. Salutation Structurée (JSON)

-   **URL** : `http://localhost:8080/greeting1`
-   **Méthode** : `GET`
-   **Paramètres** : `name` (optionnel, la valeur par défaut est "world").
-   **Exemple de requête** : `http://localhost:8080/greeting1?name=Sidonie`
-   **Exemple de réponse** :
    ```json
    {
      "id": 1,
      "content": "hello, Sidonie!"
    }
    ```