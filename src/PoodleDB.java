import java.sql.*;

public class PoodleDB {
    Connection conn = null;

    public void connect(String url) throws SQLException {
        conn = DriverManager.getConnection(url);
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }
}
