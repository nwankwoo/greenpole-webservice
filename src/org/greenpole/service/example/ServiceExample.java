/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.service.example;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import org.greenpole.entity.model.Address;
import org.greenpole.entity.model.EmailAddress;
import org.greenpole.entity.model.PhoneNumber;
import org.greenpole.entity.model.clientcompany.ClientCompany;
import org.greenpole.entity.response.Response;
import org.greenpole.entity.security.Login;
import org.greenpole.service.ClientCompanyComponentService;

/**
 *
 * @author Akinwale Agbaje
 */
public class ServiceExample {
    
    public void example() throws MalformedURLException {
        //===============================
        URL url = new URL("http://localhost:7001/greenpole-engine/clientcompanyservice?wsdl");
        QName qname = new QName("http://service.greenpole.org/", "clientcompanyservice");
        
        Service service = Service.create(url, qname);
        ClientCompanyComponentService port = service.getPort(ClientCompanyComponentService.class);
        //===============================
        
        
        Login login = new Login("akinwale.agbaje@africaprudentialregistrars.com",
        "");
        Address addy = new Address();
        PhoneNumber phone = new PhoneNumber();
        EmailAddress email = new EmailAddress();
        ClientCompany cc = new ClientCompany();
        
        addy.setAddressLine1("28 community road");
        addy.setAddressLine2("Satellite Town");
        addy.setCity("Lagos");
        addy.setState("Lagos");
        addy.setCountry("Nigeria");
        addy.setPrimaryAddress(true);
        List<Address> addylist = new ArrayList<>();
        addylist.add(addy);
        
        phone.setPhoneNumber("07084534567");
        phone.setPrimaryPhoneNumber(true);
        List<PhoneNumber> phonelist = new ArrayList<>();
        phonelist.add(phone);
        
        email.setEmailAddress("johntom@yahoo.com");
        email.setPrimaryEmail(true);
        List<EmailAddress> emaillist = new ArrayList<>();
        emaillist.add(email);
        
        cc.setName("John & Sons PLC");
        cc.setCode("JS01");
        cc.setValid(true);
        cc.setNseSectorId(2);
        cc.setAddresses(addylist);
        cc.setPhoneNumbers(phonelist);
        cc.setEmailAddresses(emaillist);
        
        //=================================
        Response resp = port.createClientCompany_Request(login,
                "yusuf.samsudeen@africaprudentialregistrars.com",
                cc);
        //=================================
    }
    
    public static void main(String[] args) throws MalformedURLException {
        new ServiceExample().example();
    }
}
