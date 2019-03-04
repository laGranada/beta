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

    @Inject
    private Contact contact;

    private TreeNode root;

    private List<Contact> contactList;
   
    private Type[] types;
    private Country[] countries; 
    
    /**
     * creates a CheckboxTreeNodes with contacts 
     * @return
     */
    public TreeNode createCheckboxContacts() {
        contactList = cEao.findAll(0, 10);

        this.root = new CheckboxTreeNode(contact, null);
        
        for (int i = 0; i < contactList.size(); i++) {
            TreeNode name = new CheckboxTreeNode("contact", contactList.get(i), root);
            
            TreeNode communication = new CheckboxTreeNode("description","Communications", name);
            TreeNode address = new CheckboxTreeNode("description","Adresses", name);
            
            //Communication
            for (Communication comm : contactList.get(i).getCommunications()){
                TreeNode communications = new CheckboxTreeNode("communication",comm, communication);
            }
            //Adresses
            for (Address add : contactList.get(i).getAddresses()) {
                TreeNode addresses = new CheckboxTreeNode("address",add, address);
            }
        }
        
        return root;

    }
    
    /**
     * init-Method
     */
    @PostConstruct
    public void init() {
        this.root = createCheckboxContacts();

        //type
        types = new Type[7];
        types[0] = Type.EMAIL;
        types[1] = Type.FACEBOOK;
        types[2] = Type.FAX;
        types[3] = Type.ICQ;
        types[4] = Type.MOBILE;
        types[5] = Type.PHONE;
        types[6] = Type.SKYPE;
        //country
        countries = new Country[2];
        countries[0] = Country.AUSTRIA;
        countries[1] = Country.GERMANY;
    }

    /**
     *
     * @return
     */
    
    public TreeNode getRoot() {
        return root;
    }

    /**
     *
     * @return
     */
    public List<Contact> getContactList() {
        return contactList;
    }

    /**
     *
     * @return
     */
    public Type[] getType() {
        return types;
    }

    /**
     *
     * @return
     */
    public Country[] getCountries() {
        return countries;
    }

}
