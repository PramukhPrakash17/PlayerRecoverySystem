Overview

The Player Recovery System is a backend system built with Spring Boot to manage football players, injuries, recovery plans, and teams. The application uses JWT-based authentication and role-based access control to provide secure and restricted access to features. The system is designed to be modular, scalable, and secure.

Features

Team Management:

Add, view, update, and delete teams.

Player Management:

Add, view, update, and delete players.

Link players to specific teams.

Injury Management:

Add, view, update, and delete injuries.

Link injuries to players.

Recovery Plan Management:

Add, view, update, and delete recovery plans.

Link recovery plans to injuries.

Authentication and Authorization:

Secure endpoints with JWT tokens.

Role-based access control for ADMIN and USER roles.

Technologies Used

Spring Boot

Spring Security (JWT-based Authentication and RBAC)

Spring Data JPA

H2 Database (for development/testing)

MySQL (for production)

Lombok

Maven
