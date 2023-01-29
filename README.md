# Connecting a Java Project to a DB using JDBC
_This project has been made using Maven_.

### Connecting to Microsoft SQL Server
_Make sure to enable TCP/IP connection._
Using Microsoft SQL Server (MSQL Management Studio 18) - server: localhost, port: 1433 (default) - and using a certificate to connect securely (creating a self-designed one makes it up, make sure to add the JDBC authentication .dll file to your project path), install the MSS JDBC Driver (version [11.2.3](https://learn.microsoft.com/en-us/sql/connect/jdbc/release-notes-for-the-jdbc-driver?view=sql-server-ver16)) and add the JDK 17 compatible jar file to the project dependencies.

```java
static final String URI = "jdbc:sqlserver://localhost;IntegratedSecurity=True;TrustServerCertificate=True";
```
The connection string includes IntegratedSecurity for a connection to the server through the host (no SQL user authentication) and TrustServerCertificate for an acknowledgement of the certifcate created.

Import the [SQLServerDriver](https://learn.microsoft.com/en-us/sql/connect/jdbc/reference/sqlserverdriver-class?view=sql-server-ver16) class.
For more clarity, the tables used and screenshots of the queries results can be found as PNG images in the resources folder.

### Connecting to MongoDB Atlas
Connecting to MongoDB Atlas requires data to access in a Federated Database Instance to be able to query the data with SQL. Thus, a MongoDB user profile is needed. In our java file, the database name corresponds to the database instance name and the table name to the instance collection name.

Install the MongoDB JDBC Driver (version [2.0.1](https://search.maven.org/artifact/org.mongodb/mongodb-jdbc/2.0.1/jar)) and add the all.jar file to the project dependencies.
Import the [MongoDriver](https://github.com/mongodb/mongo-jdbc-driver/blob/master/src/main/java/com/mongodb/jdbc/MongoDriver.java) class and follow the [connection URI format](https://www.mongodb.com/docs/drivers/java/sync/current/fundamentals/connection/connect/#connection-uri) for a MongoDB deployment as for the connection string.
For more clarity, the collection used and screenshots of the query's results can be found as PNG images in the resources folder.

## Softwares and dependencies
##### Microsoft SQL Server
- Microsoft SQL Server Management Studio 18
- Microsoft SQL Server JDBC Driver (11.2.3.jre17 + mssql-jdbc_auth-11.2.3)

##### MongoDB Atlas
- MongoDB Atlas User Profile + Federated Database Instance data
- MongoDB Driver (2.0.1 all.jar)