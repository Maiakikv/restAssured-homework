package pojo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingDates {
    @JsonProperty("checkin")
    public String checkIn;
    @JsonProperty("checkout")
    public String checkOut;


}
