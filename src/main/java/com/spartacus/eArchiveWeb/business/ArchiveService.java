package com.spartacus.eArchiveWeb.business;


import com.spartacus.eArchiveWeb.dao.ArchiveDao;
import com.spartacus.eArchiveWeb.soap.Integration10Soap;
import com.spartacus.eArchiveWeb.soapUtil.SoapClient;
import com.spartacus.eArchiveWeb.soapUtil.UserTokenGenerator;
import com.spartacus.eArchiveWeb.soapUtil.Util;
import com.spartacus.eArchiveWeb.xmlIO.XmlIO;
import com.sun.xml.ws.fault.ServerSOAPFaultException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ArchiveService {
    private final ArchiveDao dao;
    @Value("${recv.path}")
    private  String RECV_PATH;
    public ArchiveService(ArchiveDao archiveDao){
        this.dao = archiveDao;
    }
    public String getEArchiveStatus() {
        String userToken = UserTokenGenerator.generateUserToken();
        List<String> uuids = dao.getInvoice();
        for(int i = 0; i<uuids.size(); i++){
            try {
                fetchArchive(uuids.get(i), userToken);
                System.out.println("INFO: (StatusFetcher.fetch) Arşiv Dosyası Alındı Database'e Ve Dosya Sistemine Kaydedildi.");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("IMPORTANT WARNING: (StatusFetcher.fetch) XML DOSYA ALINDI AMA DİSKE YAZILAMADI. DATABASE'DE DEĞİŞİKLİK YAPILMADIĞINDAN SONRAKİ ÇALIŞTIRMADA İŞLEM TEKRAR DENENECEK!! UUID : " + uuids.get(i));
            }
        }
        return null;
    }

    public void fetchArchive(String uuid, String userToken) throws IOException {
        Integration10Soap client = SoapClient.getClient();
        String xmlArchive = "";
        try{
            xmlArchive = client.getCommonDocumentSignedXmlByUUID(userToken, uuid);
            System.out.println("INFO: (StatusFetcher.fetch.fetchArchive) Xml E Arşiv Fatura Softnet api üzerinden başarıyla alındı. UUID: " + uuid);
            String path = RECV_PATH;
            String fileName = uuid + ".xml";
            System.out.println("path: " + path + "fileName: " + fileName);
            XmlIO.writeXml(xmlArchive, path, fileName);
            System.out.println("INFO: (StatusFetcher.fetch.fetchArchive) Xml E Arşiv Fatura Dosyaya Başarıyla Yazıldı. UUID: "+ uuid);
            dao.setEnd("K", 9001, uuid);
        }catch (ServerSOAPFaultException e){
            System.out.println("ERROR (StatusFetcher.fetch.fetchArchive) SOFTNET APİ ÜZERİNDEN FATURA İNDİRİLEMEDİ. (UUID: " + uuid + " )");
            System.out.println("Error message is: " + e.getMessage());
            int  errorCode = Util.getErrorCodeFromMessage(e.getMessage());
            dao.setHalt("H", e.getMessage(), errorCode, uuid);
        }

    }


}
