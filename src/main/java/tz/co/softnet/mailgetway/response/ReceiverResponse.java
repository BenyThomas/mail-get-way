package tz.co.softnet.mailgetway.response;

public class ReceiverResponse {

    private String message;
    public ReceiverResponse(String msg) {
        this.message = msg;
    }


    public String getMessage() {
        return message;
    }
}
