import java.sql.*;

class Lab8_2 {
    public static void main(String args[]) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/javaLab", "root", "password");
            Statement stmt = con.createStatement();
            System.out.println(
                    "Display Name of all doctors  who are in MEDICINE having more than 10 years experience from the table DOCTOR”");
            ResultSet rs = stmt.executeQuery("SELECT name FROM doctor WHERE dept='MEDICINE' AND exp>10;");
            while (rs.next())
                System.out.println(rs.getString(1));
            System.out.println();
            System.out.println(
                    "Display the average salary of all doctors working in ENT using the table DOCTOR and SALARY.  Salary = Basic + Allowance");
            rs = stmt.executeQuery(
                    "SELECT AVG(basic+allowance) FROM doctor A, salary B WHERE dept='ENT' AND A.ID=B.ID;");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            System.out.println();
            System.out.println("Display the minimum allowance of Female doctor");
            rs = stmt.executeQuery("SELECT MIN(allowance) FROM doctor A, salary B WHERE sex='F' AND A.ID=B.ID;");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            System.out.println();
            System.out.println("Display the highest consultation fee among all male doctor");
            rs = stmt.executeQuery("SELECT MAX(consultation) FROM doctor A, salary B WHERE sex='M' AND A.ID=B.ID;");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            System.out.println();
            System.out.println("Display the count of female doctors");
            rs = stmt.executeQuery("SELECT count(*) from doctor where sex='F';");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            System.out.println();
            System.out.println("Display count of male doctors whose basic is less than Rs.4000");
            rs = stmt.executeQuery("SELECT count(*) from doctor , salary where sex='M' AND basic<4000;");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }

            System.out.println();
            System.out.println(
                    "Display Name,Depat,Basic from DOCTOR, SALARY where DEPT =”ENT” AND DOCTOR.ID = SALARY.ID");
            rs = stmt.executeQuery(
                    "SELECT name, dept, basic from doctor,salary WHERE dept='ENT' AND doctor.ID=salary.ID");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
