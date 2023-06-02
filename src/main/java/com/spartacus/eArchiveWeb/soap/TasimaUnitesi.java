
package com.spartacus.eArchiveWeb.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TasimaUnitesi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TasimaUnitesi"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DorsePlakalari" type="{http://www.netle.com.tr/EDonusum/OrtakFatura/Ver1.0/}ArrayOfString" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TasimaUnitesi", propOrder = {
    "dorsePlakalari"
})
public class TasimaUnitesi {

    @XmlElement(name = "DorsePlakalari")
    protected ArrayOfString dorsePlakalari;

    /**
     * Gets the value of the dorsePlakalari property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getDorsePlakalari() {
        return dorsePlakalari;
    }

    /**
     * Sets the value of the dorsePlakalari property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setDorsePlakalari(ArrayOfString value) {
        this.dorsePlakalari = value;
    }

}
