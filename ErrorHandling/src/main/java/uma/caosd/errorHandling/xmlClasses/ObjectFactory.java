//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.06.16 at 03:26:19 PM CEST 
//


package uma.caosd.errorHandling.xmlClasses;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the uma.caosd.errorHandling.xmlClasses package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Elements_QNAME = new QName("", "Elements");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: uma.caosd.errorHandling.xmlClasses
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Elements }
     * 
     */
    public Elements createElements() {
        return new Elements();
    }

    /**
     * Create an instance of {@link Param }
     * 
     */
    public Param createParam() {
        return new Param();
    }

    /**
     * Create an instance of {@link Alarms }
     * 
     */
    public Alarms createAlarms() {
        return new Alarms();
    }

    /**
     * Create an instance of {@link Params }
     * 
     */
    public Params createParams() {
        return new Params();
    }

    /**
     * Create an instance of {@link Element }
     * 
     */
    public Element createElement() {
        return new Element();
    }

    /**
     * Create an instance of {@link Alarm }
     * 
     */
    public Alarm createAlarm() {
        return new Alarm();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Elements }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Elements")
    public JAXBElement<Elements> createElements(Elements value) {
        return new JAXBElement<Elements>(_Elements_QNAME, Elements.class, null, value);
    }

}
