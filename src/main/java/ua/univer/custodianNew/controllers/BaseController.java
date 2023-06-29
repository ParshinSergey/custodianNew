package ua.univer.custodianNew.controllers;

import dmt.custodian2016.Request;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;

public class BaseController {

    //public static final String DECKRA_URL = "https://10.1.2.80/API_BP/cp_api.dll";
    public static final String DECKRA_URL = "https://localhost/API_BP/cp_api.dll";
    public static final String DECKRA_URL_TEST = "http://localhost:8081/api/service/result";

    private final Marshaller marshaller;
    protected final HttpClient httpClient;

    public BaseController(Marshaller marshaller, HttpClient httpClient) {
        this.marshaller = marshaller;
        this.httpClient = httpClient;
    }


    protected void saveToFileXml(Request request, File file) {
        try {
            marshaller.marshal(request, file);
        }
        catch (JAXBException ex) {
            String message = ex.getMessage();
            if (message == null) {
                message = ex.getCause().getMessage();
                if (message == null) {
                    message = "Unidentified JAXB error";
                }
            }
            System.out.println(message);
        }
    }

    protected void saveXmlToWriter(Request request, Writer writer) {
        try {
            marshaller.marshal(request, writer);
        }
        catch (JAXBException ex) {
            String message = ex.getMessage();
            if (message == null) {
                message = ex.getCause().getMessage();
                if (message == null) {
                    message = "Unidentified JAXB error";
                }
            }
            System.out.println(message);
        }
    }

    protected String writeAndSendRequestWriteResponseToFile(Request request, String prefix) throws IOException {

        Writer writer = new StringWriter();
        saveXmlToWriter(request, writer);
        File file = Util.getFile(prefix, ".xml");
        Files.writeString(file.toPath(), writer.toString());

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(DECKRA_URL))
                .POST(HttpRequest.BodyPublishers.ofString(writer.toString()))
                .header("Content-Type", "application/xml")
                .build();

        HttpResponse<String> httpResponse = null;
        try {
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Error connecting to Deckra-service. Message - " + e.getMessage());
        }

        file = Util.getFile("Response", ".xml");
        String response =  httpResponse.body();
        Files.writeString(file.toPath(), response);

        writer.close();

        return response;

    }

}
