package ui;

import dao.BodyType;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AutomobileUI {
    private JPanel mainDisplayPanel;
    private JPanel vehicalDisplayPanel;
    private JTable vehiclesTable;
    private String dealerName="gmps-aj-dohmann" ;// dealer name will come from UC1
    Object[] dealerInventoryData;


    AutomobileUI(){
       createUIComponents();
        readDealerInventory(dealerName); //Read inventory file for particular dealer

    }

    private void displayVehicals(Object[] dealerInventoryData) {
        int maxRowCountPerPage=50;
        Object model=dealerInventoryData[5];
        Object make=dealerInventoryData[4];
        Object type=dealerInventoryData[7];
        Object year=dealerInventoryData[3];
        Object price="$"+dealerInventoryData[8];
        String vehicleImagePath =(String)dealerInventoryData[dealerInventoryData.length-1];
        ImageIcon vehicleIcon=(ImageIcon) UIManager.getIcon(vehicleImagePath);
        Object[] columnNames = {"Model","Make","Price","Year","Type","Img"};
        Object[][] data=new Object[maxRowCountPerPage][columnNames.length];
        //Setting values of table Dynamically
        for(int i=0;i<maxRowCountPerPage;i++) {

            if (i == 0) { //setting top row
                data[i][0]="Model";
                data[i][1]="Make";
                data[i][2]="Year";
                data[i][3]="Price";
                data[i][4]="Type";
                data[i][5]="Image";

            } else {
                data[i][0] = (String) model;
                data[i][1] = (String) make;
                data[i][2] = (String) year;
                data[i][3] = (String) price;
                data[i][4] = (String) type;
                data[i][5] =vehicleIcon;  //need to check for how to render image on cell
            }
        }

        DefaultTableModel defaultTableModel = new DefaultTableModel(data, columnNames);
        vehiclesTable=new JTable(defaultTableModel);

    }

    private void readDealerInventory(String dealerName) {
        {
            String line = "";
            String splitBy = "~";
            
            try
            {

                BufferedReader br = new BufferedReader(new FileReader("././Data/"+dealerName));
                while ((line = br.readLine()) != null){
                        //noOfLinesPresent++;
                        dealerInventoryData=line.split(splitBy);
                        displayVehicals(dealerInventoryData);
 //                      System.out.println(Arrays.toString(dealerInventoryData));
//                        System.out.println("Dealers [Dealer ID =" + dealerInventoryData[0] + ", WebId=" + dealerInventoryData[1] + ", Category=" + dealerInventoryData[2] +
//                                            ", year=" + dealerInventoryData[3] + ", Make=" + dealerInventoryData[4] + ", Model= " + dealerInventoryData[5] + ", Trim= " + dealerInventoryData[6]
//                                            + ", Type= " + dealerInventoryData[7] +", Price= " + dealerInventoryData[8] +"]");
                    }
            }
            catch (IOException e) {
                    e.printStackTrace();
            }
        }

    }



    private void createUIComponents() {

        readDealerInventory(dealerName);

    }

    public static void main(String args[]){
        JFrame frame = new JFrame("Automobile Dealer");
        frame.setContentPane(new AutomobileUI().mainDisplayPanel);
        frame.setSize(600,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
