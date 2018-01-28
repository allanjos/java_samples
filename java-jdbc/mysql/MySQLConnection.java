import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public static String status = "";

    public MySQLConnection() {
    }

    public static java.sql.Connection getConnection() {
        Connection connection = null;

        try {
            String driverName = "com.mysql.jdbc.Driver";

            Class.forName(driverName);

            String serverName = "localhost";
            String databaseName = "commerce";
            String url = "jdbc:mysql://" + serverName + "/" + databaseName + "?verifyServerCertificate=false&useSSL=true";
            String userName = "root";
            String password = "mysql";

            connection = DriverManager.getConnection(url, userName, password);

            if (connection != null) {
                status = "OK";

                System.out.println("Connection OK");
            }
            else {
                status = "ERROR";

                System.out.println("Connection Error");
            }

            return connection;

        }
        catch (ClassNotFoundException e) {
            System.out.println("O driver expecificado nao foi encontrado.");

            return null;
        }
        catch (SQLException e) {
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");

            return null;
        }
    }

    public static String statusConection() {
        return status;
    }

    public static boolean closeConnection() {
        try {
            MySQLConnection.getConnection().close();

            return true;
        }
        catch (SQLException e) {
            return false;
        }
    }

    public static java.sql.Connection restartConnection() {
        closeConnection();

        return MySQLConnection.getConnection();
    }

    public static void listRoutes(Connection con) throws SQLException {
        Statement stmt = null;
        String query = "SELECT * FROM product";

        try {
            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");

                System.out.println("product id: " + id + ", name: " + name);
            }
        }
        catch (SQLException e ) {
            System.err.println("Error on database query.");
        }
        finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public static void main(String args[]) {
        Connection connection = getConnection();

        try {
            listRoutes(connection);
        }
        catch (SQLException e) {
            System.err.println("Error on listing routes.");
        }

        closeConnection();
    }
}
