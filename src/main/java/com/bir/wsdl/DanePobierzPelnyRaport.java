//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.01.10 at 02:54:44 PM CET 
//


package com.bir.wsdl;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="pRegon" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="pNazwaRaportu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "pRegon",
    "pNazwaRaportu"
})
@XmlRootElement(name = "DanePobierzPelnyRaport")
public class DanePobierzPelnyRaport
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(nillable = true)
    protected String pRegon;
    @XmlElement(nillable = true)
    protected String pNazwaRaportu;

    /**
     * Gets the value of the pRegon property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRegon() {
        return pRegon;
    }

    /**
     * Sets the value of the pRegon property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRegon(String value) {
        this.pRegon = value;
    }

    /**
     * Gets the value of the pNazwaRaportu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPNazwaRaportu() {
        return pNazwaRaportu;
    }

    /**
     * Sets the value of the pNazwaRaportu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPNazwaRaportu(String value) {
        this.pNazwaRaportu = value;
    }

}
