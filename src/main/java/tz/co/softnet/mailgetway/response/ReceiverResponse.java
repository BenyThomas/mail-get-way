package tz.co.softnet.mailgetway.response;

public class ReceiverResponse {
    private int code;
    private String message;
    public ReceiverResponse(int code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
