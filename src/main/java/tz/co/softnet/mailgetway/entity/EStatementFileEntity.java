package tz.co.softnet.mailgetway.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "statement")
public class EStatementFileEntity {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    @Lob
    private byte[] data;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "receiver_id")
    private ReceiverEntity receiver;

    public EStatementFileEntity(String fileName, String contentType, byte[] bytes, ReceiverEntity receiver) {
        this.name= fileName;
        this.type =contentType;
        this.data = bytes;
        this.receiver = receiver;
    }

    public EStatementFileEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public ReceiverEntity getReceiver() {
        return receiver;
    }

    public void setReceiver(ReceiverEntity receiver) {
        this.receiver = receiver;
    }
}
