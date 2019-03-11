/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beta.server.web.editTable.test;

import beta.server.web.editTable.ContactServiceETT;
import beta.server.web.editTable.EditView;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.Ignore;

/**
 *
 * @author margarita.dueck
 */
public class EditViewTest {
    

    @Test
    public void testDeleteNodes(){
        EditView ev = new EditView();
 
        ev.deleteNodes();
        assertNull(ev.getSelectedNodes());
    }
}
