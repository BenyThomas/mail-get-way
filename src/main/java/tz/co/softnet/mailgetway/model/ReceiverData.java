package tz.co.softnet.mailgetway.model;

import java.io.File;

public class ReceiverData {
    private String emailAddress;
    private String subject;
    private String body;
    private File attachment;

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public File getAttachment() {
        return attachment;
    }
}
