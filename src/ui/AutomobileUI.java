package ui;

import dao.BodyType;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AutomobileUI {
    private JPanel mainDisplayPanel;
    private JComboBox yearComboBox;
    private JPanel vehicalDisplayPanel;
    private JTable vehiclesTable;
    private String dealerName="gmps-aj-dohmann" ;// dealer name will come from UC1
    String[] dealerInventoryData;


    AutomobileUI(){
        createUIComponents();
        readDealerInventory(dealerName); //Read inventory file for particular dealer

    }

    private void displayVehicals(String[] dealerInventoryData) {
        String Model=dealerInventoryData[3];
        String Make=dealerInventoryData[4];
        String vehicleImagePath =dealerInventoryData[dealerInventoryData.length-1];
        //we need to look how to setImage icon in Jtable cell

//        ImageIcon imageIcon=new ImageIcon(vehicleImagePath);
//        TableModel tm = vehiclesTable.getModel();
//        for (int i = 0; i < tm.getRowCount(); i++) {
//            for (int j = 0; j < tm.getColumnCount(); j++) {
//                    tm.setValueAt("hello",i,j);
//            }
//        }


    }

    private void readDealerInventory(String dealerName) {
        {
            String line = "";
            String splitBy = "~";
            try
            {

                BufferedReader br = new BufferedReader(new FileReader("././Data/"+dealerName));
                while ((line = br.readLine()) != null){
                        dealerInventoryData=line.split(splitBy);
                        displayVehicals(dealerInventoryData);
                       //System.out.println(Arrays.toString(dealerInventoryData));
                        System.out.println("Dealers [Dealer ID =" + dealerInventoryData[0] + ", WebId=" + dealerInventoryData[1] + ", Category=" + dealerInventoryData[2] +
                                            ", year=" + dealerInventoryData[3] + ", Make=" + dealerInventoryData[4] + ", Model= " + dealerInventoryData[5] + ", Trim= " + dealerInventoryData[6]
                                            + ", Type= " + dealerInventoryData[7] +", Price= " + dealerInventoryData[8] +"]");
                    }
            }
            catch (IOException e) {
                    e.printStackTrace();
            }
        }

    }



    private void createUIComponents() {

        vehiclesTable=new JTable(20,5);
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
