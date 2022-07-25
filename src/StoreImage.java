import java.io.*;
import java.sql.*;

public class StoreImage {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java-jdbc","root","");

            PreparedStatement preparedStatement = connection.prepareStatement("insert into imagetable values(?,?)");

            File file = new File("D:/1.png");
            preparedStatement.setString(1,file.getName());

            FileInputStream fileInputStream = new FileInputStream(file);
            preparedStatement.setBinaryStream(2, fileInputStream, fileInputStream.available());

            int i = preparedStatement.executeUpdate();
            System.out.println(i + " records affected");

            connection.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
