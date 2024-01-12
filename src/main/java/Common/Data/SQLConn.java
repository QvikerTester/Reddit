package Common.Data;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class SQLConn {
    public static Connection getConnection(){
        Connection connection;
        try (FileInputStream f = new FileInputStream("C:\\Users\\Tazo\\IdeaProjects\\Reddit11\\RedditLab-RedditLab1.0-with-scrollNroll\\RedditLab-RedditLab1.0-with-scrollNroll\\src\\main\\resources\\db.properties")){
            Properties properties = new Properties();
            properties.load(f);
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url, username, password);


        } catch (IOException|SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}

