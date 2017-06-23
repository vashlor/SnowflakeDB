package com.vash.StarDB;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Search extends JFrame {
	private final int width = 800;
	private final int height = 600;
	private static final String[] types = {"Car Model", "Manufacturer", "Dealership"};
	private String[] labels;
	private JTextField tfQuery = null;
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private JComboBox<String> cbList = null;
	private JTable tSearch = null;
	private JPanel pResult = null;
	private JScrollPane scrollPane = null;
	private JPanel pMain = null;
	private Container pane = null;
	
	public Search(Connection conn){
		this.conn = conn;
		createGUI();
	}
	
	private void createGUI(){
		setTitle("Search Inventory");
		setSize(width, height);
		setBackground(Color.BLACK);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createPanels();
		
		setVisible(true);
	}
	
	private void createPanels(){
		JPanel pHeader = createHeader();
		pMain = createMain();
		JPanel pTail = createTail();
		
		pane = getContentPane();
		pane.add(pHeader, BorderLayout.NORTH);
		pane.add(pMain, BorderLayout.CENTER);
		pane.add(pTail, BorderLayout.SOUTH);
	}
	
	private JPanel createHeader(){
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension((int) (width*.1), (int) (height*.1)));
		panel.setBackground(Color.BLACK);
		JLabel title = new JLabel("Search Inventory");
		title.setForeground(Color.WHITE);
		title.setFont(new Font(App.FONT, Font.BOLD, 18));
		panel.add(title);
		return panel;
	}
	
	private JPanel createMain(){
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		
		JPanel pQuery = new JPanel();
		pQuery.setBackground(Color.DARK_GRAY);
		JLabel lQuery = new JLabel("Search");
		lQuery.setForeground(Color.WHITE);
		cbList = new JComboBox<String>(types);
		
		tfQuery = new JTextField(30);
		tSearch = new JTable(5, 10);
		KeyListener enter = new KeyListener(){
			public void keyTyped(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER){
					String text = tfQuery.getText();
					String type = cbList.getSelectedItem().toString();
					
					createScrollPane(text, type);
				}
			}

			public void keyReleased(KeyEvent e) {
			}
		};
		tfQuery.addKeyListener(enter);
		
		JButton bSearch = new JButton("Search");
		ActionListener aSearch = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = tfQuery.getText();
				String type = cbList.getSelectedItem().toString();
				
				createScrollPane(text, type);
			}
		};
		bSearch.addActionListener(aSearch);
		bSearch.setPreferredSize(new Dimension(100, 25));
		
		pQuery.add(lQuery);
		pQuery.add(cbList);
		pQuery.add(tfQuery);
		pQuery.add(bSearch);
		
		panel.add(pQuery, BorderLayout.NORTH);
		//panel.add(scrollPane, BorderLayout.CENTER);
		
		return panel;
	}
	
	private JPanel createTail(){
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setPreferredSize(new Dimension((int) (width*.1), (int) (height*.1)));
		
		JButton bExit = new JButton("Back");
		ActionListener aExit = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu menu = new MainMenu(conn);
				dispose();
			}
		};
		bExit.addActionListener(aExit);
		bExit.setPreferredSize(new Dimension(100, 25));
		
		panel.add(bExit);
		
		return panel;
	}

	private void createScrollPane(){
		scrollPane = new JScrollPane(); 
		scrollPane.setBackground(Color.DARK_GRAY);
		scrollPane.setPreferredSize(new Dimension((int) (width*.99f), (int) (height*.735f)));
		pMain.add(scrollPane, BorderLayout.CENTER);
	}
	
	private void createScrollPane(String text, String type){
		String query = "";
		
		switch (type){
		case "Car Model" :
			query = "call model('" + text + "');";
			labels = new String[]{"Name", "Street", "City", "State", "ZIP"};
			break;
		case "Manufacturer" :
			query = "call make('" + text + "');";
			labels = new String[]{"Name", "Street", "City", "State", "ZIP"};
			break;
		case "Dealership" :
			query = "SELECT * FROM dim_stores WHERE name LIKE '%" + text + "%';";
			labels = new String[]{"ID", "Name", "Street", "City", "State", "ZIP", "Specialty", "Stock"};
			break;
		}
		
		if (query == null || query.isEmpty()){
			System.out.println("Query statement is empty.");
		}
		else {
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(query);
				Object[][] data = new Object[100][100];
				for (int i = 0; rs.next(); i++){
					for(int j = 1; j <= rs.getMetaData().getColumnCount(); j++){
						data[i][j-1] = rs.getString(j);
					}
				}
				tSearch = new JTable(data, labels);
			} catch (SQLSyntaxErrorException e) {
				System.out.println("Incorrect search\n" + e);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (scrollPane != null){
			pMain.remove(scrollPane);
		}
		scrollPane = new JScrollPane(tSearch); 
		scrollPane.setBackground(Color.DARK_GRAY);
		scrollPane.setPreferredSize(new Dimension((int) (width*.99f), (int) (height*.735f)));
		pMain.add(scrollPane, BorderLayout.CENTER);
		invalidate();
		revalidate();
		repaint();
	}
	
	private JScrollPane Query(String text, String type){
		String query = "";
		JTable search = new JTable();
		
		switch (type){
		case "Query" :
			query  = text;
			break;
		case "Car Model" :
			query = "call model('" + text + "');";
			labels = new String[]{"ID", "Name", "Street", "City", "State", "ZIP"};
			break;
		case "Manufacturer" :
			query = "call make('" + text + "');";
			labels = new String[]{"ID", "Name", "Street", "City", "State", "ZIP"};
			break;
		case "Dealership" :
			query = "SELECT * FROM dim_stores WHERE name LIKE '%" + text + "%';";
			labels = new String[]{"ID", "Name", "Street", "City", "State", "ZIP", "Specialty", "Stock"};
			break;
		}
		
		if (query == null || query.isEmpty()){
			System.out.println("Query statement is empty.");
		}
		else {
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(query);
				Object[][] data = new Object[100][100];
				for (int i = 0; rs.next(); i++){
					for(int j = 1; j <= rs.getMetaData().getColumnCount(); j++){
						data[i][j-1] = rs.getString(j);
					}
				}
				search = new JTable(data, labels);
			} catch (SQLSyntaxErrorException e) {
				System.out.println("Incorrect search\n" + e);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		pMain.remove(scrollPane);
		JScrollPane pane = new JScrollPane(search); 
		pane.setBackground(Color.DARK_GRAY);
		pane.setPreferredSize(new Dimension((int) (width*.99f), (int) (height*.735f)));
		return pane;
	}
}
