package tz.co.softnet.mailgetway.model;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class ReceiverData {
    private String emailAddress;
    private String subject;
    private String body;
    public String getEmailAddress() {
        return emailAddress;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }


}
