//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.05.02 at 09:35:26 PM MSK 
//


package dmt.custodian2016;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TAddressType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="TAddressType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="legal"/&gt;
 *     &lt;enumeration value="post"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TAddressType")
@XmlEnum
public enum TAddressType {


    /**
     * Юридический адрес для юридических лиц/Адрес регистрации для физических лиц
     * 
     */
    @XmlEnumValue("legal")
    LEGAL("legal"),

    /**
     * Почтовый адрес
     * 
     */
    @XmlEnumValue("post")
    POST("post"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    TAddressType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TAddressType fromValue(String v) {
        for (TAddressType c: TAddressType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
