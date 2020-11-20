package tz.co.softnet.mailgetway.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tz.co.softnet.mailgetway.entity.ReceiverEntity;
import tz.co.softnet.mailgetway.model.ReceiverData;
import tz.co.softnet.mailgetway.repository.ReceiverRepository;
import tz.co.softnet.mailgetway.response.ReceiverResponse;

import java.util.List;

@RestController
@Api(value = "E-Statement Receiver", description = "Receive e-statement as an attachment, subject, receiver email address and mail body", tags = { "E-STATEMENT RECEIVER"})
public class ReceiverController {
    @Autowired
    private ReceiverRepository receiver;

    @ApiOperation(value = "Receives e-statement detatils", notes = "Receiver e-statement and send the to zimbra", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "receive",method = RequestMethod.POST)
    public ReceiverResponse receiveEStatement(@RequestBody ReceiverData data){
        ReceiverEntity entity = new ReceiverEntity(data.getEmailAddress(),data.getSubject(), data.getBody(),data.getAttachment());
        receiver.save(entity);
        if (entity.getId() == null)
            return new ReceiverResponse(201, " not sent to zimbra");
        return new ReceiverResponse(200, " sent to zimbra ");


    }

    @ApiOperation(value = "Get all received e-statement", notes = "Get all E-statements", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "all", method = RequestMethod.GET)
    public List<ReceiverEntity> getAllEStatements(){return receiver.findAll();}

}
