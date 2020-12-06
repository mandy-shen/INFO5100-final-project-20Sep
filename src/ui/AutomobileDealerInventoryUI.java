package ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.zip.DeflaterInputStream;

public class AutomobileDealerInventoryUI extends JFrame{


    private JPanel mainDisplay;
    String dealerName=" Automobile Dealer"; // this we will get dynamically from UC1 on button click inverntory search
    private JLabel pageHeading;
    private JLabel vehicleDisplayList;
    private  JTable vehicleDisplay;





    AutomobileDealerInventoryUI(){
        createComponents();
        addComponents();

    }


    private void createComponents() {
        mainDisplay=new JPanel();
        pageHeading=new JLabel(dealerName+" Inventory");
        vehicleDisplay=new JTable(3,4);
       // vehicleDisplay.setAlign;
        vehicleDisplay.setBorder(new LineBorder(Color.red));








       // vehicleInventoryTable.setTableHeader(pageHeading);





    }
    private void addComponents() {

        mainDisplay.add(pageHeading);
        mainDisplay.add(vehicleDisplay);

       ;





    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }


    //create components




    //addComponents to mainDisplay

        public static void main(String args[]){
        JFrame frame = new JFrame("Automobile Dealer");
        frame.setResizable(true);
        frame.setContentPane(new AutomobileDealerInventoryUI().mainDisplay);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }



}
