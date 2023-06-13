package ua.univer.custodianNew.controllers;

import dmt.custodian2016.*;
import jakarta.xml.bind.Marshaller;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping(value = "/api/request/account", produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
public class AccountController extends BaseController {

    private final static String NEW_ACCOUNT = "newAccount";

    public AccountController(Marshaller marshaller, HttpClient httpClient) {
        super(marshaller, httpClient);
    }


    @PostMapping (value = "/" + NEW_ACCOUNT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Request> getNewAccount (@RequestBody Request request) {
        THeaderRequest tHeaderRequest = Util.getHeaderRequest();
        tHeaderRequest.setRequestType(NEW_ACCOUNT);
        request.setHeader(tHeaderRequest);

        File file = Util.getFile();
        saveToFileXml(request, file);

        return ResponseEntity.ok().body(request);
    }

    @PostMapping (value = "/" + NEW_ACCOUNT + "UO", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getNewAccountUO (@RequestBody Request request) {
        THeaderRequest tHeaderRequest = Util.getHeaderRequest();
        tHeaderRequest.setRequestType(NEW_ACCOUNT);
        request.setHeader(tHeaderRequest);

        Writer writer = new StringWriter();
        saveToXml(request, writer);

        // стремное место
        // HttpsURLConnection.setDefaultHostnameVerifier ((hostname, session) -> true);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(DECKRA_URL))
                .POST(HttpRequest.BodyPublishers.ofString(writer.toString()))
                .header("Content-Type", "application/xml")
                .build();


        HttpResponse<String> responce = null;
        try {
            responce = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Error connecting to Deckra-service. Message - " + e.getMessage());
        }

       // System.out.println(responce.body());

        return ResponseEntity.ok().body(responce.body());
    }


    @PostMapping (value = "/" + NEW_ACCOUNT + "FO", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Request> getNewAccountFO (@RequestParam(name = "shortName") String fio,
                                                    @RequestParam(name = "longName") String fullFio) {
        Request request = new Request();

        THeaderRequest tHeaderRequest = Util.getHeaderRequest();
        tHeaderRequest.setRequestType(NEW_ACCOUNT);
        request.setHeader(tHeaderRequest);

        TCustomer tCustomer = new TCustomer();
        tCustomer.setAccount(null);
        tCustomer.setCustomerID(null);
        tCustomer.setCNUM(null);

        TCustomer.Country sdf = new TCustomer.Country();
        sdf.setValue("804");
        tCustomer.setCountry(sdf);


        tCustomer.setCountryTax(null);
        tCustomer.setIdCode(null);
        tCustomer.setClientTypeCode(null);

        TName tName = new TName();
        TName.LongName longName = new TName.LongName();
        longName.setValue(fullFio);
        TName.ShortName shortName = new TName.ShortName();
        shortName.setValue(fio);
        tName.setLongName(longName);
        tName.setShortName(shortName);
        tCustomer.setName(tName);


        tCustomer.setAddresses(null);
        tCustomer.setDocFO(null);
        tCustomer.setDocUO(null);
        tCustomer.setBankDetails(null);
        tCustomer.setAddParams(null);
        tCustomer.setContact(null);
        tCustomer.setBirthInfo(null);
        tCustomer.setFund(null);
        tCustomer.setCurrency(null);
        tCustomer.setRefusingCode(null);
        tCustomer.setForm(null);

        TnewAccountRequest tnewAccountRequest = new TnewAccountRequest();
        tnewAccountRequest.setCustomer(tCustomer);

        TbodyRequest tbodyRequest = new TbodyRequest();
        tbodyRequest.setNewAccount(tnewAccountRequest);

        request.setBody(tbodyRequest);



        File file = Util.getFile();
        saveToFileXml(request, file);

        return ResponseEntity.ok().body(request);
    }

    @PostMapping(value = "/" + NEW_ACCOUNT + "Test", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Request> getNewAccountTest (@RequestBody FormFO form){

        Request request = new Request();

        THeaderRequest tHeaderRequest = Util.getHeaderRequest();
        tHeaderRequest.setRequestType(NEW_ACCOUNT);
        tHeaderRequest.setRequestID(form.getRequestID());
        request.setHeader(tHeaderRequest);

        TbodyRequest tbodyRequest = Util.convertFromFormToBody(form);
        request.setBody(tbodyRequest);

        Writer writer = new StringWriter();
        saveToXml(request, writer);

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

        return ResponseEntity.ok().body(request);
    }


}

