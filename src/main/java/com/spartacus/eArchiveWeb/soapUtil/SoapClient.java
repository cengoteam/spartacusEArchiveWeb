package com.spartacus.eArchiveWeb.soapUtil;


import com.spartacus.eArchiveWeb.soap.Integration10;
import com.spartacus.eArchiveWeb.soap.Integration10Soap;

public class SoapClient {
    private static Integration10Soap instance;

    public static Integration10Soap getClient() {
        if(instance==null) {
            instance = getNewClient();
        }
        return instance;
    }
    public static Integration10Soap getNewClient() {
        Integration10 client = new Integration10();
        Integration10Soap integration10Soap = client.getIntegration10Soap();
        return integration10Soap;


    }
}