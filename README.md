**1 Overview**
 This project consists of a Java Spring Boot backend providing REST APIs for managing Pay
ments, Accounts, Deposits, and Customers, backed by MongoDB Atlas. It also includes
 a React Native frontend UI to interact with these services. The backend is containerized with
 Docker and deployed on AWS ECS Fargate and S3, with infrastructure provisioned using Ter
raform.
**1.1 Tech Stack**
           • Backend: Java Spring Boot (hosted on AWS ECS)
           • Database: MongoDB Atlas (hosted on AWS)
           • Frontend: React Native (hosted on AWS S3-static pages)
           • Containerization: Docker
           • Infrastructure: AWS ECS (Fargate), Terraform
           • Deployment: Docker Hub + Terraform automation
           • Testing: JUnit 5 , Mockito
           • Version Control: GIT, GITHUB
 **1.2 Git Repositories**
 • React Frontend Repository:
 https://github.com/khurramirshad/React-Frontend
 • Spring Boot Endpoints Repository:
 https://github.com/khurramirshad/spring-boot-endpoints
 1.3 React UI link
 The front end application can also be accessed online here:
 http://solanceapp.s3-website-us-east-1.amazonaws.com/customers
 1.4 API Endpoints
 The following REST API endpoints are exposed and secured with Spring Security role-based
 authentication and authorization:
 • http://34.224.32.22:80/payment
 • http://34.224.32.22:80/account
 • http://34.224.32.22:80/deposit
 • http://34.224.32.22:80/customer
 2
1.5 Security
 The API endpoints are secured using Spring Security with role-based authentication and autho
rization.
 • Users are authenticated before accessing the endpoint, and access control is enforced
 based on assigned roles to ensure proper authorization.
 • This setup protects the REST APIs endpoints, restricting access according to user roles.
 • Authentication and authorization logic is implemented within the Spring Boot application to
 safeguard sensitive operations.
 1.6 Users to test
 • username= bob, password=bob
 • username= john, password=john (ADMIN)
 1.7 Tests
 • Implemented unit and integration tests using JUnit 5 with Spring Boot Test.
 • Verified CRUD operations in PaymentService including save, get, update, and delete.
 • Used ObjectMapper for JSON to entity conversion and Parameterized Tests for multiple
 inputs.
 • Ensured test isolation with @AfterEach cleanup after execution.
 1.8 Infrastructure as Code (IaC)
 Terraform ECS.tf file is committed into Java Git repository.
 1.9 Extensibility & Next Steps
 • Implement SSL certificates to secure API communications.
 • Implement Kafka for event streaming (future-proof beyond 100 TPS).
 • Implement CI/CD pipeline for automated testing, building, and deployment for twice a week
 releases
