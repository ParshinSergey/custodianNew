package ua.univer.custodianNew.controllers;

import dmt.custodian2016.*;
import jakarta.validation.Valid;
import jakarta.xml.bind.Marshaller;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ua.univer.custodianNew.dto.FormFO;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;

@RestController
@RequestMapping(value = "/api/request", produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class AccountController extends BaseController {

    private final static String NEW_ACCOUNT = "newAccount";

    public AccountController(Marshaller marshaller, HttpClient httpClient) {
        super(marshaller, httpClient);
    }


    @PostMapping (value = "/" + NEW_ACCOUNT)
    public ResponseEntity<Request> getNewAccount (@RequestBody Request request) {
        THeaderRequest tHeaderRequest = Util.getHeaderRequest("12345");
        tHeaderRequest.setRequestType(NEW_ACCOUNT);
        request.setHeader(tHeaderRequest);

        File file = Util.getFile("request", ".xml");
        saveToFileXml(request, file);

        return ResponseEntity.ok().body(request);
    }

    @PostMapping (value = "/" + NEW_ACCOUNT + "UO")
    public ResponseEntity<String> getNewAccountUO (@RequestBody Request request) {
        THeaderRequest tHeaderRequest = Util.getHeaderRequest("12345");
        tHeaderRequest.setRequestType(NEW_ACCOUNT);
        request.setHeader(tHeaderRequest);

        Writer writer = new StringWriter();
        saveXmlToWriter(request, writer);

        // стремное место
        // HttpsURLConnection.setDefaultHostnameVerifier ((hostname, session) -> true);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(DECKRA_URL_TEST))
                .POST(HttpRequest.BodyPublishers.ofString(writer.toString()))
                .header("Content-Type", "application/xml")
                .build();


        HttpResponse<String> responce = null;
        try {
            responce = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Error connecting to Deckra-service. Message - " + e.getMessage());
        }

        return ResponseEntity.ok().body(responce.body());
    }


    @PostMapping (value = "/" + NEW_ACCOUNT + "Test")
    public ResponseEntity<String> getNewAccountTest (@RequestBody @Valid FormFO form, BindingResult result) throws IOException {

        if (result.hasErrors()){
            StringBuilder sb = new StringBuilder();
            result.getFieldErrors().forEach(fe -> sb.append(fe.getField()).append(" ").append(fe.getDefaultMessage()).append("\n"));
            return new ResponseEntity<>(sb.toString(),HttpStatus.BAD_REQUEST);
        }

        Request request = new Request();

        THeaderRequest tHeaderRequest = Util.getHeaderRequest(form.getRequestID());
        tHeaderRequest.setRequestType(NEW_ACCOUNT);
        request.setHeader(tHeaderRequest);

        TbodyRequest tbodyRequest = Util.convertFromFormToBody(form);
        request.setBody(tbodyRequest);

        Writer writer = new StringWriter();
        saveXmlToWriter(request, writer);
        File file = Util.getFile("ReqNewAcc", ".txt");
        Files.writeString(file.toPath(), writer.toString());

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(DECKRA_URL_TEST))
                .POST(HttpRequest.BodyPublishers.ofString(writer.toString()))
                .header("Content-Type", "application/xml")
                .build();

        HttpResponse<String> responce = null;
        try {
            responce = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Error connecting to Deckra-service. Message - " + e.getMessage());
        }

        file = Util.getFile("ResponceNewAcc", ".xml");
        Files.writeString(file.toPath(), responce.body());
        writer.close();


        return ResponseEntity.ok().body(responce.body());
    }


    @PostMapping(value = "/" + NEW_ACCOUNT + "FO")
    public ResponseEntity<String> getNewAccountFO (@RequestBody @Valid FormFO form, BindingResult result) throws IOException {

        if (result.hasErrors()){
            StringBuilder sb = new StringBuilder();
            result.getFieldErrors().forEach(fe -> sb.append(fe.getField()).append(" ").append(fe.getDefaultMessage()).append("\n"));
            return new ResponseEntity<>(sb.toString(),HttpStatus.BAD_REQUEST);
        }

        Request request = new Request();

        THeaderRequest tHeaderRequest = Util.getHeaderRequest(form.getRequestID());
        tHeaderRequest.setRequestType(NEW_ACCOUNT);
        request.setHeader(tHeaderRequest);

        TbodyRequest tbodyRequest = Util.convertFromFormToBody(form);
        request.setBody(tbodyRequest);

        String deckraResponse = writeAndSendRequestWriteResponseToFile(request, "NewAccount");

        return ResponseEntity.ok().body(deckraResponse);
    }


}

