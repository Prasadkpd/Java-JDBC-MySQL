import java.sql.*;

public class ResultInterface {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java-jdbc", "root", "");

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from emp");
        resultSet.absolute(1);
        System.out.println(resultSet.getInt(1)+" "+ resultSet.getString(2));
        resultSet.next();
        System.out.println(resultSet.getInt(1)+" "+ resultSet.getString(2));
        resultSet.previous();
        System.out.println(resultSet.getInt(1)+" "+ resultSet.getString(2));
        resultSet.first();
        System.out.println(resultSet.getInt(1)+" "+ resultSet.getString(2));
        resultSet.last();
        System.out.println(resultSet.getInt(1)+" "+ resultSet.getString(2));
        resultSet.relative(-1);
        System.out.println(resultSet.getInt(1)+" "+ resultSet.getString(2));
    }
}
