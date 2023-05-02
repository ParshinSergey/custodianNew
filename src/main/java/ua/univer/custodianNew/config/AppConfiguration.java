package ua.univer.custodianNew.config;


import dmt.custodian2016.Request;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.net.http.HttpClient;

@Configuration
public class AppConfiguration {
    final static String PACKAGE = Request.class.getPackage().getName();
    public final static String DIRECTORY = "testDirectory";

    @Bean
    public Marshaller getMarshaller() throws JAXBException {
        File directory = new File(DIRECTORY);
        if(!directory.exists()) {
            directory.mkdir();
        }
        JAXBContext jc = JAXBContext.newInstance(PACKAGE);
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        return marshaller;
    }

    @Bean
    public HttpClient getHttpClient(){
        return HttpClient.newHttpClient();
    }

}


