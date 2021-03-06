//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.03.31 at 10:40:01 AM MSK 
//


package com.db.prisma.droolspoc.pain001;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for GroupHeader48 complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="GroupHeader48">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MsgId" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.08}Max35Text"/>
 *         &lt;element name="CreDtTm" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.08}ISODateTime"/>
 *         &lt;element name="Authstn" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.08}Authorisation1Choice" maxOccurs="2" minOccurs="0"/>
 *         &lt;element name="NbOfTxs" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.08}Max15NumericText"/>
 *         &lt;element name="CtrlSum" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.08}DecimalNumber" minOccurs="0"/>
 *         &lt;element name="InitgPty" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.08}PartyIdentification43"/>
 *         &lt;element name="FwdgAgt" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.08}BranchAndFinancialInstitutionIdentification5" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GroupHeader48", propOrder = {
        "msgId",
        "creDtTm",
        "authstn",
        "nbOfTxs",
        "ctrlSum",
        "initgPty",
        "fwdgAgt"
})
public class GroupHeader48 {

    @XmlElement(name = "MsgId", required = true)
    private String msgId;
    @XmlElement(name = "CreDtTm", required = true)
    @XmlSchemaType(name = "dateTime")
    private XMLGregorianCalendar creDtTm;
    @XmlElement(name = "Authstn")
    private List<Authorisation1Choice> authstn;
    @XmlElement(name = "NbOfTxs", required = true)
    private String nbOfTxs;
    @XmlElement(name = "CtrlSum")
    private BigDecimal ctrlSum;
    @XmlElement(name = "InitgPty", required = true)
    private PartyIdentification43 initgPty;
    @XmlElement(name = "FwdgAgt")
    private BranchAndFinancialInstitutionIdentification5 fwdgAgt;

    /**
     * Gets the value of the msgId property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getMsgId() {
        return msgId;
    }

    /**
     * Sets the value of the msgId property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMsgId(String value) {
        this.msgId = value;
    }

    /**
     * Gets the value of the creDtTm property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getCreDtTm() {
        return creDtTm;
    }

    /**
     * Sets the value of the creDtTm property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setCreDtTm(XMLGregorianCalendar value) {
        this.creDtTm = value;
    }

    /**
     * Gets the value of the authstn property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the authstn property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAuthstn().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Authorisation1Choice }
     */
    public List<Authorisation1Choice> getAuthstn() {
        if (authstn == null) {
            authstn = new ArrayList<Authorisation1Choice>();
        }
        return this.authstn;
    }

    /**
     * Gets the value of the nbOfTxs property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNbOfTxs() {
        return nbOfTxs;
    }

    /**
     * Sets the value of the nbOfTxs property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNbOfTxs(String value) {
        this.nbOfTxs = value;
    }

    /**
     * Gets the value of the ctrlSum property.
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    public BigDecimal getCtrlSum() {
        return ctrlSum;
    }

    /**
     * Sets the value of the ctrlSum property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setCtrlSum(BigDecimal value) {
        this.ctrlSum = value;
    }

    /**
     * Gets the value of the initgPty property.
     *
     * @return possible object is
     * {@link PartyIdentification43 }
     */
    public PartyIdentification43 getInitgPty() {
        return initgPty;
    }

    /**
     * Sets the value of the initgPty property.
     *
     * @param value allowed object is
     *              {@link PartyIdentification43 }
     */
    public void setInitgPty(PartyIdentification43 value) {
        this.initgPty = value;
    }

    /**
     * Gets the value of the fwdgAgt property.
     *
     * @return possible object is
     * {@link BranchAndFinancialInstitutionIdentification5 }
     */
    public BranchAndFinancialInstitutionIdentification5 getFwdgAgt() {
        return fwdgAgt;
    }

    /**
     * Sets the value of the fwdgAgt property.
     *
     * @param value allowed object is
     *              {@link BranchAndFinancialInstitutionIdentification5 }
     */
    public void setFwdgAgt(BranchAndFinancialInstitutionIdentification5 value) {
        this.fwdgAgt = value;
    }

}
