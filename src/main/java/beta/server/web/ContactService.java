/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beta.server.web;

import beta.server.eao.ContactEao;
import beta.server.entity.Address;
import beta.server.entity.Communication;
import beta.server.entity.Contact;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import lombok.Getter;
/**
 * access the the database
 * creates the treeTable
 * @author margarita.dueck
 */

@Stateless
public class ContactService implements Serializable {

    
    @Inject
    private ContactEao cEao;
    
    @Getter
    private List<Contact> contactList;
    
    /**
     * creates TreeNodes with contacts
     * @return root
     */
    public TreeNode createContacts(){
        this.contactList = cEao.findAll();
        
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
    
}
