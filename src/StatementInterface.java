import java.sql.*;

public class StatementInterface {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java-jdbc", "root", "");

        Statement statement = connection.createStatement();

//        Insert Query
//        statement.executeUpdate("insert into emp value (5,'Sunil',29)");

//        Update Query
//        int result = statement.executeUpdate("update emp set name='Devil' where id=1");

        int result = statement.executeUpdate("delete from emp where id=4");
        System.out.println(result + "records affected");

        connection.close();
    }
}
