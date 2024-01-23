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
      setTitle("Project 4");
      setSize(650,350);
      setLocation(400,200);
      
      createMenu();
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      
      setLayout(new GridLayout(1,3));

   }
   
   /**
    * Create the file and edit menus where the "Open," "Quit," and "Search" menu items drop down from
    */
   private void createMenu() {
      JMenuBar menuBar = new JMenuBar();
      JMenu fileMenu = new JMenu("File");
      JMenu editMenu = new JMenu("Edit");
      JMenuItem item;
      FileMenuHandler fmh = new FileMenuHandler(this);
      EditMenuHandler emh = new EditMenuHandler(this);

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
      
      //create "Search" menu item under "Edit" menu
      item = new JMenuItem("Search");
      editMenu.add(item);
      item.addActionListener(emh);     
      
      setJMenuBar(menuBar);
      menuBar.add(fileMenu);
      menuBar.add(editMenu);
   }
 
}
