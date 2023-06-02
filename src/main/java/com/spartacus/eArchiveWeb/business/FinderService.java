package com.spartacus.eArchiveWeb.business;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.Base64;

@Service
public class FinderService {
    public String findInvoice(String envelopeId, String envelopeFile, String recv_path) throws TransformerConfigurationException, IOException, SAXException, ParserConfigurationException {
        FileInputStream fis = new FileInputStream(envelopeFile);
        byte[] data = new byte[(int)envelopeFile.length()];
        fis.read(data);
        fis.close();

        String file_content = new String(data, "UTF-8");
        String sil = get_string_between(file_content, "<cbc:EmbeddedDocumentBinaryObject", ">");
        file_content = file_content.replace(sil, "");
        String xslt_str = get_string_between(file_content, "<cbc:EmbeddedDocumentBinaryObject>", "</cbc:EmbeddedDocumentBinaryObject>");
        byte[] xslt_data = Base64.getDecoder().decode(xslt_str);
        String sil2 = get_string_between(file_content, "<cbc:EmbeddedDocumentBinaryObject>", "</cbc:EmbeddedDocumentBinaryObject>");
        file_content = file_content.replace(sil2, "");

        String invoice_xml_file = path + zarf_id + "_fatura.xml";
        String invoice_xslt_file = path + zarf_id + "_xslt.xslt";
        FileOutputStream fos1 = new FileOutputStream(invoice_xml_file);
        fos1.write(file_content.getBytes());
        fos1.close();
        FileOutputStream fos2 = new FileOutputStream(invoice_xslt_file);
        fos2.write(xslt_data);
        fos2.close();

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document xml = db.parse(new File(invoice_xml_file));
        Document xslt = db.parse(new File(invoice_xslt_file));
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer(new DOMSource(xslt));
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(xml), new StreamResult(writer));
        String rtrn = writer.toString();

        new File(invoice_xml_file).delete();
        new File(invoice_xslt_file).delete();
        return rtrn;
        return null;
    }

    public String get_string_between(String str, String start, String end){

    }
}
