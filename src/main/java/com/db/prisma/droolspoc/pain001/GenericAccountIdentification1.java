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
 * <p>Java class for GenericAccountIdentification1 complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="GenericAccountIdentification1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.08}Max34Text"/>
 *         &lt;element name="SchmeNm" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.08}AccountSchemeName1Choice" minOccurs="0"/>
 *         &lt;element name="Issr" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.08}Max35Text" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GenericAccountIdentification1", propOrder = {
        "id",
        "schmeNm",
        "issr"
})
public class GenericAccountIdentification1 {

    @XmlElement(name = "Id", required = true)
    private String id;
    @XmlElement(name = "SchmeNm")
    private AccountSchemeName1Choice schmeNm;
    @XmlElement(name = "Issr")
    private String issr;

    /**
     * Gets the value of the id property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the schmeNm property.
     *
     * @return possible object is
     * {@link AccountSchemeName1Choice }
     */
    public AccountSchemeName1Choice getSchmeNm() {
        return schmeNm;
    }

    /**
     * Sets the value of the schmeNm property.
     *
     * @param value allowed object is
     *              {@link AccountSchemeName1Choice }
     */
    public void setSchmeNm(AccountSchemeName1Choice value) {
        this.schmeNm = value;
    }

    /**
     * Gets the value of the issr property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getIssr() {
        return issr;
    }

    /**
     * Sets the value of the issr property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setIssr(String value) {
        this.issr = value;
    }

}
