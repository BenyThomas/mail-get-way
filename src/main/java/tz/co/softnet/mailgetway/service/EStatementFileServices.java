package tz.co.softnet.mailgetway.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import tz.co.softnet.mailgetway.entity.EStatementFileEntity;
import tz.co.softnet.mailgetway.entity.ReceiverEntity;
import tz.co.softnet.mailgetway.repository.EStatementFileRepository;

import java.io.*;
import java.util.stream.Stream;


@Service
public class EStatementFileServices  {
    @Autowired
    private EStatementFileRepository repository;
    public EStatementFileEntity savaEStatement(MultipartFile file, ReceiverEntity receiver) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        EStatementFileEntity entity = new EStatementFileEntity(fileName,file.getContentType(),file.getBytes(), receiver);
        return  repository.save(entity);

    }
    public EStatementFileEntity getStatementById(Long id){
       return repository.findById(id).get();
    }
    public Stream<EStatementFileEntity> getAllStatements(){
        return repository.findAll().stream();
    }

    File file;
    public String getFileInPdf(Long id) throws IOException {
        EStatementFileEntity entity = repository.findById(id).get();
        String url= entity.getName();
        OutputStream outputStream = new FileOutputStream(url);
        outputStream.write(entity.getData());
        outputStream.close();
        return url;
    }

}
