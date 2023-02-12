package step;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import enums.EndPoint;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import pojo.request.BookingDates;
import pojo.request.BookingRequestBody;
import pojo.response.BooksResponse;
import util.DateUtils;
import util.GeneratedToken;

import java.text.ParseException;

import static io.restassured.RestAssured.given;

public class StepsClass {
    @Step("Get Data")
    public String getData(String firstName, String lastName, int totalPrice, boolean depositPaid, String checkin, String checkout,
                          String additionalNeeds, int saleprice, String passportNo) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        BookingRequestBody body = new BookingRequestBody();
        BookingDates dates = new BookingDates();

        body.setFirstName(firstName);
        body.setLastName(lastName);
        body.setTotalPrice(totalPrice);
        body.setDepositPaid(depositPaid);
        dates.setCheckIn(checkin);
        dates.setCheckOut(checkout);
        body.setBookingDates(dates);
        body.setAdditionalNeeds(additionalNeeds);
        body.setSaleprice(saleprice);
        body.setPassportNo(passportNo);
        String requestParam = mapper.writeValueAsString(body);
        return requestParam;

    }

    @Step("Get response")
    public Response getResponse(String body) {

        return given().header("Cookie", "token=" + GeneratedToken.generateToken())
                .filter(new AllureRestAssured())
                .contentType("application/json")
                .body(body)
                .when()
                .put(EndPoint.BASEURL + "/booking/1");
    }

    @Step("Assertions")
    public void validateResponse(Response response, String firstName, String lastName, int totalPrice, boolean depositPaid,
                                 String checkin, String checkout, String additionalNeeds) throws ParseException {
        response.then().assertThat().statusCode(200);

        BooksResponse booksResponse = response.body().as(BooksResponse.class);
        Assert.assertEquals(firstName, booksResponse.getFirstName());
        Assert.assertEquals(lastName, booksResponse.getLastName());
        Assert.assertEquals(totalPrice, booksResponse.getTotalPrice());
        Assert.assertEquals(additionalNeeds, booksResponse.getAdditionalNeeds());
        if (depositPaid == true) {
            Assert.assertTrue(booksResponse.isDepositPaid());
        } else {
            Assert.assertTrue(!booksResponse.isDepositPaid());
        }
        Assert.assertEquals((DateUtils.stringToDate(checkin)),
                DateUtils.stringToDate(booksResponse.getBookingDates().getCheckIn()));
        Assert.assertEquals((DateUtils.stringToDate(checkout)),
                DateUtils.stringToDate(booksResponse.getBookingDates().getCheckOut()));


    }

}
