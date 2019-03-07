/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beta.server.web.editTable;

import beta.server.entity.Contact;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Selection for TreeTable
 * 
 * @author margarita.dueck
 */
@ViewScoped
@Named("editView")
public class EditView implements Serializable {
    
    private final Logger L = LoggerFactory.getLogger(EditView.class);
    
    private Contact selectedContact;
    private TreeNode[] selectedNodes;

    
    
    
    /**
     * get parent of node
     * go through children of parent
     * and then remove selected node from children
     * set selectedNodes = null
     * @param nodes
     */
    public void deleteNodes(){        
        if(selectedNodes != null && selectedNodes.length > 0){
            for(int i = 0; i < selectedNodes.length; i++){
                TreeNode parent = selectedNodes[i].getParent();
                L.info("Check delete for deletenode={}, and parentnode={}", selectedNodes[i], parent);
                parent.getChildren().remove(selectedNodes[i]);    
            }
        }
        selectedNodes = null;
    }
    
    /**
     *
     * @param event
     */
    public void onRowEdit(RowEditEvent event){
        FacesMessage msg = new FacesMessage("Contact Edited", ((TreeNode) event.getObject()).toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    /**
     *
     * @param event
     */
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((TreeNode) event.getObject()).toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);    
    }

    public Contact getSelectedContact() {
        return selectedContact;
    }

    public void setSelectedContact(Contact selectedContact) {
        this.selectedContact = selectedContact;
    }

    public TreeNode[] getSelectedNodes() {
        return selectedNodes;
    }

    public void setSelectedNodes(TreeNode[] selectedNodes) {
        this.selectedNodes = selectedNodes;
    }
    
}
