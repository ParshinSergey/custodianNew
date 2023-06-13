package ua.univer.custodianNew.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import javax.xml.datatype.XMLGregorianCalendar;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FormFO {

    private String requestID;
    private String nssmcClientTypeCode;

    private Integer customerID;
    private String cnum;
    @NotBlank
    private String country;
    private String countryTax;
    @NotBlank
    private String idCode;
    @NotBlank
    private String clientTypeCode;
    @NotBlank
    private String shortName;
    private String longName;

    private String addressType;
    private String countryAdr;
    private String postIndex;
    private String region;
    private String district;
    private String locality;
    private String street;
    private String house;
    private String flat;
    private String addressFree;

    private String docSerial;
    private String docNumber;
    private String docDate;
    private String docWho;
    private String docType;
    private String docDateStart;
    private String docDateStop;
    private String docSDRnumber;

    @Size(min = 6, max = 6)
    private String mfo;
    @Size(max = 34)
    private String iban;
    @Size(max = 50)
    private String cardAccount;
    @Size(max = 80)
    private String bankName;
    @NotBlank
    private String currency;
    @Size(max = 14)
    private String bic;
    @Size(max = 20)
    private String lei;
    private Integer bankDetailID;
    private boolean use4Income;
    private Integer type;

    private String phone;
    private String mobilePhone;
    @Email
    private String eMailGeneral;
    private XMLGregorianCalendar birthDate;
    private String birthPlace;
    private boolean refusingCode;

    private String agreementNumber;
    private XMLGregorianCalendar agreementDate;
    private XMLGregorianCalendar agreementDateStart;
    private XMLGregorianCalendar agreementDateStop;
    private Integer agrID;

    public FormFO() {
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public String getNssmcClientTypeCode() {
        return nssmcClientTypeCode;
    }

    public void setNssmcClientTypeCode(String nssmcClientTypeCode) {
        this.nssmcClientTypeCode = nssmcClientTypeCode;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getCnum() {
        return cnum;
    }

    public void setCnum(String cnum) {
        this.cnum = cnum;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryTax() {
        return countryTax;
    }

    public void setCountryTax(String countryTax) {
        this.countryTax = countryTax;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getClientTypeCode() {
        return clientTypeCode;
    }

    public void setClientTypeCode(String clientTypeCode) {
        this.clientTypeCode = clientTypeCode;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getCountryAdr() {
        return countryAdr;
    }

    public void setCountryAdr(String countryAdr) {
        this.countryAdr = countryAdr;
    }

    public String getPostIndex() {
        return postIndex;
    }

    public void setPostIndex(String postIndex) {
        this.postIndex = postIndex;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getAddressFree() {
        return addressFree;
    }

    public void setAddressFree(String addressFree) {
        this.addressFree = addressFree;
    }

    public String getDocSerial() {
        return docSerial;
    }

    public void setDocSerial(String docSerial) {
        this.docSerial = docSerial;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public String getDocWho() {
        return docWho;
    }

    public void setDocWho(String docWho) {
        this.docWho = docWho;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDocDateStart() {
        return docDateStart;
    }

    public void setDocDateStart(String docDateStart) {
        this.docDateStart = docDateStart;
    }

    public String getDocDateStop() {
        return docDateStop;
    }

    public void setDocDateStop(String docDateStop) {
        this.docDateStop = docDateStop;
    }

    public String getDocSDRnumber() {
        return docSDRnumber;
    }

    public void setDocSDRnumber(String docSDRnumber) {
        this.docSDRnumber = docSDRnumber;
    }

    public String getMfo() {
        return mfo;
    }

    public void setMfo(String mfo) {
        this.mfo = mfo;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getCardAccount() {
        return cardAccount;
    }

    public void setCardAccount(String cardAccount) {
        this.cardAccount = cardAccount;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getLei() {
        return lei;
    }

    public void setLei(String lei) {
        this.lei = lei;
    }

    public Integer getBankDetailID() {
        return bankDetailID;
    }

    public void setBankDetailID(Integer bankDetailID) {
        this.bankDetailID = bankDetailID;
    }

    public boolean isUse4Income() {
        return use4Income;
    }

    public void setUse4Income(boolean use4Income) {
        this.use4Income = use4Income;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String geteMailGeneral() {
        return eMailGeneral;
    }

    public void seteMailGeneral(String eMailGeneral) {
        this.eMailGeneral = eMailGeneral;
    }

    public XMLGregorianCalendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(XMLGregorianCalendar birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public boolean isRefusingCode() {
        return refusingCode;
    }

    public void setRefusingCode(boolean refusingCode) {
        this.refusingCode = refusingCode;
    }

    public String getAgreementNumber() {
        return agreementNumber;
    }

    public void setAgreementNumber(String agreementNumber) {
        this.agreementNumber = agreementNumber;
    }

    public XMLGregorianCalendar getAgreementDate() {
        return agreementDate;
    }

    public void setAgreementDate(XMLGregorianCalendar agreementDate) {
        this.agreementDate = agreementDate;
    }

    public XMLGregorianCalendar getAgreementDateStart() {
        return agreementDateStart;
    }

    public void setAgreementDateStart(XMLGregorianCalendar agreementDateStart) {
        this.agreementDateStart = agreementDateStart;
    }

    public XMLGregorianCalendar getAgreementDateStop() {
        return agreementDateStop;
    }

    public void setAgreementDateStop(XMLGregorianCalendar agreementDateStop) {
        this.agreementDateStop = agreementDateStop;
    }

    public Integer getAgrID() {
        return agrID;
    }

    public void setAgrID(Integer agrID) {
        this.agrID = agrID;
    }
}
