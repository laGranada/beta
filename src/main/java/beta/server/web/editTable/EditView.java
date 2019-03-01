/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beta.server.web.editTable;

import beta.server.entity.Communication;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.TreeNode;
import beta.server.entity.Country;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

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
    
    public void displaySelectedSingle() {
        if(selectedNode != null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", selectedNode.getData().toString());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
     
    public void displaySelectedMultiple(TreeNode[] nodes) {
        if(nodes != null && nodes.length > 0) {
            StringBuilder builder = new StringBuilder();
 
            for(TreeNode node : nodes) {
                builder.append(node.getData().toString());
                builder.append("<br />");
            }
 
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", builder.toString());
            FacesContext.getCurrentInstance().addMessage(null, message);
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
