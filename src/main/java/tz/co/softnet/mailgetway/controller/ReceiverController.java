package tz.co.softnet.mailgetway.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tz.co.softnet.mailgetway.entity.ReceiverEntity;
import tz.co.softnet.mailgetway.repository.ReceiverRepository;
import tz.co.softnet.mailgetway.response.ReceiverResponse;
import tz.co.softnet.mailgetway.service.EStatementFileServices;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

@RestController
@Api(value = "E-Statement Receiver", description = "Receive e-statement as an attachment, subject, receiver email address and mail body", tags = { "E-STATEMENT RECEIVER"})
@RequestMapping(value = "api/v1")
public class ReceiverController {
    @Autowired
    private ReceiverRepository receiver;
    @Autowired
    private EStatementFileServices services;

    @ApiOperation(value = "Receives e-statement detatils", notes = "Receiver e-statement and send the to zimbra", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "receive",method = RequestMethod.POST)
    public ResponseEntity<ReceiverResponse> receiveEStatement(@RequestParam MultipartFile file,
                                                              @RequestParam String email,
                                                              @RequestParam String subject,
                                                              @RequestParam String contentBody
    ){
        String message="";
        try {
            message = "The file: " + file.getOriginalFilename() +" received successfully";
            ReceiverEntity entity = new ReceiverEntity(email,subject, contentBody);
            receiver.save(entity);
            if (entity.getId() == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ReceiverResponse("Receiver was not created"));
            services.savaEStatement(file, entity);
            services.getFileInPdf(entity.getId());
            return ResponseEntity.status(HttpStatus.OK).body(new ReceiverResponse(message));

        } catch (IOException e) {
            message = "Could not receive the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ReceiverResponse(message));
        }


    }

    @ApiOperation(value = "Get all received e-statement", notes = "Get all E-statements", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "all", method = RequestMethod.GET)
    public List<ReceiverEntity> getAllEStatements(){return receiver.findAll();}


    @ApiOperation(value = "Get all received files", notes = "Get all Files", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "files", method = RequestMethod.GET)
    public Stream getAllFiles(){return services.getAllStatements();}

    @ApiOperation(value = "Get all files url", notes = "Get all File url", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "{id}path", method = RequestMethod.GET)
    public String getFilePath(@PathVariable Long id){
        try {
            return services.getFileInPdf(id);
        }catch (IOException exception){
            System.out.println(exception.getMessage());
            return "Invalid File";
        }
    }
}
