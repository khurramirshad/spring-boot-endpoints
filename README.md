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
 
 
 **React Frontend Repository:**
 https://github.com/khurramirshad/React-Frontend
 
 **Spring Boot Endpoints Repository:** 
 https://github.com/khurramirshad/spring-boot-endpoints

 
 **React UI link**
 The front end application can also be accessed online here:
 http://solanceapp.s3-website-us-east-1.amazonaws.com/customers

 
 **API Endpoints**
 
 The following REST API endpoints are exposed and secured with Spring Security role-based
 authentication and authorization:
 
 • http://34.224.32.22:80/payment
 • http://34.224.32.22:80/account
 • http://34.224.32.22:80/deposit
 • http://34.224.32.22:80/customer
 
**Security**
 The API endpoints are secured using Spring Security with role-based authentication and autho
rization.

 • Users are authenticated before accessing the endpoint, and access control is enforced
 based on assigned roles to ensure proper authorization.
 
 • This setup protects the REST APIs endpoints, restricting access according to user roles.
 
 • Authentication and authorization logic is implemented within the Spring Boot application to
 safeguard sensitive operations.

 **Users to test**
 
 • username= bob, password=bob
 
 • username= john, password=john (ADMIN)
 


