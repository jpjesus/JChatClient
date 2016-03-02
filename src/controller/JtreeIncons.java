/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeNode;




public class JtreeIncons extends DefaultTreeCellRenderer {
        /** Creates a new instance of RendererArbol */
    ImageIcon conectados;
    ImageIcon noConectados;

    public JtreeIncons() 
    {
        conectados = new ImageIcon("src/pelota.png");
        noConectados = new ImageIcon("src/X.png");
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus)
    {                 
        super.getTreeCellRendererComponent(tree,value,selected,expanded,leaf,row,hasFocus);
        String val = value.toString();
        ImageIcon i;
        DefaultMutableTreeNode nodo = (DefaultMutableTreeNode)value; 
        if(val.compareTo("Conectados")!=0 && val.compareTo("No Conectados")!=0 && val.compareTo("Contactos")!=0){     
            TreeNode t = nodo.getParent();
            if(t!=null){
                if(t.toString().compareTo("Conectados")==0){
                    setIcon(conectados);
                }else if(t.toString().compareTo("No Conectados")==0){
                    setIcon(noConectados);
                }
            }
        }                             
        return this;
    }
}
    

    

