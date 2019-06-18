package protocol;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ProtocolClient {

    public ProtocolResponse getAllProtocolInfo() {
        Response response = given()
                .contentType(ContentType.JSON)
                .get("https://api-qa.simple.org/api/v3/protocols/sync");

        ProtocolResponse protocolResponse = response.as(ProtocolResponse.class);
        return protocolResponse;
    }
}
