import java.sql.*;

public class MSS_JDBC {
    static final String URI = "jdbc:sqlserver://localhost;IntegratedSecurity=True;TrustServerCertificate=True";

    public static void showAll(Statement st) throws SQLException {
        ResultSet rs = st.executeQuery(
                "SELECT * FROM Messages, Users "
                        + "WHERE Messages.UserID = Users.UserID");
        while (rs.next()) {
            int messageID = rs.getInt("MessageID");
            String content = rs.getString("Content");
            String firstName = rs.getString("FirstName");
            String lastName = rs.getString("LastName");

            System.out.println("Message " + messageID
                    + " from " + firstName + " " + lastName + ": "
                    + content);
        }
        System.out.println("     --------------------------     ");
        rs.close();
    }

    public static void main(String[] args) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            java.util.Properties prop = new java.util.Properties();
            prop.setProperty("database", "ForumDB");
            System.out.println("Connecting to database ForumDB...");
            Connection conn = DriverManager.getConnection(URI, prop);

            System.out.println("Creating statement...");
            Statement st = conn.createStatement();
            System.out.println("Retrieving data...\n");

            showAll(st);

            System.out.println("Making changes to the last row...");
            System.out.println("     --------------------------     ");
            st.executeUpdate(
                    "UPDATE MESSAGES SET Content = 'Content Changed!' "
                      + "WHERE UserID = 4 AND MessageID = 1");

            showAll(st);

            st.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

