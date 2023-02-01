# Keycloak

Toute les requêtes suivantes nécessite la récupération du token via keycloak déployé sur AWS.
Il faut lancer la requête :
```
curl -X POST "http://keycloak-lb-1597787774.eu-west-3.elb.amazonaws.com/auth/realms/SpringBootKeycloak/protocol/openid-connect/token" -H "Content-Type: application/x-www-form-urlencoded" -d "username=user1" -d "password=password" -d "grant_type=password" -d "client_id=focal-api"
```
Cela permet de récupérer le token qu'il faudrat ajouter à chaque requête

# Scénario n°1 le Multi-région
L'application est déployé sur deux région, us-west-1 et eu-west-3. Il y a un base de donnée sur RDS dans la région eu-west-3 et un read réplica dans la région us-west-1.
## Protocol de test :
* Pour tester les temps de réponse depuis Paris, on lance la requête suivante depuis un pc localisé en europe:
  ```  
  curl -w "time_total: %{time_total}s\n" -o /dev/null -s --request POST --url http://geoloc.verventaudio-poc.com:8080/playlist --header 'authorization: Bearer <KEYCLOAK_TOKEN>' --header 'cache-control: no-cache' --header 'content-type: application/json'  --data '{"id": 157}' && curl -w "time_total: %{time_total}s\n" -o /dev/null -s --request GET --header 'authorization: Bearer <KEYCLOAK_TOKEN>' --url http://geoloc.verventaudio-poc.com:8080/playlist
  ```

* Pour tester les temps de réponse depuis les USA, on lance la requête suivante depuis une VM GCP localisé aux USA:
  ```  
  curl -w "time_total: %{time_total}s\n" -o /dev/null -s --request POST --url http://geoloc.verventaudio-poc.com:8080/playlist --header 'authorization: Bearer <KEYCLOAK_TOKEN>' --header 'cache-control: no-cache' --header 'content-type: application/json'  --data '{"id": 157}' && curl -w "time_total: %{time_total}s\n" -o /dev/null -s --request GET --header 'authorization: Bearer <KEYCLOAK_TOKEN>' --url http://geoloc.verventaudio-poc.com:8080/playlist
  ```

# Scénario n°2 avec l'accelerator

Avec l'accelerator seul une région est déployé à Paris, et tous les appels sont dirigés vers Paris.

Pour tester le temps de réponse selon la région, il faut appeller le 