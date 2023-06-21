package ua.univer.custodianNew.controllers;

import dmt.custodian2016.Request;
import jakarta.xml.bind.Marshaller;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.net.http.HttpClient;

@RestController
@RequestMapping(value = "/api/request", produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
public class RequestController extends BaseController {


    public RequestController(Marshaller marshaller, HttpClient httpClient) {
        super(marshaller, httpClient);
    }

    @GetMapping(value = "/balance", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Request> getBalanceToFile(@RequestBody Request request) {
        File file = Util.getFile("Balance", ".xml");
        saveToFileXml(request, file);

        return ResponseEntity.ok().body(request);
    }

}

