import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        PoodleDB poodleDB = null;
        try {
            String url = "jdbc:sqlite:/Users/martinemildaafunder/Desktop/SD/Portfolio3Database/Untitled";
            poodleDB = new PoodleDB();
            poodleDB.connect(url);

        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (poodleDB.conn != null)
            {
                try{
                    poodleDB.conn.close();
                }catch (SQLException d){
                    d.printStackTrace();
                }
            }
        }
    }
}
