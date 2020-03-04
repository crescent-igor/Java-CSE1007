import java.sql.*;

class test {
    public static void main(String args[]) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/javaLab", "root", "password");
            Statement stmt = con.createStatement();
            System.out.println("Display all record whose designation is “Professor Grade1”");
            ResultSet rs = stmt.executeQuery("select * from doctor;");
            while (rs.next())
                System.out.println(
                        rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
