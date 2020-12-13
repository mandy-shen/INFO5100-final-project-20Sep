package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class SearchSort extends SearchSortAbstract{
	private JPanel mainDisplayPanel;
    private JPanel filterPanel;
    private JPanel vehicleDisplayPanel;
    private JPanel sortPanel;
    private HashMap<String, HashSet<String>> container;
    private final int[] selectedSort = {0};
    private final int FILTER_CATEGROY_COUNT = 7;
    private final Integer[] ORDER = {2, 4, 5, 7, 6, 8, 8};
    private final String[] CATEGORIES = {"category", "make", "model", "type",
            "body style", "above price", "below price"};

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
        container = new HashMap<String, HashSet<String>>();
        filterPanel = new JPanel();
        filterPanel.setBackground(Color.red);
        filterPanel.add(new JLabel("FILTER"));
        addFilterChoice("CATEGORY", filterPanel);
        addFilterChoice("MAKE", filterPanel);
        addFilterChoice("MODEL", filterPanel);
        addFilterChoice("TYPE", filterPanel);
        addFilterChoice("BODY STYLE", filterPanel);
        addFilterChoice("ABOVE PRICE", filterPanel);
        addFilterChoice("BELOW PRICE", filterPanel);
        addFilterChoice("MORE", filterPanel);
        ((AbstractButton) filterPanel.add(new JButton("Clear All"))).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	container.clear();
            	//System.out.println(container.size());
            }
        });
        return filterPanel;
    }
//  System.out.println("Dealers [Dealer ID =" + dealerInventoryData[0] + ", WebId=" + dealerInventoryData[1] + ", Category=" + dealerInventoryData[2] +
//  ", year=" + dealerInventoryData[3] + ", Make=" + dealerInventoryData[4] + ", Model= " + dealerInventoryData[5] + ", Trim= " + dealerInventoryData[6]
//  + ", Type= " + dealerInventoryData[7] +", Price= " + dealerInventoryData[8] +"]");
    private void addFilterChoice(String choice, JPanel panel) {
    	JButton choiceButton = new JButton(choice);
    	JPopupMenu menu = new JPopupMenu();
    	String[] data = AutomobileDealerInventoryUI02.getInventoryData();
    	//System.out.println(data);
        if (choice.equals("CATEGORY")) {
        	menu.add(new JCheckBoxMenuItem("New"));
            menu.add(new JCheckBoxMenuItem("Certified Pre-Owned"));
            menu.add(new JCheckBoxMenuItem("Pre-Owned"));
        } else if (choice.equals("MAKE")) {
        	if (!container.containsKey("CATEGORY")) {
	        	menu.add(new JCheckBoxMenuItem("Chevrolet"));
	            menu.add(new JCheckBoxMenuItem("BOW"));
	            menu.add(new JCheckBoxMenuItem("Jeep"));
	            menu.add(new JCheckBoxMenuItem("Mini"));
	            menu.add(new JCheckBoxMenuItem("Nissan"));
	            menu.add(new JCheckBoxMenuItem("Toyota"));
        	} else {
        		for (int i = 0; i < data.length; i++) {
        			if(container.get("CATEGORY").contains(data[2])) {
        				menu.add(new JCheckBoxMenuItem(data[4]));
        			}
        		}
        	}
        } else if (choice.equals("MODEL")) {
        	if (!container.containsKey("MAKE")) {
	        	menu.add(new JCheckBoxMenuItem("Acadia"));
	            menu.add(new JCheckBoxMenuItem("Blazer"));
	            menu.add(new JCheckBoxMenuItem("Bolt EV"));
        	} else {
        		for (int i = 0; i < data.length; i++) {
        			if(container.get("MAKE").contains(data[4])) {
        				menu.add(new JCheckBoxMenuItem(data[5]));
        			}
        		}
        	}
        } else if (choice.equals("TYPE")) {
        	if (!container.containsKey("MODEL")) {
        		menu.add(new JCheckBoxMenuItem("Car"));
                menu.add(new JCheckBoxMenuItem("Cargo Van"));
                menu.add(new JCheckBoxMenuItem("SUV"));
                menu.add(new JCheckBoxMenuItem("Truck"));
                menu.add(new JCheckBoxMenuItem("Van"));
                menu.add(new JCheckBoxMenuItem("Wagon"));
        	} else {
        		for (int i = 0; i < data.length; i++) {
        			if(container.get("MODEL").contains(data[5])) {
        				menu.add(new JCheckBoxMenuItem(data[7]));
        			}
        		}
        	}
//        } else if (choice.equals("BODY STYLE")) {
//        	menu.add(new JCheckBoxMenuItem("Crew Crab Pickup - Long Bed"));
//            menu.add(new JCheckBoxMenuItem("Crew Crab Pickup - Short Bed"));
//            menu.add(new JCheckBoxMenuItem("Crew Crab Pickup - Standard Bed"));
        } else if (choice.equals("Year")) {
        	if (!container.containsKey("TYPE")) {
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
        		for (int i = 0; i < data.length; i++) {
        			if(container.get("TYPE").contains(data[7])) {
        				menu.add(new JCheckBoxMenuItem(data[3]));
        			}
        		}
        	}
        } else if (choice.equals("ABOVE PRICE")) {
        	menu.add(new JCheckBoxMenuItem("1000"));
        	menu.add(new JCheckBoxMenuItem("5000"));
        	menu.add(new JCheckBoxMenuItem("10000"));
        	menu.add(new JCheckBoxMenuItem("15000"));
        	menu.add(new JCheckBoxMenuItem("20000"));
        	menu.add(new JCheckBoxMenuItem("25000"));
        	menu.add(new JCheckBoxMenuItem("30000"));
        } else if (choice.equals("BELOW PRICE")) {
        	menu.add(new JCheckBoxMenuItem("1000"));
        	menu.add(new JCheckBoxMenuItem("5000"));
        	menu.add(new JCheckBoxMenuItem("10000"));
        	menu.add(new JCheckBoxMenuItem("15000"));
        	menu.add(new JCheckBoxMenuItem("20000"));
        	menu.add(new JCheckBoxMenuItem("25000"));
        	menu.add(new JCheckBoxMenuItem("30000"));
        	menu.add(new JCheckBoxMenuItem("35000"));
        	menu.add(new JCheckBoxMenuItem("40000"));
        	menu.add(new JCheckBoxMenuItem("45000"));
        } else {
        	menu.add(new JCheckBoxMenuItem("Wait for coming"));
        }
        // add action listener to each ChekcBoxMenuItem
        for (Component item: menu.getComponents()) {
        	((AbstractButton) item).addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                  String cur = e.toString().split(",")[1].substring(4);
                  if (!((JCheckBoxMenuItem)item).isSelected()) {
                	  container.get(choice).remove(cur);
                  } else {
                	  if (!container.containsKey(choice)) {
                		  container.put(choice, new HashSet<String>());
                	  }
                	  container.get(choice).add(cur);
                  }
                  //System.out.println(container);
                  try {
                	  Thread.sleep(1000);
                  } catch (InterruptedException ie) {
                	  ie.printStackTrace();
                  }
                }
              });}

        // combine each button with CheckBoxMenu
        choiceButton.setAction(new AbstractAction(choice) {
            /**
			 *
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
                menu.show(choiceButton, 0, choiceButton.getHeight());
            }
        });

        panel.add(choiceButton);
    }

 // sort the result as user selected and provide the result to display panel to display
    private JPanel getSortPanel() {
        //UI for sorting Panel for sorting the result on the basis on certain criterias

        sortPanel = new JPanel();
        sortPanel.setSize(600, 200);
        sortPanel.add(new Label("How would you like to sort the results?"));
        JPanel temp = new JPanel();
        JTextArea text = new JTextArea("");
        temp.add(text);
        String[] sortOptions = {"", "Price: High to low", "Price: Low to High", "Year: High to Low",
                "Year: Low to High"};
        JComboBox sortList = new JComboBox(sortOptions);
        sortList.setSelectedIndex(0);
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int s = (int) sortList.getSelectedIndex();
                switch(s) {
                    case 1:
                        text.setText("Selected: Sort price from high to low");
                        selectedSort[0] = 1;
                        break;
                    case 2:
                        text.setText("Selected: Sort price form low to high");
                        selectedSort[0] = 2;
                        break;
                    case 3:
                        text.setText("Selected: Sort year from high to low");
                        selectedSort[0] = 3;
                        break;
                    case 4:
                        text.setText("Selected: Sort year from low to high");
                        selectedSort[0] = 4;
                        break;
                }
                text.setEditable(false);
            }
        };
        sortList.addActionListener(actionListener);
        sortPanel.add(sortList);
        sortPanel.add(temp);
        JButton confirm = new JButton("Confirm");
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // call the sort method to implement sorting based on user's selection
                ShowAndSearchUI ui = new ShowAndSearchUI();
                ArrayList<String[]> filteredList = filter(ui.fullInventoryData);
                // this value is not used!
                ArrayList<String[]> sortedList = sort(selectedSort[0], filteredList); // final sorted list
                // TODO: Need to integrate with Deepika

            }
        });
        sortPanel.add(confirm);
        sortPanel.setBackground(Color.white);
        /* Need to get data from filter panel and sort the data using the selected sort method.
         *  */
        return sortPanel;
    }

    // filter the data based on selected filter choices
    private ArrayList<String[]> filter(ArrayList<String[]> data) {
        ArrayList<String[]> result = new ArrayList<>();
        int count = 0;
        //Set<String> keySet = container.keySet();
        for (int i = 0; i < FILTER_CATEGROY_COUNT; i++) {
            if (container.get(CATEGORIES[i]) != null) {
                break;
            } else {
                count++;
            }
        }

        addToResult(count, data, result);
        count++;
        for (int i = count; i < FILTER_CATEGROY_COUNT; i++) {
            if (container.get(CATEGORIES[i]) != null) {
                deleteFromResult(i, data, result);
            }
        }
        return result;
    }


    private void addToResult(int count, ArrayList<String[]> data, ArrayList<String[]> result) {
        for (int i = 0; i < container.get(CATEGORIES[count]).size(); i++) {
            for (int j = 0; j < data.size(); j++) {
                String[] currentData = data.get(j);
                if (container.get(CATEGORIES[count]).contains(currentData[ORDER[count]].toLowerCase())) {
                    result.add(currentData);
                }
            }
        }
    }

    private void deleteFromResult(int count, ArrayList<String[]> data, ArrayList<String[]> result) {
        for (int i = 0; i < container.get(CATEGORIES[count]).size(); i++) {
            for (int j = 0; j < result.size(); j++) {
                String[] currentData = result.get(i);
                if (!container.get(CATEGORIES[count]).contains(currentData[ORDER[count]].toLowerCase())) {
                    result.remove(j);
                }
            }
        }

    }

    // Parameter: User's selected sorting preference
    // Select and sort the vehicle objects and store it in a LinkedHashSet
    private ArrayList<String[]> sort(int userSelectedSort, ArrayList<String[]> filteredList) {
        if (userSelectedSort == 1) {
            sortByNumber(filteredList, false, 8); // sort price from high to low
        } else if (userSelectedSort == 2) {
            sortByNumber(filteredList, true, 8); // sort price from low to high
        } else if (userSelectedSort == 3) {
            sortByNumber(filteredList, false, 3); // sort year from high to low
        } else if (userSelectedSort == 4) {
            sortByNumber(filteredList, true, 3); // sort year from low to high
        }
        return filteredList;
    }

    private void sortByNumber(ArrayList<String[]> filteredList, boolean lowToHigh, int index) {
        if (lowToHigh) {
            Collections.sort(filteredList, new Comparator<String[]>() {
                @Override
                public int compare(String[] o1, String[] o2) {
                    return Integer.valueOf(o1[index]) - Integer.valueOf(o2[index]);
                }
            });
        } else {
            Collections.sort(filteredList, new Comparator<String[]>() {
                @Override
                public int compare(String[] o1, String[] o2) {
                    return Integer.valueOf(o2[index]) - Integer.valueOf(o1[index]);
                }
            });
        }
    }

    private JPanel getVehicleDisplayPanel() {

        vehicleDisplayPanel=new JPanel(new GridLayout(5,5));
        vehicleDisplayPanel.setBackground(Color.yellow);
        vehicleDisplayPanel.add(new Label("vehical should be displayed here"));
        //code for UI for VehicalPanel;
        return vehicleDisplayPanel;
    }



    public static void main(String[] args) {
        SearchSort searchSortObj = new SearchSort();
        System.out.println("AppUI main starting...");
    }


}
