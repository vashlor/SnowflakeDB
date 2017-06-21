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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Search extends JFrame {
	private static final String[] types = {"Query", "Car Model", "Manufacturer", "Dealership"};
	private JTextField tfQuery = null;
	private JTextArea taResult = null;
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private JComboBox<String> cbList = null;
	
	public Search(Connection conn){
		this.conn = conn;
		createGUI();
	}
	
	private void createGUI(){
		setTitle("Search Inventory");
		setSize(800, 600);
		setBackground(Color.BLACK);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createPanels();
		
		setVisible(true);
	}
	
	private void createPanels(){
		JPanel pHeader = createHeader();
		JPanel pMain = createMain();
		JPanel pTail = createTail();
		
		Container pane = getContentPane();
		pane.add(pHeader, BorderLayout.NORTH);
		pane.add(pMain, BorderLayout.CENTER);
		pane.add(pTail, BorderLayout.SOUTH);
	}
	
	private JPanel createHeader(){
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(100, 30));
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
		KeyListener enter = new KeyListener(){
			public void keyTyped(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER){
					String text = tfQuery.getText();
					String type = cbList.getSelectedItem().toString();
					
					Query(text, type);
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
				
				Query(text, type);
			}
		};
		bSearch.addActionListener(aSearch);
		bSearch.setPreferredSize(new Dimension(100, 25));
		
		
		pQuery.add(lQuery);
		pQuery.add(cbList);
		pQuery.add(tfQuery);
		pQuery.add(bSearch);

		JPanel pResult = new JPanel();
		pResult.setBackground(Color.DARK_GRAY);
		taResult = new JTextArea(25, 60);
		taResult.setEditable(false);
		pResult.add(taResult);
		JScrollPane scrollPane = new JScrollPane(pResult); 
		scrollPane.setBackground(Color.DARK_GRAY);
		
		panel.add(pQuery, BorderLayout.NORTH);
		panel.add(scrollPane, BorderLayout.CENTER);
		
		return panel;
	}
	
	private JPanel createTail(){
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		
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
	
	private void Query(String text, String type){
		taResult.setText("");
		
		String query = "";
		switch (type){
		case "Query" :
			query  = text;
			break;
		case "Car Model" :
			query = "call model('" + text + "');";
			break;
		case "Manufacturer" :
			query = "call make('" + text + "');";
			break;
		case "Dealership" :
			query = "SELECT * FROM dim_stores WHERE name LIKE '%" + text + "%';";
			break;
		}
		if (query == null || query.isEmpty()){
			taResult.setText("Query statement is empty.");
		}
		else {
			try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()){
				taResult.append(" | ");
				for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++){
					taResult.append(rs.getString(i) + " | ");
				}
				taResult.append("\n");
			}
			tfQuery.setText("");
			} catch (SQLSyntaxErrorException e) {
				taResult.setText("Incorrect search");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
