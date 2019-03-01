/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beta.server.web.editTable;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.TreeNode;

/**
 *
 * @author margarita.dueck
 */
@ViewScoped
@Named("editView")
public class EditView implements Serializable {
    
    private TreeNode selectedNode;
    private TreeNode[] selectedNodes;
    
    public TreeNode getSelectedNode() {
        return selectedNode;
    }
 
    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }
    
    public TreeNode[] getSelectedNodes() {
        return selectedNodes;
    }
 
    public void setSelectedNodes(TreeNode[] selectedNodes) {
        this.selectedNodes = selectedNodes;
    }
    
    public void deleteNodes(TreeNode[] nodes){
        if(nodes != null && nodes.length > 0){
            for(int i = 0; i < nodes.length; i++){
                TreeNode parent = nodes[i].getParent();
                parent.getChildren().remove(nodes[i]);
            }
        }
        
    }

      
    public void onRowEdit(RowEditEvent event){
        FacesMessage msg = new FacesMessage("Contact Edited", ((TreeNode) event.getObject()).toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((TreeNode) event.getObject()).toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }


}
