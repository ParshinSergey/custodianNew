//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.02 at 09:35:26 PM MSK 
//


package dmt.custodian2016;

import java.math.BigInteger;
import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Тип заголовка транзакций. Ответ
 * 
 * <p>Java class for TTransactionHeader_responce complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TTransactionHeader_responce"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="OrderID" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="OrderIDYear" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="OrderDateRegistr" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="OrderDateCompleted" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="OperID" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="OperIDYear" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="Status" type="{urn:dmt:custodian2016}TStatus"/&gt;
 *         &lt;element name="Commission" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ParticipantSource" type="{urn:dmt:custodian2016}TTransactionCommission" minOccurs="0"/&gt;
 *                   &lt;element name="ParticipantDestination" type="{urn:dmt:custodian2016}TTransactionCommission" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
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
@XmlType(name = "TTransactionHeader_responce", propOrder = {
    "id",
    "orderID",
    "orderIDYear",
    "orderDateRegistr",
    "orderDateCompleted",
    "operID",
    "operIDYear",
    "status",
    "commission"
})
@XmlSeeAlso({
    TTransactionResponce.class
})
public class TTransactionHeaderResponce {

    @XmlElement(name = "ID", required = true)
    protected BigInteger id;
    @XmlElement(name = "OrderID")
    protected BigInteger orderID;
    @XmlElement(name = "OrderIDYear")
    protected BigInteger orderIDYear;
    @XmlElement(name = "OrderDateRegistr")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar orderDateRegistr;
    @XmlElement(name = "OrderDateCompleted")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar orderDateCompleted;
    @XmlElement(name = "OperID")
    protected BigInteger operID;
    @XmlElement(name = "OperIDYear")
    protected BigInteger operIDYear;
    @XmlElement(name = "Status", required = true)
    protected TStatus status;
    @XmlElement(name = "Commission")
    protected TTransactionHeaderResponce.Commission commission;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setID(BigInteger value) {
        this.id = value;
    }

    /**
     * Gets the value of the orderID property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOrderID() {
        return orderID;
    }

    /**
     * Sets the value of the orderID property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOrderID(BigInteger value) {
        this.orderID = value;
    }

    /**
     * Gets the value of the orderIDYear property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOrderIDYear() {
        return orderIDYear;
    }

    /**
     * Sets the value of the orderIDYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOrderIDYear(BigInteger value) {
        this.orderIDYear = value;
    }

    /**
     * Gets the value of the orderDateRegistr property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOrderDateRegistr() {
        return orderDateRegistr;
    }

    /**
     * Sets the value of the orderDateRegistr property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOrderDateRegistr(XMLGregorianCalendar value) {
        this.orderDateRegistr = value;
    }

    /**
     * Gets the value of the orderDateCompleted property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOrderDateCompleted() {
        return orderDateCompleted;
    }

    /**
     * Sets the value of the orderDateCompleted property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOrderDateCompleted(XMLGregorianCalendar value) {
        this.orderDateCompleted = value;
    }

    /**
     * Gets the value of the operID property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOperID() {
        return operID;
    }

    /**
     * Sets the value of the operID property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOperID(BigInteger value) {
        this.operID = value;
    }

    /**
     * Gets the value of the operIDYear property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOperIDYear() {
        return operIDYear;
    }

    /**
     * Sets the value of the operIDYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOperIDYear(BigInteger value) {
        this.operIDYear = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link TStatus }
     *     
     */
    public TStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link TStatus }
     *     
     */
    public void setStatus(TStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the commission property.
     * 
     * @return
     *     possible object is
     *     {@link TTransactionHeaderResponce.Commission }
     *     
     */
    public TTransactionHeaderResponce.Commission getCommission() {
        return commission;
    }

    /**
     * Sets the value of the commission property.
     * 
     * @param value
     *     allowed object is
     *     {@link TTransactionHeaderResponce.Commission }
     *     
     */
    public void setCommission(TTransactionHeaderResponce.Commission value) {
        this.commission = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="ParticipantSource" type="{urn:dmt:custodian2016}TTransactionCommission" minOccurs="0"/&gt;
     *         &lt;element name="ParticipantDestination" type="{urn:dmt:custodian2016}TTransactionCommission" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "participantSource",
        "participantDestination"
    })
    public static class Commission {

        @XmlElement(name = "ParticipantSource")
        protected TTransactionCommission participantSource;
        @XmlElement(name = "ParticipantDestination")
        protected TTransactionCommission participantDestination;

        /**
         * Gets the value of the participantSource property.
         * 
         * @return
         *     possible object is
         *     {@link TTransactionCommission }
         *     
         */
        public TTransactionCommission getParticipantSource() {
            return participantSource;
        }

        /**
         * Sets the value of the participantSource property.
         * 
         * @param value
         *     allowed object is
         *     {@link TTransactionCommission }
         *     
         */
        public void setParticipantSource(TTransactionCommission value) {
            this.participantSource = value;
        }

        /**
         * Gets the value of the participantDestination property.
         * 
         * @return
         *     possible object is
         *     {@link TTransactionCommission }
         *     
         */
        public TTransactionCommission getParticipantDestination() {
            return participantDestination;
        }

        /**
         * Sets the value of the participantDestination property.
         * 
         * @param value
         *     allowed object is
         *     {@link TTransactionCommission }
         *     
         */
        public void setParticipantDestination(TTransactionCommission value) {
            this.participantDestination = value;
        }

    }

}
