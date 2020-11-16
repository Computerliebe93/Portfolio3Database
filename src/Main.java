import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

public class Main {

    public static void main(String[] args) {
        PoodleDB poodleDB = null;
        try {
            String url = "jdbc:sqlite:/Users/martinemildaafunder/Desktop/SD/Portfolio3Database/Untitled";
            poodleDB = new PoodleDB();
            poodleDB.connect(url);
            // Statement
            String sql;
            sql = "SELECT * FROM students";
            ResultSet rs = poodleDB.sqlStatement(sql);
            rs = poodleDB.sqlPreparedStatement("Theis Thomasen", "SD", 10);

        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if ( poodleDB.conn != null)
            {
                try {
                    poodleDB.conn.close();
                }catch (SQLException d){
                    d.printStackTrace();
                }
            }
        }

    }
}
