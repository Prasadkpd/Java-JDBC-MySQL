import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class PreparedStatementInterface {

    public static void insertStatement() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java-jdbc", "root", "");

            PreparedStatement statement = connection.prepareStatement("insert into emp values(?,?,?)");

            statement.setInt(1, 10);
            statement.setString(2, "Prasad");
            statement.setInt(3, 23);

            int i = statement.executeUpdate();
            System.out.println(i + " records inserted");
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void updateStatement() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java-jdbc", "root", "");

            PreparedStatement statement = connection.prepareStatement("update emp set name=? where id=?");

            statement.setString(1, "Lakshan");
            statement.setInt(2, 10);

            int i = statement.executeUpdate();
            System.out.println(i + " records inserted");
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void deleteStatement() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java-jdbc", "root", "");

            PreparedStatement statement = connection.prepareStatement("delete from emp where id=?");

            statement.setInt(1, 10);

            int i = statement.executeUpdate();
            System.out.println(i + " records inserted");
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void readStatement() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java-jdbc", "root", "");

            PreparedStatement statement = connection.prepareStatement("select * from emp");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void repeatInsertStatement() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java-jdbc", "root", "");

            PreparedStatement statement = connection.prepareStatement("insert into emp values (?,?,?)");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            do {
                System.out.println("Enter id:");
                int id = Integer.parseInt(bufferedReader.readLine());
                System.out.println("enter name:");
                String name = bufferedReader.readLine();

                statement.setInt(1, id);
                statement.setString(2, name);
                statement.setInt(3, 23);
                int i = statement.executeUpdate();
                System.out.println(i + "records affected");

                System.out.println("Do you want to continue: y/n");
                String s = bufferedReader.readLine();
                if (s.startsWith("n")) {
                    break;
                }

            } while (true);

            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        insertStatement();
//        updateStatement();
//        deleteStatement();
//        readStatement();
        repeatInsertStatement();
    }
}
