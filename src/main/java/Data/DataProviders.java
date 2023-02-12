package data;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.testng.annotations.DataProvider;

public class DataProviders {
    @Contract(pure = true)
    @DataProvider(name = "DB")
    public static Object[] @NotNull [] twoValues() {

        Object[][] ob =new Object[][]
         {{"James", "Bond", 6, true, "2018-01-01", "2019-01-01", "dinner", 3, null},
                 {"Grisha", "Jgamadze", 10, false, "2017-01-01", "2018-01-01", "dinner", 4, null }
        };
        return ob;

    }
}

