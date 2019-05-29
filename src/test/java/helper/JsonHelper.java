package helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class JsonHelper {

    public static String getJsonString(Object o) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.writeValueAsString(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static Object getResponseObject(String jsonString, Class responseClass) {

        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            return mapper.readValue(jsonString, responseClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getFileContentsAsString(InputStream stream) {

        List<String> lines = Arrays.asList();
        try {
            lines = IOUtils.readLines(stream, StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return StringUtils.join(lines, "");
    }
}
