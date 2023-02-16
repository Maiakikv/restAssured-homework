package Data.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateUserRequest(@JsonProperty("userName")  String userName,
                                @JsonProperty("password") String password) {
}
