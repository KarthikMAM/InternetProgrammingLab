import java.sql.*;

public class Jdbc {
    public static void main(String[] args) throws Exception{
        String DRIVER = "com.mysql.jdbc.Driver";
        String URL = "jdbc:mysql://localhost/db";
        String USER = "root";
        String PASS = "2309";

        Class.forName(DRIVER);
        Connection con = DriverManager.getConnection(URL, USER, PASS);

        PreparedStatement stmt = con.prepareStatement("select * from student");
        ResultSet rs = stmt.executeQuery();

        while(rs.next()) {
            System.out.println(rs.getString(1));
        }
    }
}
