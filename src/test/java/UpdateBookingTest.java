import com.fasterxml.jackson.core.JsonProcessingException;
import data.DataProviders;
import io.restassured.response.Response;
import step.StepsClass;

import java.text.ParseException;


@org.testng.annotations.Test(dataProviderClass = DataProviders.class, dataProvider = "DB")
public class UpdateBookingTest {
    public void updateBookingTest(String firstName, String lastName, int totalPrice, boolean depositPaid, String checkin, String checkout,
                       String additionalNeeds, int saleprice, String passportNo) throws JsonProcessingException, ParseException {
        StepsClass step = new StepsClass();

        String body = step.getData(firstName, lastName, totalPrice, depositPaid, checkin,
                checkout, additionalNeeds, saleprice, passportNo);

        Response response = step.getResponse(body);
        response.prettyPrint();

        step.validateResponse(response, firstName, lastName, totalPrice, depositPaid, checkin,
                checkout, additionalNeeds);


    }

}
