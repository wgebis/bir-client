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
 *         &lt;element name="pNazwaParametru" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
    "pNazwaParametru"
})
@XmlRootElement(name = "GetValue", namespace = "http://CIS/BIR/2014/07")
public class GetValue
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(namespace = "http://CIS/BIR/2014/07", nillable = true)
    protected String pNazwaParametru;

    /**
     * Gets the value of the pNazwaParametru property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPNazwaParametru() {
        return pNazwaParametru;
    }

    /**
     * Sets the value of the pNazwaParametru property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPNazwaParametru(String value) {
        this.pNazwaParametru = value;
    }

}
