//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.01.10 at 02:54:44 PM CET 
//


package com.bir.wsdl;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import org.joda.time.DateTime;

public class Adapter1
    extends XmlAdapter<String, DateTime>
{


    public DateTime unmarshal(String value) {
        return (com.bir.utils.DateConverter.unmarshalDateTime(value));
    }

    public String marshal(DateTime value) {
        return (com.bir.utils.DateConverter.marshalDateTime(value));
    }

}