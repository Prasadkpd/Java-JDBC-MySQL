import java.io.*;
import java.sql.*;

public class RetriveFile {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java-jdbc","root","");

            PreparedStatement preparedStatement = connection.prepareStatement("select * from filetable");
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.first();

            Clob c = resultSet.getClob(2);
            Reader r = c.getCharacterStream();

            FileWriter fileWriter = new FileWriter("D:\\create.txt");
            int i;
            while ((i=r.read())!=-1)
                fileWriter.write((char)i);

            fileWriter.close();
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
