# ADRIA BANK — Plateforme bancaire basée sur une architecture microservices

**Projet :** Épreuve technique de sélection ADRIA BANK  
**Établissement :** ENSET  
**Filière :** SDIA2  
**Réalisé par :** TIMOURTI SANA

---

## 1. Présentation du projet

ADRIA BANK est une application bancaire développée selon une architecture microservices.

L'objectif est de permettre la gestion des comptes bancaires et des transactions, tout en assurant la communication entre les différents services.

Le projet intègre également une architecture distribuée, un système de découverte des services, une configuration centralisée, une communication événementielle avec Kafka et un assistant intelligent.

## 2. Architecture du projet

Le projet est organisé autour des composants suivants :

| Composant | Description |
|---|---|
| account-service | Gestion des comptes bancaires |
| transaction-service | Gestion et validation des transactions |
| discovery-server | Découverte des microservices avec Eureka |
| config-server | Centralisation de la configuration |
| api-gateway | Point d'entrée des requêtes |
| ai-agent | Assistant intelligent utilisant les outils MCP |
| frontend | Interface utilisateur |

## 3. Technologies utilisées

- Java 17
- Spring Boot
- Spring Cloud
- Spring Data JPA
- Spring Web
- Spring GraphQL
- OpenFeign
- Resilience4J
- Eureka Discovery
- Spring Cloud Config
- Apache Kafka
- Spring AI et MCP
- Maven
- Angular / React / Flutter selon l'implémentation retenue

## 4. Structure du projet

```text
adria-bank/
│
├── account-service/
│
├── transaction-service/
│
├── discovery-server/
│
├── config-server/
│
├── api-gateway/
│
├── ai-agent/
│
├── config-repo/
│
├── frontend/
│
├── docker-compose.yml
│
├── pom.xml
│
└── README.md
```

## 5. Règles métier

Le système doit respecter les règles suivantes :

- Le montant d'une transaction doit être strictement positif.
- Le montant ne doit pas dépasser le plafond configuré.
- Le compte bancaire doit exister et être actif.
- La devise de la transaction doit correspondre à celle du compte.
- Le solde doit être suffisant.
- Après l'enregistrement de la transaction, le solde du compte doit être mis à jour.
- Le système doit prendre en charge les transferts entre comptes.

## 6. Installation et configuration

### Prérequis

- Java 17
- Apache Maven
- IntelliJ IDEA
- Git
- Docker (pour les composants exécutés avec Docker)

### Vérifier Java

```bash
java -version
```

### Vérifier Maven

```bash
mvn -version
```

### Compiler le projet

Depuis le dossier racine `adria-bank` :

```bash
mvn clean install
```

Cette commande permet de nettoyer, compiler et installer les modules Maven du projet.

## 7. Démarrage des microservices

Les services doivent être démarrés dans un ordre adapté à leurs dépendances :

1. Discovery Server
2. Config Server
3. Account Service
4. Transaction Service
5. API Gateway
6. AI Agent

Chaque microservice peut être démarré depuis IntelliJ IDEA en exécutant sa classe principale Spring Boot.

Les ports et les configurations sont définis dans les fichiers `application.properties` ou `application.yml` de chaque module.

## 8. Tests et validation

Les tests à réaliser comprennent :

- Compilation Maven.
- Consultation des comptes bancaires via REST.
- Création et validation des transactions.
- Vérification des règles métier.
- Tests des interfaces GraphQL.
- Tests des outils MCP.
- Communication interservices avec OpenFeign.
- Tolérance aux pannes avec Resilience4J.
- Enregistrement des services dans Eureka.
- Routage des requêtes via API Gateway.
- Récupération de la configuration centralisée.
- Publication et consommation des événements Kafka.
- Vérification des fonctionnalités du frontend et du chatbot.

Les résultats des tests doivent être documentés avec des captures d'écran dans le rapport final.

## 9. Événements Kafka

Après l'enregistrement réussi d'une transaction, le système publie un événement dans le topic :

```text
bank.transactions.created
```

La clé du message est `accountId`.

Le consommateur reçoit l'événement et l'affiche dans les logs sans modifier les données bancaires.

## 10. Configuration du plafond

Le plafond maximal des transactions est centralisé dans Config Server :

```properties
bank.transaction.max-amount=1000
```

Cette valeur est utilisée par Transaction Service pour contrôler les montants autorisés.

## 11. Auteur

**TIMOURTI SANA**  
**Filière : SDIA2 — ENSET**

Projet réalisé dans le cadre de l'épreuve technique de sélection ADRIA BANK.
