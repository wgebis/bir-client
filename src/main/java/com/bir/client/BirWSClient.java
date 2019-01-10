package com.bir.client;

import com.bir.wsdl.*;
import lombok.Data;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.axiom.AxiomSoapMessage;
import org.springframework.ws.soap.axiom.AxiomSoapMessageFactory;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.ws.transport.WebServiceMessageSender;
import org.springframework.ws.transport.context.TransportContext;
import org.springframework.ws.transport.context.TransportContextHolder;
import org.springframework.ws.transport.http.HttpComponentsConnection;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import javax.xml.namespace.QName;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
@Data
public class BirWSClient extends WebServiceGatewaySupport {

    private String url;
    private String userKey;

    public BirWSClient(@Value("${bir.url}") String url, @Value("${bir.key}") String key, Jaxb2Marshaller marshaller, AxiomSoapMessageFactory axiomSoapMessageFactory, WebServiceMessageSender webServiceMessageSender) {

        this.url = url;
        this.userKey = key;

        this.setDefaultUri(url);
        this.setMarshaller(marshaller);
        this.setUnmarshaller(marshaller);

        this.getWebServiceTemplate().setMessageFactory(axiomSoapMessageFactory);
        this.getWebServiceTemplate().setMessageSender(webServiceMessageSender);
    }

    public String login() {

        Zaloguj zaloguj = new Zaloguj();
        zaloguj.setPKluczUzytkownika(userKey);

        ZalogujResponse zr = (ZalogujResponse) getWebServiceTemplate().marshalSendAndReceive(zaloguj,
                createActionCallback("http://CIS/BIR/PUBL/2014/07/IUslugaBIRzewnPubl/Zaloguj"));

        return zr.getZalogujResult();
    }

    public String search(String nip, String sid) {

        DaneSzukaj daneSzukaj = new DaneSzukaj();
        ParametryWyszukiwania pw = new ParametryWyszukiwania();
        pw.setNip(nip);
        daneSzukaj.setPParametryWyszukiwania(pw);

        DaneSzukajResponse dr = (DaneSzukajResponse) getWebServiceTemplate().marshalSendAndReceive(daneSzukaj,
                createActionCallback("http://CIS/BIR/PUBL/2014/07/IUslugaBIRzewnPubl/DaneSzukaj", sid));

        return dr.getDaneSzukajResult();
    }

    public boolean logout(String sid) {

        Wyloguj wyloguj = new Wyloguj();
        wyloguj.setPIdentyfikatorSesji(sid);

        WylogujResponse wr = (WylogujResponse) getWebServiceTemplate().marshalSendAndReceive(wyloguj,
                createActionCallback("http://CIS/BIR/PUBL/2014/07/IUslugaBIRzewnPubl/Wyloguj"));

        return wr.isWylogujResult();
    }

    private SoapActionCallback createActionCallback(String action) {
        return createActionCallback(action, null);
    }

    private SoapActionCallback createActionCallback(String action, @Nullable String sid) {
        return new SoapActionCallback(action) {
            public void doWithMessage(WebServiceMessage message) {
                AxiomSoapMessage soapMessage = (AxiomSoapMessage) message;
                SoapHeader soapHeader = soapMessage.getSoapHeader();

                SoapHeaderElement wsaTo =  soapHeader.addHeaderElement(new QName("http://www.w3.org/2005/08/addressing", "To", "wsa"));
                wsaTo.setText(url);

                SoapHeaderElement wsaAction =  soapHeader.addHeaderElement(new QName("http://www.w3.org/2005/08/addressing", "Action", "wsa"));
                wsaAction.setText(action);

                if (sid != null) {
                    TransportContext context = TransportContextHolder.getTransportContext();
                    HttpComponentsConnection connection = (HttpComponentsConnection) context.getConnection();
                    try {
                        connection.addRequestHeader( "sid", sid);
                    } catch (IOException e) {
                        log.error("Unable to add sid header");
                    }
                }
            }
        };
    }
}