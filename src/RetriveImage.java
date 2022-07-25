import java.io.*;
import java.sql.*;

public class RetriveImage {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java-jdbc","root","");

            PreparedStatement preparedStatement = connection.prepareStatement("select * from imagetable");
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                Blob blob = resultSet.getBlob(2);
                byte barr[] = blob.getBytes(1,(int) blob.length());

                FileOutputStream fileOutputStream = new FileOutputStream("d:\\1.png");
                fileOutputStream.write(barr);
                fileOutputStream.close();
            }

            System.out.println("Done");
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
