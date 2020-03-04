import java.sql.*;

class Lab7_1 {
    public static void main(String args[]) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/javaLab", "root", "password");
            Statement stmt = con.createStatement();
            System.out.println("Display all record whose designation is “Professor Grade1”");
            ResultSet rs = stmt.executeQuery("select * from emp where (designation='Professor Grade 1');");
            while (rs.next())
                System.out.println(
                        rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4));
            System.out.println();
            System.out.println("Display all record whose designation is “Professor Grade 1” from SELECT");
            rs = stmt.executeQuery("select * from emp where (designation='Professor Grade 1' and school='SELECT');");
            while (rs.next())
                System.out.println(
                        rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4));
            System.out.println();
            System.out.println("Display all record whose designation is Assosicate professor senior from SCSE school");
            rs = stmt.executeQuery(
                    "select * from emp where (designation='Assistant Professor (Senior)' and school='SCSE');");
            while (rs.next())
                System.out.println(
                        rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4));
            System.out.println();
            System.out.println("Display all record whose name starts with A");
            rs = stmt.executeQuery("select * from emp where (name like 'A%');");
            while (rs.next())
                System.out.println(
                        rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4));

            System.out.println();
            System.out.println(
                    "Display all record whose name starts with A and designation Professor Grade1 where school equals SCSE");
            rs = stmt.executeQuery(
                    " select * from emp where (name like 'A%' and designation='Professor Grade 1' and school='SCSE');");
            while (rs.next())
                System.out.println(
                        rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4));

            System.out.println();
            System.out.println(
                    "Display all record whose name ends with N or M and designation Associate Professor where school equals SCSE");
            rs = stmt.executeQuery(
                    " select * from emp where ((name like '%M' or name like '%N' or name like '%m'or name like '%n' ) and designation like '%Associate Professor%' and school='SCSE');");
            while (rs.next())
                System.out.println(
                        rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4));

            System.out.println();
            System.out.println(
                    "Display all record whose name ends with N or M and designation Associate Professor where school equals SENSE");
            rs = stmt.executeQuery(
                    " select * from emp where ((name like '%M' or name like '%N' or name like '%m'or name like '%n' ) and designation like '%Associate Professor%' and school='SENSE');");
            while (rs.next())
                System.out.println(
                        rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4));

            System.out.println();
            System.out.println("Display all record whose emp ID >52000");
            rs = stmt.executeQuery(" select * from emp where (ID>'52000');");
            while (rs.next())
                System.out.println(
                        rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4));

            System.out.println();
            System.out.println("Display all record whose emp ID >52000 and school SENSE");
            rs = stmt.executeQuery(" select * from emp where (ID>'52000' and school='SENSE');");
            while (rs.next())
                System.out.println(
                        rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4));

            System.out.println();
            System.out
                    .println("Display all record whose emp ID >52000 and school SENSE designation Associate Professor");
            rs = stmt.executeQuery(
                    " select * from emp where (ID>'52000' and school='SENSE' and designation like '%Associate Professor%');");
            while (rs.next())
                System.out.println(
                        rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4));

            System.out.println();
            System.out.println(
                    "Update all the record whose employee id ending with divisor of 5 to 00000 and store it in the table.");
            stmt.executeUpdate("update emp set ID=CASE when ID like '%5' then ((ID-5)*10000) else ID end;");
            rs = stmt.executeQuery("select * from emp where ID like '%00000'");
            while (rs.next())
                System.out.println(
                        rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4));

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
