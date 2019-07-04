package qaApiServices.protocol;

import constants.QaApiUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ProtocolClient {

    public ProtocolResponse getAllProtocolInfo() {
        Response response = given()
                .contentType(ContentType.JSON)
                .get(QaApiUrl.getProtocol);

        ProtocolResponse protocolResponse = response.as(ProtocolResponse.class);
        return protocolResponse;
    }
}
