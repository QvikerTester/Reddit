package Common.Utility;

import Common.Data.SQLConn;
import org.testng.annotations.DataProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DBSteps {
    static Connection connection = SQLConn.getConnection();

    public DBSteps insertAcc(String userName, String password) throws SQLException {
        String insertSql = "INSERT INTO redditAccs (userName, password) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);

            // Execute the INSERT statement
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully.");
            } else {
                System.out.println("Insert operation failed.");
            }
        }

        return this;
    }


    public static HashMap<String, String> dbData() throws SQLException {
        HashMap<String, String> testData = new HashMap<>();
        String sqlQuery = "SELECT userName, password FROM redditAccs";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ResultSet resultSet = preparedStatement.executeQuery();


        while (resultSet.next()) {
            String username = resultSet.getString("userName");
            String password = resultSet.getString("password");
            testData.put(username, password);

        }

        return testData;

    }
}

