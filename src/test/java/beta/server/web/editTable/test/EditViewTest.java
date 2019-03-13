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
import org.primefaces.model.CheckboxTreeNode;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author margarita.dueck
 */
public class EditViewTest {
    EditView ev = new EditView();
    ContactServiceETT cs = new ContactServiceETT();
//    private TreeNode root;
//    TreeNode[] selectedNodes;

    @Before
    public void init(){       
//        selectedNodes[0] = new DefaultTreeNode("Communications", root);
//        selectedNodes[1] = new DefaultTreeNode("description", root);
//        selectedNodes[3] = new DefaultTreeNode("dhg", root);
//        
//        ev.setSelectedNodes(selectedNodes);
        
    }

    @Test
    public void testDeleteNodes(){
        ev.deleteNodes();
        assertNull(ev.getSelectedNodes());
    }
}
