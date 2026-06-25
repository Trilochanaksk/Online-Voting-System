# 🗳️ Online Voting System

A robust, lightweight **Spring Boot** web application designed to facilitate secure and seamless digital voting. This application manages citizen authentication, voting status tracking, and real-time candidate poll tallies using Spring Data JPA.

---

## 🚀 Features

* **Citizen Authentication:** Verifies registered voters via a centralized repository before allowing access to the ballot[cite: 2, 6].
* **Double-Voting Prevention:** Tracks state constraints (`hasVoted`) to ensure eligible citizens can only cast a single ballot[cite: 2, 4].
* **Dynamic Candidate Rosters:** Automatically logs and exposes current candidates to the presentation layer during an active session[cite: 2].
* **Real-time Results:** Persists and updates election tallies securely inside a relational database structure[cite: 2, 3, 5].

---

## 🎨 System Flow Preview

```
  [ Voter Login ] ──► [ Check: Has Voted? ] ──► (Yes) ──► [ Already Voted View ]
                             │
                             └───► (No) ───────► [ Cast Vote ] ──► [ See Results ]

```

---

## 🛠️ Tech Stack

* **Framework:** Spring Boot (v3.x)[cite: 1]
* **Data Access:** Spring Data JPA / Hibernate[cite: 1, 5, 6]
* **Language:** Java 17+[cite: 1]
* **Template Engine Support:** Spring MVC (UI views: `main`, `performVoted`, `result`, `error`)[cite: 2]

---

## 📂 Project Architecture

The architecture adheres to clean Spring MVC patterns, dividing responsibilities dynamically[cite: 2]:

```text
com.fswt.onlinevotingsystem
 ├── OnlinevotingsystemApplication.java  # Application Entry Point
 ├── controller
 │    └── VotingController.java         # Routing & Request Orchestration
 ├── entity
 │    ├── Candidate.java                 # Candidates Data Model
 │    └── Citizen.java                   # Citizens Data Model
 └── repositories
      ├── CandidateRepo.java             # Candidate Database Interactor
      └── CitizenRepo.java               # Citizen Database Interactor

```

### Key Component Overview

* **`OnlinevotingsystemApplication.java`**: Configures and bootstraps the Spring Boot application environment[cite: 1].
* **`VotingController.java`**: Manages web requests, interacts with repositories, and maps endpoints to logical views[cite: 2].
* **`Candidate.java` & `Citizen.java**`: Define the database schemas using Jakarta Persistence mappings[cite: 3, 4].
* **`CandidateRepo.java` & `CitizenRepo.java**`: Abstract underlying SQL processes into simple repository interface layers[cite: 5, 6].

---

## 🔌 API & Endpoint Routing

| Endpoint | HTTP Method | Function | Target View |
| --- | --- | --- | --- |
| `/` | `GET` | Serves the central portal dashboard[cite: 2]. | `main`[cite: 2] |
| `/doLogin` | `POST` | Processes voter verification via name constraints[cite: 2]. | `performVoted` / `alreadyVoted` / `error`[cite: 2] |
| `/voteFor` | `POST` | Increments votes for a specific candidate ID[cite: 2]. | `result`[cite: 2] |
| `/result` | `GET` | Displays ongoing election candidate tallies[cite: 2]. | `result`[cite: 2] |

---

## ⚙️ Setup and Installation

### Prerequisites

* Java Development Kit (JDK 17 or higher)
* Maven 3.6+
* Your preferred relational database (e.g., MySQL, H2, PostgreSQL)

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/online-voting-system.git
cd online-voting-system

```

### 2. Configure Database Connections

Update your `src/main/resources/application.properties` (or `.yml`) file with your datasource configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/voting_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

```

### 3. Build and Launch

Run the application using Maven:

```bash
mvn clean install
mvn spring-boot:run

```

The server will default to initialization on `http://localhost:8080`.

---

## 📝 Database Schema Insights

The persistence layer interacts with two primary tables mapped through Jakarta Persistence specifications[cite: 3, 4]:

### **`citizens`**[cite: 4]

* `id` (Long, PK) — Unique structural identifier[cite: 4].
* `citizen_name` (String) — Checked during the verification phase[cite: 2, 4].
* `hasvoted` (Boolean) — Status flag preventing multiple vote submittals[cite: 2, 4].

### **`candidates`**[cite: 3]

* `id` (Long, PK) — Unique structural identifier[cite: 3].
* `candidate_name` (String) — Display label for ballots[cite: 2, 3].
* `numberOfVotes` (Integer) — Running tally incremented on `/voteFor`[cite: 2, 3].
