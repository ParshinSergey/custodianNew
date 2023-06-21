package ua.univer.custodianNew.controllers;


import dmt.custodian2016.*;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;
import ua.univer.custodianNew.dto.FormFO;
import ua.univer.custodianNew.util.DateTimeUtil;

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
import java.util.UUID;

import static ua.univer.custodianNew.config.AppConfiguration.DIRECTORY;

public final class Util {

    private Util() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }


    static File getFile(String prefix, String suffix) {
        File file;
        try {
            Path tempRequest = Files.createTempFile(Path.of(DIRECTORY), prefix, suffix);
            file = new File(tempRequest.toString());
        } catch (IOException e) {
            throw new RuntimeException("File was not created");
        }
        return file;
    }

  /*  static XMLGregorianCalendar xmlGregorianCalendar(LocalDate dateTime){
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
    }*/


    static THeaderRequest getHeaderRequest(String number) {
        int end = Integer.parseInt(number);
        int res = 1_000_000_000 + end;
        THeaderRequest header = new THeaderRequest();
        //header.setRequestID(UUID.randomUUID().toString());
        header.setRequestID("AA0966B1-2E36-4242-85F1-BF" + res);
        header.setTimeStamp(DateTimeUtil.xmlGregorianCalendar( LocalDateTime.now()));
        header.setSourceAPPidentity("AA0966B1-45DB-404A-A123-6F657895E502");
        return header;
    }

    static TbodyRequest convertFromFormToBody(FormFO form){
        TCustomer tCustomer = new TCustomer();

        tCustomer.setAccount(null);

        if (form.getCustomerID() != null) {
            tCustomer.setCustomerID(new BigInteger(form.getCustomerID().toString()));
        }
        var cnum = new TCustomer.CNUM();
        cnum.setValue(form.getCNUN());
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
        document.setDocDate(DateTimeUtil.xmlGregorianCalendar(form.getDocDate()));
        document.setDocWho(form.getDocWho());
        document.setDocType(form.getDocType());
        document.setDocDatestart(DateTimeUtil.xmlGregorianCalendar(form.getDocDatestart()));
        document.setDocDateStop(DateTimeUtil.xmlGregorianCalendar(form.getDocDateStop()));
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
        if (form.isUse4Income()) {
            bankDetail.setUse4Income(form.isUse4Income());
        }
        if (form.getType() != null) {
            bankDetail.setType(new BigInteger(form.getType().toString()));
        }
        var bankDetails = new TCustomer.BankDetails();
        bankDetails.getBankDetail().add(bankDetail);

        if (form.getType1() != null && StringUtils.hasLength(form.getIban1())) {
            TBankDetail bankDetail1 = new TBankDetail();
            bankDetail1.setIBAN(form.getIban1());
            bankDetail1.setCurrency(form.getCurrency1());
            bankDetail1.setType(new BigInteger(form.getType1().toString()));
            bankDetails.getBankDetail().add(bankDetail1);
        }
        if (form.getType2() != null && StringUtils.hasLength(form.getIban2())) {
            TBankDetail bankDetail2 = new TBankDetail();
            bankDetail2.setIBAN(form.getIban2());
            bankDetail2.setCurrency(form.getCurrency2());
            bankDetail2.setType(new BigInteger(form.getType2().toString()));
            bankDetails.getBankDetail().add(bankDetail2);
        }
        if (form.getType3() != null && StringUtils.hasLength(form.getIban3())) {
            TBankDetail bankDetail3 = new TBankDetail();
            bankDetail3.setIBAN(form.getIban3());
            bankDetail3.setCurrency(form.getCurrency3());
            bankDetail3.setType(new BigInteger(form.getType3().toString()));
            bankDetails.getBankDetail().add(bankDetail3);
        }
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
        birthInfo.setBirthDate(DateTimeUtil.xmlGregorianCalendar(form.getBirthDate()));
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
        agreement.setDate(DateTimeUtil.xmlGregorianCalendar(form.getAgreementDate()));
        agreement.setDateStart(DateTimeUtil.xmlGregorianCalendar(form.getAgreementDateStart()));
        agreement.setDateStop(DateTimeUtil.xmlGregorianCalendar(form.getAgreementDateStop()));
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
        brokerAgreement.setDate(DateTimeUtil.xmlGregorianCalendar(form.getBrokerAgreementDate()));
        brokerAgreement.setDateStart(DateTimeUtil.xmlGregorianCalendar(form.getBrokerAgreementDateStart()));
        brokerAgreement.setDateStop(DateTimeUtil.xmlGregorianCalendar(form.getBrokerAgreementDateStop()));
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

