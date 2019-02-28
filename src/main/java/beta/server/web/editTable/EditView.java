/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beta.server.web.editTable;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.TreeNode;
import beta.server.entity.Contact;
import org.primefaces.event.CellEditEvent;

/**
 *
 * @author margarita.dueck
 */
@ViewScoped
@Named("editView")
public class EditView implements Serializable {
    
    Contact contact = new Contact();
     
    public void onRowEdit(RowEditEvent event){
        FacesMessage msg = new FacesMessage("Contact Edited", ((TreeNode) event.getObject()).toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((TreeNode) event.getObject()).toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
