# ADRIA Bank — socle des parties A à G

Projet pédagogique multi-modules Maven : Account-Service, Transaction-Service, Eureka, Config Server, Gateway, AI Agent MCP, Kafka et frontend Angular à initialiser.

## Prérequis
- JDK 21
- Maven 3.9+
- Docker Desktop avec Docker Compose
- Node.js LTS et Angular CLI pour le frontend

## Démarrage local (services Java)
Dans un terminal à la racine : `mvn clean package -DskipTests`.
Lancer ensuite, dans des terminaux séparés et dans cet ordre :
1. `cd discovery-server && mvn spring-boot:run` (8761)
2. `cd config-server && mvn spring-boot:run` (8888)
3. `cd account-service && mvn spring-boot:run` (8081)
4. `docker compose up -d` (Kafka 9092)
5. `cd transaction-service && mvn spring-boot:run` (8082)
6. `cd api-gateway && mvn spring-boot:run` (8080)
7. Configurer `OPENAI_API_KEY`, puis `cd ai-agent && mvn spring-boot:run` (8085)

Lancer chaque commande depuis un terminal distinct. Config Server utilise le dossier `../config-repo` relativement à son répertoire de lancement.

## Tests rapides
- Eureka : http://localhost:8761
- Créer un compte : `POST http://localhost:8081/api/accounts` avec JSON `{ "customerReference":"CLIENT001", "status":"ACTIVE", "currency":"EUR", "balance":5000 }`
- Lister les comptes via Gateway : `GET http://localhost:8080/api/accounts`
- GraphQL Account : `POST http://localhost:8081/graphql`
- GraphQL Transaction : `POST http://localhost:8082/graphql`
- Chat : `POST http://localhost:8085/api/chat` avec `{ "message":"Liste les comptes" }`

## Important — limites du socle
Ce dépôt est une base pédagogique de développement, pas un système bancaire prêt pour la production. Les appels entre deux bases H2 indépendantes ne forment pas une transaction distribuée atomique : la méthode de virement doit être renforcée par une Saga/compensation ou un orchestrateur. Pour garantir la livraison des événements, ajouter un Transactional Outbox. Ajouter aussi authentification/autorisation Keycloak, validation DTO, gestion globale des erreurs, tests automatisés, CORS et idempotence avant toute démonstration sérieuse.

Les versions de Spring Boot, Spring Cloud et Spring AI doivent rester alignées. Si un artefact Spring AI MCP ou une propriété de transport change selon la version résolue, consulter la documentation de cette version et adapter les imports/propriétés avant compilation.

## Frontend
Le dossier `frontend/` contient le guide de création Angular. Générer l'application avec `ng new frontend --routing --style css`, puis intégrer les composants/services décrits dans `frontend/README.md`.
