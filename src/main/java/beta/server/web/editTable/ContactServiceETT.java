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
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
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
    

    
    private Type[] type;
    private Country[] countries;

    public List<Contact> getContactList() {
        return contactList;
    }


    public Type[] getType() {
        return type;
    }

    public Country[] getCountries() {
        return countries;
    }
    
    

    public TreeNode createContacts() {
        contactList = cEao.findAll();

        this.root = new DefaultTreeNode(contact, null);
        //contact direkt in die treeNode und selected
        for (int i = 0; i < contactList.size(); i++) {
            TreeNode name = new DefaultTreeNode("contact", contactList.get(i), root);
            
            TreeNode communication = new DefaultTreeNode("beschreibung","Communications", name);
            TreeNode address = new DefaultTreeNode("beschreibung","Adresses", name);
            
            //Communication
            for (Communication comm : contactList.get(i).getCommunications()){
                TreeNode communications = new DefaultTreeNode("communication",comm, communication);
            }
            //Adresses
            for (Address add : contactList.get(i).getAddresses()) {
                TreeNode addresses = new DefaultTreeNode("address",add, address);
            }
            
        }

        return root;

    }

    @PostConstruct
    public void init() {
        this.root = createContacts();

        //type
        type = new Type[7];
        type[0] = Type.EMAIL;
        type[1] = Type.FACEBOOK;
        type[2] = Type.FAX;
        type[3] = Type.ICQ;
        type[4] = Type.MOBILE;
        type[5] = Type.PHONE;
        type[6] = Type.SKYPE;
        //country
        countries = new Country[2];
        countries[0] = Country.AUSTRIA;
        countries[1] = Country.GERMANY;
    }

    public TreeNode getRoot() {
        return root;
    }


}
