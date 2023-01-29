import java.sql.*;

public class MongoAtlas_JDBC {
    static final String URI = "jdbc:mongodb://federateddatabaseinstance-a0tla"
                            + ".a.query.mongodb.net/?ssl=true&authSource=admin";

    public static void main(String[] args) {
        try {
            Class.forName("com.mongodb.jdbc.MongoDriver");
            java.util.Properties prop = new java.util.Properties();
            prop.setProperty("user", "FifoUser");
            prop.setProperty("password", "FifoPassword");
            prop.setProperty("database", "MyDB");
            System.out.println("Connecting to database MyDB with FifoUser...");
            Connection conn = DriverManager.getConnection(URI, prop);

            System.out.println("Creating statement...");
            Statement st = conn.createStatement();
            System.out.println("Retrieving data...\n");
            ResultSet rs = st.executeQuery( "SELECT * FROM MyCollection" );
            while (rs.next()) {
                System.out.println("Row: " + rs.getRow());
                String id = rs.getString("_id");
                String name = rs.getString("name");
                System.out.println("ID: " + id.substring(10, id.length() - 2));
                System.out.println("Name: " + name);
                System.out.println("      ---------------------------------     ");
            }

            rs.close();
            st.close();
            conn.close();
        } catch ( ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
