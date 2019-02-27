/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beta.server.web.editTable;

import beta.server.eao.ContactEao;
import beta.server.entity.Address;
import beta.server.entity.Communication;
import beta.server.entity.Contact;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.CheckboxTreeNode;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author margarita.dueck
 */

@Stateless
public class ContactServiceETT implements Serializable {
    
    @Inject
    private ContactEao cEao;
    
    private List<Contact> contactList;

    public List<Contact> getContactList() {
        return contactList;
    }
    
    public TreeNode createContacts(){
        contactList = cEao.findAll();
        
        TreeNode root = new DefaultTreeNode("Names", null);
        
        for(int i = 0; i < contactList.size(); i++ ){
            TreeNode name = new DefaultTreeNode(contactList.get(i).toFullName(), root);
            
            TreeNode address = new DefaultTreeNode("Adresses", name);
            TreeNode communication = new DefaultTreeNode("Communications", name);
            
            //Adresses
            for (Address add : contactList.get(i).getAddresses()) {
                TreeNode addresses = new DefaultTreeNode(add.toSingleLineString(), address);
            }
            //Communication
            for (Communication comm : contactList.get(i).getCommunications()){
                TreeNode communications = new DefaultTreeNode(comm.toSingleLineString(), communication);
            }
        }
        
        return root;
    
    }
    
    public TreeNode creatCheckboxContacts(){
        contactList = cEao.findAll();
        
        TreeNode root = new CheckboxTreeNode("Names", null);
        
        for(int i = 0; i < contactList.size(); i++ ){
            TreeNode name = new CheckboxTreeNode(contactList.get(i).toFullName(), root);
            
            TreeNode address = new CheckboxTreeNode("Adresses", name);
            TreeNode communication = new CheckboxTreeNode("Communications", name);
            
            //Adresses
            for (Address add : contactList.get(i).getAddresses()) {
                TreeNode addresses = new CheckboxTreeNode(add.toSingleLineString(), address);
            }
            //Communication
            for (Communication comm : contactList.get(i).getCommunications()){
                TreeNode communications = new CheckboxTreeNode(comm.toSingleLineString(), communication);
            }
        }
        return null;
    }
}
