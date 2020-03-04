
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

class Lab7_2 {

    public static void main(String[] args) {

        String csvFile = "/home/amrit/VIT/win2019-2020/JavaLab/Lab7.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                String[] country = line.split(cvsSplitBy);
                try {
                    Class.forName("org.mariadb.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/javaLab", "root",
                            "password");
                    Statement stmt = con.createStatement();
                    stmt.executeUpdate("insert into emp values(" + "'" + country[0].toString() + "'" + "," + "'"
                            + country[1].toString() + "'" + "," + "'" + country[2].toString() + "'" + "," + "'"
                            + country[3].toString() + "'" + ")");
                    con.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
                System.out.println(country[0]);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}