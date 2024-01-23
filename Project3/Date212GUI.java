import java.awt.GridLayout;
import javax.swing.*;


/**
 * Create the GUI where the dates will be displayed and its file menu
 */
public class Date212GUI extends JFrame{
   
   /**
    * Create and set up the GUI window
    */
   public Date212GUI(){ 
      setTitle("Project 3");
      setSize(350,350);
      setLocation(500,300);
      createFileMenu();
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      
      setLayout(new GridLayout(1,2));

   }
   
   /**
    * Create the file menu where the "Open" and "Quit" drop down from
    */
   private void createFileMenu() {
      JMenuBar menuBar = new JMenuBar();
      JMenu fileMenu = new JMenu("File");
      JMenuItem item;
      FileMenuHandler fmh = new FileMenuHandler(this);

      //creates "Open" menu item under "File"
      item = new JMenuItem("Open");    
      item.addActionListener(fmh);
      fileMenu.add(item);

      //adds horizontal line
      fileMenu.addSeparator();         
    
      //creates "Quit" menu item under "File"
      item = new JMenuItem("Quit");    
      item.addActionListener(fmh);
      fileMenu.add(item);

      setJMenuBar(menuBar);
      menuBar.add(fileMenu);
   }
 
}
