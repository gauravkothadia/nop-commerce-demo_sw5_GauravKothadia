package resources.testdata;

import org.testng.annotations.DataProvider;

/**
 * Created by Jay Vaghani
 */
public class TestData {

    @DataProvider(name = "credentials")
    public Object[][] getData() {
        Object[][] data = new Object[][]{
                {"test1@gmail.com", "test123"},
                {"test2@gmail.com", "test1234"},
                {"test3@gmail.com", "test1255"}
        };
        return data;
    }
}
