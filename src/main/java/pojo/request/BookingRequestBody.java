package pojo.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties("saleprice")

public class BookingRequestBody {
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
    int saleprice;
 //   @JsonInclude(JsonInclude.Include.NON_NULL)
    String passportNo;


}
