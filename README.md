🍔 ProjectKitchenBackend

📋 Description

ProjectKitchenBackend is a back-end simulator for a food order management and delivery system. The project implements an efficient solution for storing, organizing, and retrieving orders on intelligent shelves based on temperature requirements, ensuring food quality and freshness during the delivery process.

🎯 Basic Idea

The system simulates a kitchen/distribution center where:

Orders arrive with temperature information (hot/cold) and freshness levels
Orders are automatically stored in appropriate shelves:
Cooler - For food that needs to be kept cold
Heater - For food that needs to be kept hot
Shelf - For food at room temperature
The system controls order pickup while maintaining action logs and quality monitoring

🛠️ Technologies Used

Technology	Version	Purpose
Java 17:	Main programming language
Maven 3.x+:	Dependency management and build tool
JUnit 5	Unit: testing framework
Mockito	5.11.0:	Mock objects for testing

🚀 Prerequisites
Java 17+
Maven 3.6+
Compile the Project

✅ Testing

The project includes comprehensive unit tests using:

JUnit 5 for testing framework
Mockito for dependency mocking
Test coverage across layers: Controller, Service, and Model

📝 Main Features

✅ Order receiving and processing
✅ Intelligent temperature-based storage
✅ Order retrieval by ID
✅ Detailed action logging system
✅ Food freshness control
✅ Comprehensive unit testing

📚 Design Patterns

MVC - Separation between Controller, Model, and View
Service Layer - Centralized business logic
Dependency Injection - Dependency injection in controllers
Repository Pattern - Storage interface for data abstraction