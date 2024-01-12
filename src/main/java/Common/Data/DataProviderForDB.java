package Common.Data;

import Common.Utility.DBSteps;
import org.testng.annotations.DataProvider;

import java.sql.SQLException;
import java.util.Map;

public class DataProviderForDB{

    @DataProvider(name = "loginData")
    public static Object[][] dataProviderMethod() throws SQLException {
        Map<String, String> testData = DBSteps.dbData();
        Object[][] data = new Object[testData.size()][2];
        int index = 0;
        for (Map.Entry<String, String> entry : testData.entrySet()) {
            data[index][0] = entry.getKey();
            data[index][1] = entry.getValue();
            index++;
        }
        return data;
    }
}
