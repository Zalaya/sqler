# SQLer

SQLer is a tool designed to transform static data structures that are not easily queryable into SQL-queryable databases.

## Process

1. The user uploads a data file to the SQLer REST API.
2. SQLer identifies the file type and determines the appropriate parser to use.
3. SQLer parses the data file and generates a SQL database.
4. The user gets as response a Docker image with the database inside it.

## Modules

- SQLer REST API: REST API that receives the data file and returns the database SQL queries and Docker image.
- SQLer Parser: Module that parses the data file and generates the SQL database.
  - SQLer CSV Parser: Module that parses CSV files.
  - SQLer JSON Parser: Module that parses JSON files.
  - SQLer XML Parser: Module that parses XML files.
  - SQLer YAML Parser: Module that parses YAML files.
- SQLer Generator: Module that generates the SQL database.
  - SQLer Docker Image Generator: Module that generates the Docker image with the database.
  - SQLer SQL File Generator: Module that generates the SQL file with the database.
