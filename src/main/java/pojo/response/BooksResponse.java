package pojo.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import pojo.request.BookingDates;
//@JsonPropertyOrder(alphabetic=true)
@JsonPropertyOrder({"firstName", "bookingDates", "additionalneeds", "depositpaid", "lastname", "totalprice"})
@Getter
@Setter
public class BooksResponse {
    @JsonProperty("firstname")
    String firstName;
    @JsonProperty("lastname")
    String lastName;
    @JsonProperty("totalprice")
    int totalPrice;
    @JsonProperty("depositpaid")
    boolean depositPaid;
    @JsonProperty("bookingdates")
    BookingDates bookingDates;
    @JsonProperty("additionalneeds")
    String additionalNeeds;
}
