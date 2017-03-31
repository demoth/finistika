//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.03.31 at 10:40:01 AM MSK 
//


package com.db.prisma.droolspoc.pain001;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PartyIdentification43 complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="PartyIdentification43">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Nm" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.08}Max140Text" minOccurs="0"/>
 *         &lt;element name="PstlAdr" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.08}PostalAddress6" minOccurs="0"/>
 *         &lt;element name="Id" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.08}Party11Choice" minOccurs="0"/>
 *         &lt;element name="CtryOfRes" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.08}CountryCode" minOccurs="0"/>
 *         &lt;element name="CtctDtls" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.08}ContactDetails2" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PartyIdentification43", propOrder = {
        "nm",
        "pstlAdr",
        "id",
        "ctryOfRes",
        "ctctDtls"
})
public class PartyIdentification43 {

    @XmlElement(name = "Nm")
    private String nm;
    @XmlElement(name = "PstlAdr")
    private PostalAddress6 pstlAdr;
    @XmlElement(name = "Id")
    private Party11Choice id;
    @XmlElement(name = "CtryOfRes")
    private String ctryOfRes;
    @XmlElement(name = "CtctDtls")
    private ContactDetails2 ctctDtls;

    /**
     * Gets the value of the nm property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNm() {
        return nm;
    }

    /**
     * Sets the value of the nm property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNm(String value) {
        this.nm = value;
    }

    /**
     * Gets the value of the pstlAdr property.
     *
     * @return possible object is
     * {@link PostalAddress6 }
     */
    public PostalAddress6 getPstlAdr() {
        return pstlAdr;
    }

    /**
     * Sets the value of the pstlAdr property.
     *
     * @param value allowed object is
     *              {@link PostalAddress6 }
     */
    public void setPstlAdr(PostalAddress6 value) {
        this.pstlAdr = value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return possible object is
     * {@link Party11Choice }
     */
    public Party11Choice getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is
     *              {@link Party11Choice }
     */
    public void setId(Party11Choice value) {
        this.id = value;
    }

    /**
     * Gets the value of the ctryOfRes property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCtryOfRes() {
        return ctryOfRes;
    }

    /**
     * Sets the value of the ctryOfRes property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCtryOfRes(String value) {
        this.ctryOfRes = value;
    }

    /**
     * Gets the value of the ctctDtls property.
     *
     * @return possible object is
     * {@link ContactDetails2 }
     */
    public ContactDetails2 getCtctDtls() {
        return ctctDtls;
    }

    /**
     * Sets the value of the ctctDtls property.
     *
     * @param value allowed object is
     *              {@link ContactDetails2 }
     */
    public void setCtctDtls(ContactDetails2 value) {
        this.ctctDtls = value;
    }

}
