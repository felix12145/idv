# Setup
1. Download MongoDB Community Server: https://www.mongodb.com/try/download/community
2. Install help:
    - Windows:
        - https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-windows/#run-mongodb-community-edition-from-the-command-interpreter
        - https://stackoverflow.com/questions/20796714/how-do-i-start-mongo-db-from-windows
    - Linux:
        - https://www.tutorialspoint.com/mongodb/mongodb_environment.htm
        - https://www.mongodb.com/docs/manual/administration/install-on-linux/
    - Mac:
        - https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-os-x/
 
3. Install MongoDB-Shell: https://www.mongodb.com/try/download/shell
4. Start the MongoDB Server
6. Insert the TestData by starting the AirportManagementApplication
5. Start the MongoDB-Shell with connection-string: mongodb://localhost:27017
# Warm Up:
## 1. See if the database airport-management exists
    show dbs;
## 2. Switch to the airport-management database
    use airport-management
## 3. Take a look at the collections
    show collections;
# Basic Queries with Mongo Query Language
### To Retrief the data from a collection (in SQL: table) using the Mongo Shell the following Syntax can be used

    db.COLLECTION_NAME.find()

## Syntax Reference Page:
- https://www.mongodb.com/docs/manual/reference/method/db.collection.find/
## Query-Selectors:
- https://www.mongodb.com/docs/manual/reference/operator/query/#std-label-query-selectors

## Take a look at the given collections using the above command 
## 1. Which aircraft can be used for 190 passengers and more?
## 2. Which aircraft starts with 'A7' and can be used for less than 180 passengers?
## 3. How many airports are in Paris and what's their name?
## 4. Which airport in Germany is closed?
## 5. Find all Airports that are either in 'Germany', 'United States' or 'Spain' and are not closed. The airports of interest have more than 155 or 50 or fewer flights per day. The result has to be sorted by county in ascending order and by flights per day in descending order. We are only interested to see the fields name, county and flightsPerDay. For how many airports are we looking and what's their names?


