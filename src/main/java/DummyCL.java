import Common.Data.SQLConn;
import Common.Utility.DBSteps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DummyCL {


    public static void main(String[] args) throws SQLException {
        HashMap<String,String> credentials=new HashMap<>();
        // Establish a database connection (SQLConn.getConnection() is assumed to be a valid method)
        Connection connection = SQLConn.getConnection();
        try {
            String sqlQuery = "SELECT userName, password FROM redditAccs";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String userName = resultSet.getString("userName");
                String password = resultSet.getString("password");
                credentials.put(userName,password);
                // Use the retrieved data for your test
                System.out.println("Username: " + userName);
                System.out.println("Password: " + password);

                // You can perform your test logic here, such as logging in with these credentials.
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(credentials);
        System.out.println(DBSteps.dbData());

    }



}
