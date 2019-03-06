/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beta.server.web.editTable;

import beta.server.eao.ContactEao;
import beta.server.entity.Address;
import beta.server.entity.Communication;
import beta.server.entity.Communication.Type;
import beta.server.entity.Contact;
import beta.server.entity.Country;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.CheckboxTreeNode;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 * access the the database
 * creates the treeTable
 * @author margarita.dueck
 */
@Stateless
@Named("contactService")
public class ContactServiceETT implements Serializable {

    @Inject
    private ContactEao cEao;



    private TreeNode root;

    private List<Contact> contactList;
   
    //Arrays for Dropdown
    private Type[] types;
    private Country[] countries; 
    
    /**
     * creates a CheckboxTreeNodes with contacts 
     * @return
     */
    public TreeNode createCheckboxContacts() {
        contactList = cEao.findAll();

        this.root = new CheckboxTreeNode(" ", null);
        
        for (int i = 0; i < contactList.size(); i++) {
            //Names
            TreeNode name = new CheckboxTreeNode("contact", contactList.get(i), root);
            
            //Description
            TreeNode communication = new CheckboxTreeNode("description","Communications", name);
            TreeNode address = new CheckboxTreeNode("description","Adresses", name);
            
            //Communication
            for (Communication comm : contactList.get(i).getCommunications()){
               new CheckboxTreeNode("communication",comm, communication);
            }
            //Adresses
            for (Address add : contactList.get(i).getAddresses()) {
                new CheckboxTreeNode("address",add, address);
            }
        }
        
        return root;

    }
    
    /**
     * init-Method for:
     *  - root
     *  - types[]
     *  - countries[]
     */
    @PostConstruct
    public void init() {
        this.root = createCheckboxContacts();

        //type
        types = Type.values();
        
        //country
        countries = Country.values();
    }

    public TreeNode getRoot() {
        return root;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public Type[] getType() {
        return types;
    }

    public Country[] getCountries() {
        return countries;
    }

}
