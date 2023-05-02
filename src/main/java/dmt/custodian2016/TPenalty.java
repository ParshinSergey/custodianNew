//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.02 at 09:35:26 PM MSK 
//


package dmt.custodian2016;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Пеня по одному клиенту
 * 
 * <p>Java class for TPenalty complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TPenalty"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="Account" type="{urn:dmt:custodian2016}TAccount_Num"/&gt;
 *           &lt;element name="idCode" type="{urn:dmt:custodian2016}TIDCode"/&gt;
 *           &lt;element name="CNUM"&gt;
 *             &lt;simpleType&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                 &lt;maxLength value="100"/&gt;
 *               &lt;/restriction&gt;
 *             &lt;/simpleType&gt;
 *           &lt;/element&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="Cost" type="{urn:dmt:custodian2016}TCost"/&gt;
 *         &lt;element name="PenaltyType"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="FINE"/&gt;
 *               &lt;enumeration value="PENALTY"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="PenaltyPeriod"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="PREVIOUS"/&gt;
 *               &lt;enumeration value="CURRENT"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TPenalty", propOrder = {
    "account",
    "idCode",
    "cnum",
    "cost",
    "penaltyType",
    "penaltyPeriod"
})
public class TPenalty {

    @XmlElement(name = "Account")
    protected String account;
    protected String idCode;
    @XmlElement(name = "CNUM")
    protected String cnum;
    @XmlElement(name = "Cost", required = true)
    protected TCost cost;
    @XmlElement(name = "PenaltyType", required = true)
    protected String penaltyType;
    @XmlElement(name = "PenaltyPeriod", required = true)
    protected String penaltyPeriod;

    /**
     * Gets the value of the account property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccount() {
        return account;
    }

    /**
     * Sets the value of the account property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccount(String value) {
        this.account = value;
    }

    /**
     * Gets the value of the idCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdCode() {
        return idCode;
    }

    /**
     * Sets the value of the idCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdCode(String value) {
        this.idCode = value;
    }

    /**
     * Gets the value of the cnum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCNUM() {
        return cnum;
    }

    /**
     * Sets the value of the cnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCNUM(String value) {
        this.cnum = value;
    }

    /**
     * Gets the value of the cost property.
     * 
     * @return
     *     possible object is
     *     {@link TCost }
     *     
     */
    public TCost getCost() {
        return cost;
    }

    /**
     * Sets the value of the cost property.
     * 
     * @param value
     *     allowed object is
     *     {@link TCost }
     *     
     */
    public void setCost(TCost value) {
        this.cost = value;
    }

    /**
     * Gets the value of the penaltyType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPenaltyType() {
        return penaltyType;
    }

    /**
     * Sets the value of the penaltyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPenaltyType(String value) {
        this.penaltyType = value;
    }

    /**
     * Gets the value of the penaltyPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPenaltyPeriod() {
        return penaltyPeriod;
    }

    /**
     * Sets the value of the penaltyPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPenaltyPeriod(String value) {
        this.penaltyPeriod = value;
    }

}
