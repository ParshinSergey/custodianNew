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
 * Результат поиска клиентов (V2)
 * 
 * <p>Java class for TAccountListV2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TAccountListV2"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Rows" type="{urn:dmt:custodian2016}TAccountListV2_abstract"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TAccountListV2", propOrder = {
    "rows"
})
public class TAccountListV2 {

    @XmlElement(name = "Rows", required = true)
    protected TAccountListV2Abstract rows;

    /**
     * Gets the value of the rows property.
     * 
     * @return
     *     possible object is
     *     {@link TAccountListV2Abstract }
     *     
     */
    public TAccountListV2Abstract getRows() {
        return rows;
    }

    /**
     * Sets the value of the rows property.
     * 
     * @param value
     *     allowed object is
     *     {@link TAccountListV2Abstract }
     *     
     */
    public void setRows(TAccountListV2Abstract value) {
        this.rows = value;
    }

}
