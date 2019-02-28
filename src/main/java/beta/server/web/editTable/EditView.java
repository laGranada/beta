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
    
    Communication communication = new Communication();
//    @Inject
//    private Country coun;
//    
//    private Map<String, String> countries;
//    private String country;
//    
//    @PostConstruct
//    public void init(){
//        countries = new HashMap<String, String>();
//        countries.put(coun.getCountryName(), coun.getIsoCode());
//        
//    }
//
//    public Map<String, String> getCountries() {
//        return countries;
//    }
//
//    public String getCountry() {
//        return country;
//    }

   
    
    
    
    public void onRowEdit(RowEditEvent event){
        FacesMessage msg = new FacesMessage("Contact Edited", ((TreeNode) event.getObject()).toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((TreeNode) event.getObject()).toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
