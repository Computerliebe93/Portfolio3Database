import java.sql.*;

public class PoodleDB {
    Connection conn = null;

    public void connect(String url) throws SQLException {
        conn = DriverManager.getConnection(url);
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }

    public ResultSet sqlStatement(String sql) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if (rs == null)
            System.out.println();
        System.out.println("No record retrieved");
        while (rs != null & rs.next()) {
            String Name = rs.getString("City");
            System.out.println(Name);
        }
        return rs;
    }
    public ResultSet sqlPreparedStatement(String StudentName, String Course, int Grade) throws SQLException {
        String sql = " SELECT D1.StudentName as Student, D2.StudentName as exam, D2.Grade as Grade " +
        " FROM sdExam as D1 " +
        " JOIN sdExam as D2 " +
        " JOIN sdExam as D2 on D1.StudentName = D2.StudentName " +
       " WHERE D1.StudentName = ? and D2.sdExam = ? and D2.Grade = ?;";
        PreparedStatement pstmt = conn.prepareCall(sql);
        pstmt.setString(1, StudentName);
        pstmt.setString(2, Course);
        pstmt.setInt(3, Grade);
        ResultSet rs = pstmt.executeQuery();
        if (rs == null)
            System.out.println();
        System.out.println("No record retrieved");
        while (rs != null & rs.next()) {
            System.out.println(rs.getString(1 + " " + rs.getInt(2) + " " + rs.getString(3)));
        }
        return rs;
    }
}
