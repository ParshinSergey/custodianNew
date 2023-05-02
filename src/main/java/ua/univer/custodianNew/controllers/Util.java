package ua.univer.custodianNew.controllers;


import dmt.custodian2016.THeaderRequest;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.UUID;

import static ua.univer.custodianNew.config.AppConfiguration.DIRECTORY;

public final class Util {

    private Util() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }


    static File getFile() {
        File file;
        try {
            Path tempRequest = Files.createTempFile(Path.of(DIRECTORY), "request", ".xml");
            file = new File(tempRequest.toString());
        } catch (IOException e) {
            throw new RuntimeException("File was not created");
        }
        return file;
    }

    static XMLGregorianCalendar xmlGregorianCalendar(){
        LocalDateTime dateTime = LocalDateTime.now();
        XMLGregorianCalendar date = null;
        try {
            date = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateTime.toString());
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException(e);
        }
        return date;
    }

    static THeaderRequest getHeaderRequest() {
        THeaderRequest header = new THeaderRequest();
        header.setRequestID(UUID.randomUUID().toString());
        header.setTimeStamp(xmlGregorianCalendar());
        header.setSourceAPPidentity("1DD4EC32-45DB-404A-A123-6F657895E502");
        return header;
    }
}

