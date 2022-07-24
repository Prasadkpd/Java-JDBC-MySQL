import java.sql.*;

public class DatabaseMetaDataInterface {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java-jdbc", "root", "");

            DatabaseMetaData databaseMetaData = connection.getMetaData();

            System.out.println("Driver Name: " + databaseMetaData.getDriverName());
            System.out.println("Driver Version: " + databaseMetaData.getDriverVersion());
            System.out.println("UserName: " + databaseMetaData.getUserName());
            System.out.println("Database Product Name: " + databaseMetaData.getDatabaseProductName());
            System.out.println("Database Product Version: " + databaseMetaData.getDatabaseProductVersion());

            System.out.println("Database Tables:");
            String table[]={"TABLE"}; //For view make TABLE as VIEW
            ResultSet resultSet=databaseMetaData.getTables(null,null,null,table);
            while (resultSet.next()){
                System.out.println(resultSet.getString(3));
            }


            connection.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
