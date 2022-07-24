import java.sql.*;

public class ResultSetMetaDateInterface {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java-jdbc", "root", "");

            PreparedStatement statement = connection.prepareStatement("select * from  emp");
            ResultSet resultSet = statement.executeQuery();
            ResultSetMetaData resultSetMetaData= resultSet.getMetaData();

            System.out.println("Total Column: "+ resultSetMetaData.getColumnCount());
            System.out.println("First Column: "+ resultSetMetaData.getColumnName(1));
            System.out.println("Second Column Type Name: "+ resultSetMetaData.getColumnTypeName(2));
            System.out.println("Table Name: "+ resultSetMetaData.getTableName(1));

            connection.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
