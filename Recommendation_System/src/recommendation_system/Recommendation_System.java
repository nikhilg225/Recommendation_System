/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommendation_system;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Nikhil
 */
public class Recommendation_System {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException E){
            E.printStackTrace();
        }

//        Intro_First intro=new Intro_First();
//        intro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        intro.pack();
//        intro.setVisible(true);



// TODO code application logic here
    }
    
}
