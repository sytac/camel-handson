package io.sytac.edu.rest;


import org.codehaus.jackson.annotate.JsonProperty;

public class Response {

    @JsonProperty("status")
    private String status;
    @JsonProperty("message")
    private String message;

    public Response(String status, String message) {
        this.status = status;
        this.message = message;
    }


}
