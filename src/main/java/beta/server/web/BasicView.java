/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beta.server.web;


import beta.server.entity.Contact;
import java.io.Serializable;

import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.TreeNode;
import javax.annotation.PostConstruct;
import javax.inject.Inject;



/**
 *
 * @author margarita.dueck
 */
@ViewScoped
@Named("ttBasicView")
public class BasicView implements Serializable {
     
     private TreeNode root;
    
          
    private Contact selectedContact;
    
//    @ManagedProperty("#{contactService}")
    @Inject
    private ContactService service;
    
    @PostConstruct
    public void init() {
        root = service.createContacts();
    }
    
    public TreeNode getRoot() {
        return root;
    }
 
    public void setService(ContactService service) {
        this.service = service;
    }
 
    /**
     *
     * @return
     */
    public Contact getSelectedContact() {
        return selectedContact;
    }
 
    /**
     *
     * @param selectedContact
     */
    public void setSelectedContact(Contact selectedContact) {
        this.selectedContact = selectedContact;
    }
     
}
