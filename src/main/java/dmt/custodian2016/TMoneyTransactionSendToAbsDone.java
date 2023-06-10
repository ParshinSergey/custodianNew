//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.02 at 09:35:26 PM MSK 
//


package dmt.custodian2016;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Псевдотип. Используется только в методе установки информации о передаче денежной транзакции в АБС. Может не использоваться при обмене если внешняя система самостоятельно отслеживает факт загрузки транзакции.Запрос содержит список денежных транзакций загруженых в АБС. Дата загрузки в ПО "Хранитель 2016" всегда будет датой и временем обработки этого запроса
 * 
 * <p>Java class for TMoneyTransaction_send_to_abs_Done complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TMoneyTransaction_send_to_abs_Done"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence maxOccurs="unbounded"&gt;
 *         &lt;element name="TranID" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TMoneyTransaction_send_to_abs_Done", propOrder = {
    "tranID"
})
public class TMoneyTransactionSendToAbsDone {

    @XmlElement(name = "TranID", required = true)
    protected List<BigInteger> tranID;

    /**
     * Gets the value of the tranID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the tranID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTranID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BigInteger }
     * 
     * 
     */
    public List<BigInteger> getTranID() {
        if (tranID == null) {
            tranID = new ArrayList<BigInteger>();
        }
        return this.tranID;
    }

}