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
 * handles output
 * @author margarita.dueck
 */
@ViewScoped
@Named("ttBasicView")
public class BasicView implements Serializable {
     
     private TreeNode root;
    
          
    private Contact selectedContact;
    
    @Inject
    private ContactService service;
    
    /**
     *init-Method
     */
    @PostConstruct
    public void init() {
        root = service.createContacts();
    }
    
    /**
     *
     * @return root
     */
    public TreeNode getRoot() {
        return root;
    }
 
    /**
     *
     * @param service
     */
    public void setService(ContactService service) {
        this.service = service;
    }
 
    /**
     *
     * @return selectedContact
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
