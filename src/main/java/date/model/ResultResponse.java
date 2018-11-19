package date.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * ModelApiResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-04-17T06:52:57.226Z")

public class ResultResponse {
    @JsonProperty("code")
    private Integer code = null;

    @JsonProperty("message")
    private String message = null;

    @JsonProperty("data")
    private Object data = null;

    public ResultResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultResponse(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}


