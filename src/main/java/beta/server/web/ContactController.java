/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beta.server.web;

import beta.server.eao.ContactEao;
import beta.server.entity.Contact;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;





/**
 *
 * @author margarita.dueck
 */
@Named
@ViewScoped
public class ContactController implements Serializable{
  
    @Inject
    ContactEao contactEao;
    private List<Contact> contactList;

    /**
     *
     * @return contactList
     */
    public List<Contact> getContactList() {
        return contactList;
    }
    
    
    @PostConstruct
    private void contactControllerInit (){
        this.contactList = contactEao.findAll();
    }

    /**
     *Collect all zip codes from contact
     * html break for a line break
     * @param contact
     * @return
     */
    public String zipCode(Contact contact){
        return contact.getAddresses()
                .stream()
                .map(add -> add.getZipCode())
                .collect(Collectors.joining("</br>"));
    }
    
    /**
     * Collect all cities from contact
     * html break for a line break
     * @param contact
     * @return
     */
    public String city(Contact contact){
        return contact.getAddresses()
                .stream()
                .map(add -> add.getCity())
                .collect(Collectors.joining("</br>"));
    }
    
    /**
     *Collect all streets from contact
     * html break for a line break
     * @param contact
     * @return
     */
    public String street(Contact contact){
        return contact.getAddresses()
                .stream()
                .map(add -> add.getStreet())
                .collect(Collectors.joining("</br>"));
    }
    
    /**
     *Collect all countries from contact
     * html break for a line break
     * @param contact
     * @return
     */
    public String country(Contact contact){
        return contact.getAddresses()
                .stream()
                .map(add -> add.getCountry().getCountryName())
                .collect(Collectors.joining("</br>"));
    }
    
    public String communication(Contact contact){
        return contact.getCommunications()
                .stream()
                .map(com -> com.getType() + ": " +com.getIdentifier())
                .collect(Collectors.joining("</br>"));
    }
   
}
