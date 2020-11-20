package tz.co.softnet.mailgetway.entity;

import javax.persistence.*;
import java.io.File;
@Entity
@Table(name = "receiver")
public class ReceiverEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email_address")
    private String emailAddress;
    @Column(name = "subject")
    private String subject;
    @Column(name = "email_body")
    private String emailBody;
    @Column(name = "attachment")
    private File attachment;
    public ReceiverEntity(){}

    public ReceiverEntity(String emailAddress,String subject, String body, File attachment) {
        this.emailAddress=emailAddress;
        this.subject =subject;
        this.emailBody = body;
        this.attachment = attachment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmailBody() {
        return emailBody;
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody;
    }

    public File getAttachment() {
        return attachment;
    }

    public void setAttachment(File attachment) {
        this.attachment = attachment;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
