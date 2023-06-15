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
import java.time.LocalDate;
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

    static XMLGregorianCalendar xmlGregorianCalendar(LocalDate dateTime){
        XMLGregorianCalendar date = null;
        if (dateTime == null){
            return null;
        }
        try {
            date = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateTime.toString());
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException(e);
        }
        return date;
    }

    static XMLGregorianCalendar xmlGregorianCalendar(LocalDateTime dateTime){
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
        //header.setRequestID("860966B1-2E36-4242-85F1-BFA4F23AA487");
        header.setTimeStamp(xmlGregorianCalendar( LocalDateTime.now()));
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
        if(form.getAddressType() != null){
        switch (form.getAddressType().toUpperCase().trim()){
           case "LEGAL" ->  address.setAddressType(TAddressType.LEGAL);
           case "POST" ->  address.setAddressType(TAddressType.POST);
           case "OTHER" ->  address.setAddressType(TAddressType.OTHER);
            default -> throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Error in Field 'AddressType'");
        }}
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
        document.setDocDate(Util.xmlGregorianCalendar(form.getDocDate()));
        document.setDocWho(form.getDocWho());
        document.setDocType(form.getDocType());
        document.setDocDatestart(Util.xmlGregorianCalendar(form.getDocDateStart()));
        document.setDocDateStop(Util.xmlGregorianCalendar(form.getDocDateStop()));
        document.setDocSDRnumber(form.getDocSDRnumber());
        tCustomer.setDocFO(document);

        TBankDetail bankDetail = new TBankDetail();
        bankDetail.setMFO(form.getMfo());
        bankDetail.setIBAN(form.getIban());
        bankDetail.setCardAccount(form.getCardAccount());
        bankDetail.setBankName(form.getBankName());
        bankDetail.setCurrency(form.getCurrency());
        bankDetail.setBIC(form.getBic());
        bankDetail.setLEI(form.getLei());
        if (form.getBankDetailID() != null) {
            bankDetail.setBankDetailID(new BigInteger(form.getBankDetailID().toString()));
        }
        bankDetail.setUse4Income(form.isUse4Income());
        if (form.getType() != null) {
            bankDetail.setType(new BigInteger(form.getType().toString()));
        }
        var bankDetails = new TCustomer.BankDetails();
        bankDetails.getBankDetail().add(bankDetail);
        tCustomer.setBankDetails(bankDetails);

        var contact = new TCustomer.Contact();
        var hhh = new TContact.Phone();
        hhh.setValue(form.getPhone());
        contact.setPhone(hhh);
        var mobilePhone = new TContact.MobilePhone();
        mobilePhone.setValue(form.getMobilePhone());
        contact.setMobilePhone(mobilePhone);
        var eMail = new TContact.EMails();
        var eMailGeneral = new TContact.EMails.EMailGeneral();
        eMailGeneral.setValue(form.geteMailGeneral());
        eMail.setEMailGeneral(eMailGeneral);
        contact.setEMails(eMail);
        tCustomer.setContact(contact);

        var birthInfo = new TCustomer.BirthInfo();
        birthInfo.setBirthDate(xmlGregorianCalendar(form.getBirthDate()));
        birthInfo.setBirthPlace(form.getBirthPlace());
        tCustomer.setBirthInfo(birthInfo);

        var refusingCode = new TCustomer.RefusingCode();
        refusingCode.setValue(form.isRefusingCode());
        tCustomer.setRefusingCode(refusingCode);


        TnewAccountRequest tnewAccountRequest = new TnewAccountRequest();

        var typeCode = new TnewAccountRequest.NssmcClientTypeCode();
        typeCode.setValue(form.getNssmcClientTypeCode());
        tnewAccountRequest.setNssmcClientTypeCode(typeCode);

        tnewAccountRequest.setCustomer(tCustomer);


        var agreements = new TnewAccountRequest.Agreements();
        var agreement = new TnewAccountRequest.Agreements.Agreement();
        agreement.setNumber(form.getAgreementNumber());
        agreement.setDate(Util.xmlGregorianCalendar(form.getAgreementDate()));
        agreement.setDateStart(Util.xmlGregorianCalendar(form.getAgreementDateStart()));
        agreement.setDateStop(Util.xmlGregorianCalendar(form.getAgreementDateStop()));
        if (form.getAgrID() != null) {
            agreement.setAgrID(new BigInteger(form.getAgrID().toString()));
        }
        agreements.getAgreement().add(agreement);
        tnewAccountRequest.setAgreements(agreements);


        var brokerAgreements = new TnewAccountRequest.BrokerAgreements();
        var brokerAgreement = new TnewAccountRequest.BrokerAgreements.BrokerAgreement();
        if (form.getBrokerCustomerID() != null) {
            brokerAgreement.setCustomerID(new BigInteger(form.getBrokerCustomerID().toString()));
        }
        brokerAgreement.setNumber(form.getBrokerAgreementNumber());
        brokerAgreement.setDate(Util.xmlGregorianCalendar(form.getBrokerAgreementDate()));
        brokerAgreement.setDateStart(Util.xmlGregorianCalendar(form.getBrokerAgreementDateStart()));
        brokerAgreement.setDateStop(Util.xmlGregorianCalendar(form.getBrokerAgreementDateStop()));
        if (form.getBrokerAgrID() != null) {
            brokerAgreement.setAgrID(new BigInteger(form.getBrokerAgrID().toString()));
        }
        brokerAgreements.getBrokerAgreement().add(brokerAgreement);
        tnewAccountRequest.setBrokerAgreements(brokerAgreements);


        TbodyRequest tbodyRequest = new TbodyRequest();
        tbodyRequest.setNewAccount(tnewAccountRequest);

        return tbodyRequest;
    }

}

