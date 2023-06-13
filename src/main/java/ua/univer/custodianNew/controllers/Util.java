package ua.univer.custodianNew.controllers;


import dmt.custodian2016.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import ua.univer.custodianNew.dto.FormFO;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
        //header.setRequestID(UUID.randomUUID().toString());
        header.setRequestID("860966B1-2E36-4242-85F1-BFA4F23AA487");
        header.setTimeStamp(xmlGregorianCalendar());
        header.setSourceAPPidentity("1DD4EC32-45DB-404A-A123-6F657895E502");
        return header;
    }

    static TbodyRequest convertFromFormToBody(FormFO form){
        TCustomer tCustomer = new TCustomer();

        tCustomer.setAccount(null);

        if (form.getCustomerID() != null) {
            tCustomer.setCustomerID(new BigInteger(form.getCustomerID().toString()));
        }

        var cnum = new TCustomer.CNUM();
        cnum.setValue(form.getCnum());
        tCustomer.setCNUM(cnum);

        var country = new TCustomer.Country();
        country.setValue(form.getCountry());
        tCustomer.setCountry(country);

        var countryTax = new TCustomer.CountryTax();
        countryTax.setValue(form.getCountryTax());
        tCustomer.setCountryTax(countryTax);

        var idCode = new TCustomer.IdCode();
        idCode.setValue(form.getIdCode());
        tCustomer.setIdCode(idCode);

        var clientTypeCode = new TCustomer.ClientTypeCode();
        clientTypeCode.setValue(form.getClientTypeCode());
        tCustomer.setClientTypeCode(clientTypeCode);

        TName tName = new TName();
        var longName = new TName.LongName();
        longName.setValue(form.getLongName());
        var shortName = new TName.ShortName();
        shortName.setValue(form.getShortName());
        tName.setLongName(longName);
        tName.setShortName(shortName);
        tCustomer.setName(tName);

        var addresses = new TCustomer.Addresses();
        Taddress address = new Taddress();
        switch (form.getAddressType().toUpperCase().trim()){
           case "LEGAL" ->  address.setAddressType(TAddressType.LEGAL);
           case "POST" ->  address.setAddressType(TAddressType.POST);
           case "OTHER" ->  address.setAddressType(TAddressType.OTHER);
            default -> throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Error in Field 'AddressType'");
        }
        address.setCountry(form.getCountryAdr());
        address.setPostIndex(form.getPostIndex());
        address.setRegion(form.getRegion());
        address.setDistrict(form.getDistrict());
        address.setLocality(form.getLocality());
        address.setStreet(form.getStreet());
        address.setHouse(form.getHouse());
        address.setFlat(form.getFlat());
        address.setAddressFree(form.getAddressFree());
        addresses.getAddress().add(address);
        tCustomer.setAddresses(addresses);

        TdocFO document = new TdocFO();
        document.setDocSerial(form.getDocSerial());
        document.setDocNumber(form.getDocNumber());
       // document.setDocDate(form.getDocDate());
        document.setDocWho(form.getDocWho());
        document.setDocType(form.getDocType());
       // document.setDocDatestart(form.getDocDateStart());
       // document.setDocDateStop(form.getDocDateStop());
        document.setDocSDRnumber(form.getDocSDRnumber());
        tCustomer.setDocFO(document);



        tCustomer.setBankDetails(null);
        tCustomer.setAddParams(null);
        tCustomer.setContact(null);
        tCustomer.setBirthInfo(null);
        tCustomer.setFund(null);
        tCustomer.setCurrency(null);
        tCustomer.setRefusingCode(null);
        tCustomer.setForm(null);




        TnewAccountRequest tnewAccountRequest = new TnewAccountRequest();

        var typeCode = new TnewAccountRequest.NssmcClientTypeCode();
        typeCode.setValue(form.getNssmcClientTypeCode());
        tnewAccountRequest.setNssmcClientTypeCode(typeCode);


        tnewAccountRequest.setCustomer(tCustomer);


        //  List<TnewAccountRequest.Agreements.Agreement> agreements = new ArrayList<>();
        var agreements = new TnewAccountRequest.Agreements();
        var agreement = new TnewAccountRequest.Agreements.Agreement();
        agreement.setNumber(form.getAgreementNumber());
        agreement.setDate(form.getAgreementDate());
        agreement.setDateStart(form.getAgreementDateStart());
        agreement.setDateStop(form.getAgreementDateStop());
        agreement.setAgrID(new BigInteger(form.getAgrID().toString()));
        //agreements.add(agreement);
        agreements.getAgreement().add(agreement);
        tnewAccountRequest.setAgreements(agreements);


        TbodyRequest tbodyRequest = new TbodyRequest();
        tbodyRequest.setNewAccount(tnewAccountRequest);

        return tbodyRequest;
    }

}

