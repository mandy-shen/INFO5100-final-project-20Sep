package ui;
import dao.Vehicle;

import javax.swing.*;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

public class SearchSort extends SearchSortAbstract{
    private JPanel mainDisplayPanel;
    private JPanel filterPanel;
    private JPanel vehicleDisplayPanel;
    private JPanel sortPanel;
    private HashSet<String> selected;


    @Override
    JPanel getMainDisplayPanel() {

        // init panel


        mainDisplayPanel = new JPanel(new GridLayout(3,1));

        // add Component to mailDisplayPanel;
        mainDisplayPanel.add(getFilterPanel());
        mainDisplayPanel.add(getSortPanel());
        mainDisplayPanel.add(getVehicleDisplayPanel());

        return mainDisplayPanel;
    }

    private JPanel getFilterPanel() {
        //code for UI for filterPanel  ie filters for searching
        JButton category, make , model, type, bodyStyle, price, more;

        filterPanel=new JPanel();
        filterPanel.setBackground(Color.red);
        filterPanel.add(new JLabel("FILTER"));
        category = addFilterChoice("CATEGORY", filterPanel);
        make = addFilterChoice("MAKE", filterPanel);
        model = addFilterChoice("MODEL", filterPanel);
        type = addFilterChoice("TYPE", filterPanel);
        bodyStyle = addFilterChoice("BODY STYLE", filterPanel);
        price = addFilterChoice("PRICE", filterPanel);
        more = addFilterChoice("MORE", filterPanel);
        selected = new HashSet<String>();
        
        
        return filterPanel;
    }
    
    private JButton addFilterChoice(String choice, JPanel panel) {
    	JButton choiceButton = new JButton(choice);
    	filterPanel.add(choiceButton);
    	JPopupMenu menu = new JPopupMenu();
        if (choice.equals("CATEGORY")) {
        	menu.add(new JCheckBoxMenuItem("New"));
            menu.add(new JCheckBoxMenuItem("Certified Pre-Owned"));
            menu.add(new JCheckBoxMenuItem("Pre-Owned"));
        } else if (choice.equals("MAKE")) {
        	menu.add(new JCheckBoxMenuItem("Chevrolet"));
            menu.add(new JCheckBoxMenuItem("BOW"));
            menu.add(new JCheckBoxMenuItem("Jeep"));
            menu.add(new JCheckBoxMenuItem("Mini"));
            menu.add(new JCheckBoxMenuItem("Nissan"));
            menu.add(new JCheckBoxMenuItem("Toyota"));
        } else if (choice.equals("MODEL")) {
        	menu.add(new JCheckBoxMenuItem("Acadia"));
            menu.add(new JCheckBoxMenuItem("Blazer"));
            menu.add(new JCheckBoxMenuItem("Bolt EV"));
        } else if (choice.equals("TYPE")) {
        	menu.add(new JCheckBoxMenuItem("Car"));
            menu.add(new JCheckBoxMenuItem("Cargo Van"));
            menu.add(new JCheckBoxMenuItem("SUV"));
            menu.add(new JCheckBoxMenuItem("Truck"));
            menu.add(new JCheckBoxMenuItem("Van"));
            menu.add(new JCheckBoxMenuItem("Wagon"));
        } else if (choice.equals("BODY STYLE")) {
        	menu.add(new JCheckBoxMenuItem("Crew Crab Pickup - Long Bed"));
            menu.add(new JCheckBoxMenuItem("Crew Crab Pickup - Short Bed"));
            menu.add(new JCheckBoxMenuItem("Crew Crab Pickup - Standard Bed"));
        } else if (choice.equals("Year")) {
            menu.add(new JCheckBoxMenuItem("2009"));
            menu.add(new JCheckBoxMenuItem("2010"));
            menu.add(new JCheckBoxMenuItem("2011"));
            menu.add(new JCheckBoxMenuItem("2012"));
            menu.add(new JCheckBoxMenuItem("2013"));
            menu.add(new JCheckBoxMenuItem("2014"));
            menu.add(new JCheckBoxMenuItem("2015"));
            menu.add(new JCheckBoxMenuItem("2016"));
            menu.add(new JCheckBoxMenuItem("2017"));
            menu.add(new JCheckBoxMenuItem("2018"));
            menu.add(new JCheckBoxMenuItem("2019"));
            menu.add(new JCheckBoxMenuItem("2020"));
            menu.add(new JCheckBoxMenuItem("2021"));
        } else {
        	menu.add(new JCheckBoxMenuItem("Wait for coming"));
        }
        menu.addMenuKeyListener(new MenuKeyListener(){

			@Override
			public void menuKeyPressed(MenuKeyEvent e) {
				selected.add(e.toString());
			}

			@Override
			public void menuKeyReleased(MenuKeyEvent e) {
				selected.remove(e.toString());
				
			}

			@Override
			public void menuKeyTyped(MenuKeyEvent e) {
				selected.add(e.toString());
			}});
        
        
        
        choiceButton.setAction(new AbstractAction(choice) {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public void actionPerformed(ActionEvent e) {
                menu.show(choiceButton, 0, choiceButton.getHeight());
            }
        });
        
        panel.add(choiceButton);
        return choiceButton;
    }

    private JPanel getSortPanel() {
        //UI for sorting Panel for sorting the result on the basis on certain criterias
        sortPanel=new JPanel();
        sortPanel.setSize(600,200);
        sortPanel.add(new Label("sorting ui components should be here"));
        sortPanel.setBackground(Color.white);
        return sortPanel;
    }

    private JPanel getVehicleDisplayPanel() {

        vehicleDisplayPanel=new JPanel(new GridLayout(5,5));
        vehicleDisplayPanel.setBackground(Color.yellow);
        vehicleDisplayPanel.add(new Label("vehical should be displayed here"));
        //code for UI for VehicalPanel;
        return vehicleDisplayPanel;
    }



    public static void main(String[] args) {
        SearchSort searchSortObj=new SearchSort();
        System.out.println("AppUI main starting...");
    }


}
