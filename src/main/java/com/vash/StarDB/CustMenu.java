package com.vash.StarDB;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CustMenu extends JFrame {
	private static final String[] labels = {"ID", "Name", "Street", "City", "State"};
	private final int width = 800;
	private final int height = 600;
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private JTable cust = null;
	
	public CustMenu(Connection conn){
		this.conn = conn;
		createGUI();
	}
	
	private void createGUI(){
		setTitle("Customer Information");
		setSize(width, height);
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
		panel.setPreferredSize(new Dimension((int) (width*.1), (int) (height*.1)));
		panel.setBackground(Color.BLACK);
		return panel;
	}
	
	private JPanel createMain(){
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		createTable();
		JScrollPane scrollPane = new JScrollPane(cust);
		scrollPane.setBackground(Color.DARK_GRAY);
		scrollPane.setPreferredSize(new Dimension((int) (width*.99f), (int) (height*.735f)));
		panel.add(scrollPane);
		
		return panel;
	}
	
	private JPanel createTail(){
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setPreferredSize(new Dimension((int) (width*.1), (int) (height*.1)));
		
		JButton bNew = new JButton("New Customer");
		ActionListener aNew = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustInfo cust = new CustInfo(conn);
				dispose();
			}
		};
		bNew.addActionListener(aNew);
		bNew.setPreferredSize(new Dimension(100, 25));
		
		JButton bExit = new JButton("Back");
		ActionListener aExit = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu menu = new MainMenu(conn);
				dispose();
			}
		};
		bExit.addActionListener(aExit);
		bExit.setPreferredSize(new Dimension(100, 25));
		
		panel.add(bNew);
		panel.add(bExit);
		
		return panel;
	}
	
	private void createTable(){
		Object[][] data = new Object[100][100];
		try {
			stmt = conn.createStatement();
			String query = "SELECT * FROM dim_cust;";
			rs = stmt.executeQuery(query);
			for (int i = 0; rs.next(); i++){
				for(int j = 1; j <= rs.getMetaData().getColumnCount(); j++){
					data[i][j-1] = rs.getString(j);
				}
			}
			} catch (SQLSyntaxErrorException e) {
				System.out.println("Incorrect search\n" + e);
			} catch (SQLException e) {
				e.printStackTrace();
		}
		cust = new JTable(data, labels);
		cust.getColumnModel().getColumn(0).setResizable(false);
		cust.getColumnModel().getColumn(0).setMaxWidth((int) (width*.05));
		cust.getColumnModel().getColumn(1).setResizable(false);
		cust.getColumnModel().getColumn(1).setMaxWidth((int) (width*.3));
		cust.getColumnModel().getColumn(2).setResizable(false);
		cust.getColumnModel().getColumn(2).setMaxWidth((int) (width*.4));
		cust.getColumnModel().getColumn(3).setResizable(false);
		cust.getColumnModel().getColumn(3).setMaxWidth((int) (width*.2));
		cust.getColumnModel().getColumn(4).setResizable(false);
		cust.getColumnModel().getColumn(4).setMaxWidth((int) (width*.05));
		cust.setEnabled(false);
	}
}
