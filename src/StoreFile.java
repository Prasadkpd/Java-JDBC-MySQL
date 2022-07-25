import java.io.*;
import java.sql.*;

public class StoreFile {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java-jdbc","root","");

            PreparedStatement preparedStatement = connection.prepareStatement("insert into filetable values(?,?)");
            File file = new File("D:\\sam.txt");
            FileReader fileReader = new FileReader(file);
            preparedStatement.setInt(1,1);
            preparedStatement.setCharacterStream(2,fileReader,(int)file.length());
            int i=preparedStatement.executeUpdate();
            System.out.println(i+" records affected");
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
