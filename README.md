# Spring Boot, My SQL, Swagger & Vault
This repository is meant to serve as an example of how to configure a Spring Boot app backed by a My SQL database (hosted on the cloud) and use Hashicorp Vault to manage the secrets involved in this connection. Finally configure swagger to automatically document the endpoints exposed.

## Purpose
In today's world of rapid application development, spring boot plays a central role by way of providing a Java framework that bootstraps much of the configuration necessary and makes it extremely simple to develop the omnipresent "Hello World!" as a REST endpoint in as few as a couple lines of code. There's also a ton of material in the form of [Getting Started](https://spring.io/guides) guides that helps you kickstart your spring boot project. This is one such attaempt of mine at creating my own version of a **Getting Started** guide. 

My approach is to create minimal functionality applications (like the fruit basket app here) that demonstrates how to configure a set of chosen framework/products (spring boot, My SQL, Swagger and Vault in this case) to work with each other to achieve certain capabilities.

In the world of RESTful API development, [swagger/OAS](https://swagger.io/specification/) is becoming the defacto standard for documenting your REST endpoints. Next, in my opinion, one of the first challenges faced by containerized applications - where all infrastructure is viewed as disposable resources - is secrets management. Hashicorp has a great open source product to solve this - [Vault](https://www.vaultproject.io/). 

So, to demonstrate secrets management, OAS documentation and connecting to a My SQL database for persistence, I created this __Fruit Basket__ app as an example. I hope to keep adding more such versions of "getting started" style apps that takes an opinionated view of products to use to achieve certain capabilities and how to configure them all up!    

## Repository structure and intro
Repository includes:
* A Spring Boot app which exposes following endpoints:
	* GET `/` - Exposes Swagger documentation for the Fruit Basket application.
	* GET `/fruit`
	* POST `/fruit/{name}`
	* DELETE `/fruit/{name}`
	* PUT `/fruit`
* Application Configuration that wires spring.datasource properties to specific secrets within Vault
## How to build and run?
1. Create a My SQL instance. I used GCP - [Instructions](https://cloud.google.com/sql/docs/mysql/create-instance). But there are no dependencies on which cloud platform you use, whether or not you use a managed service or even run locally.
2. The project repo includes a docker-compose file. If you have docker installed locally, you run this command to bring up all the services. The compose file and the scripts within the repo ensures that all dependent services are available before bringing up the app.
Substitute the values of the variables with your actual username, password and url in the below snippet. If you're running mysql locally, set the URL accordingly.

```bash
export $MYSQL_USERNAME=<mysql-username>
export $MYSQL_PASSWORD=<mysql-password>
export $MYSQL_URL=<mysql-url>
docker-compose up
```

If you wish to run the dependent services locally and run the app in an IDE, follow these steps.
1. Download and install vault locally. You can find instructions for that [here](https://www.vaultproject.io/docs/install/#precompiled-binaries)
2. You need to start vault locally and add the 3 pieces of configuration/secrets necessary for your spring boot app to connect to the My SQL instance. Run the following commands on a terminal. Be sure to replace `<username>`, `<password>`, and `<mysql-url/dbname>` with appropriate values.

 ```bash
vault server --dev --dev-root-token-id="0000"
export VAULT_TOKEN="0000"
export VAULT_ADDR="http://127.0.0.1:8200"
vault kv put secret/fruit-basket mysql.username=<username> mysql.password=<password> mysql.url=<mysql-url/dbname>
```

3. Run the spring boot app locally.

At this point, you should be able to use any REST client to access the endpoints noted above. 

## Kubernetes Clusters
If you would like to run the app on a kubernetes cluster, click [here](/kubernetes)

## How to contribute?
If you wish to contribute, please fork the repo and create a [pull request](https://help.github.com/en/articles/creating-a-pull-request-from-a-fork)
