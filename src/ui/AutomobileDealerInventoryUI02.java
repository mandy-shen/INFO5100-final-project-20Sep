package main;

import dao.Vehicle;
import dto.DataPersistence;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AutomobileDealerInventoryUI02 extends JFrame {

    // Variables
    private JScrollPane jScrollPane2;
    private JPanel mainDisplay;
    private JLabel pageHeading;
    private JTable vehicleDisplay;
    String dealerName= "gmps-aj-dohmann";

    /**
     * Creates new form Inventory
     */
    public AutomobileDealerInventoryUI02() {
        initComponents();
    }

    private void initComponents() {

        mainDisplay = new javax.swing.JPanel();
        pageHeading = new JLabel();
        jScrollPane2 = new JScrollPane();
        vehicleDisplay = new JTable();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainDisplay.setBackground(new Color(153, 153, 153));
        pageHeading.setFont(new Font("Tahoma", 0, 36)); // NOI18N
        pageHeading.setText("INVENTORY");

        jScrollPane2.setViewportView(getTable(dealerName));

        GroupLayout mainDisplayLayout = new GroupLayout(mainDisplay);
        mainDisplay.setLayout(mainDisplayLayout);
        mainDisplayLayout.setHorizontalGroup(
                mainDisplayLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainDisplayLayout.createSequentialGroup()
                                .addContainerGap(352, Short.MAX_VALUE)
                                .addComponent(pageHeading)
                                .addGap(342, 342, 342))
        );
        mainDisplayLayout.setVerticalGroup(
                mainDisplayLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainDisplayLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(pageHeading)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 540, GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(mainDisplay, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(mainDisplay, GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }


    private JTable getTable(String dealerName) {
        // if (vehicleDisplay == null) {
        vehicleDisplay = new JTable();
        vehicleDisplay.setRowHeight(125);
        String[] columns = {"model", "price", "miles", "images"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        vehicleDisplay.setModel(model);
        List<String> vehicles = getVehicle(dealerName);

        for (String vehicle : vehicles) {
            String[] args = vehicle.split(",");
            model.addRow(args);
        }
        return vehicleDisplay;
    }



    //turn List<Vehicle> to the List<String>
    private List<String> getVehicle(String dealerName) {
        DataPersistence dp = new DataPersistence();
        try {
            List<String> stringVe = new ArrayList<>();
            List<Vehicle> allVehicles = dp.getAllVehicles(dealerName);
            for (Vehicle vehicle:allVehicles) {
                stringVe.add(vehicle.toString());
              //  System.out.println(vehicle.toString());
            }
            return stringVe;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AutomobileDealerInventoryUI02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AutomobileDealerInventoryUI02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AutomobileDealerInventoryUI02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AutomobileDealerInventoryUI02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AutomobileDealerInventoryUI02().setVisible(true);
                new AutomobileDealerInventoryUI02().getVehicle("gmps-aj-dohmann");

            }
        });
    }



}

