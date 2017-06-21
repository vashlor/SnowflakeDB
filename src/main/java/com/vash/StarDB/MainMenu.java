package com.vash.StarDB;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainMenu extends JFrame {
	private JButton custInfo, search, logout;
	private Connection conn;
	
	public MainMenu(Connection conn){
		this.conn = conn;
		createGUI();
	}
	
	private void createGUI(){
		setTitle("Main Menu");
		setSize(480, 360);
		setMinimumSize(new Dimension(480, 360));
		setMaximumSize(new Dimension(480, 360));
		setResizable(false);
		setBackground(Color.BLACK);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		createPanels();
		setVisible(true);
	}
	
	private void createPanels(){
		JPanel pHeader = createHeader();
		
		JPanel pMain = createMain();
		
		JPanel pTail = createHeader();
		
		Container pane = getContentPane();
		pane.add(pHeader, BorderLayout.NORTH);
		pane.add(pMain, BorderLayout.CENTER);
		pane.add(pTail, BorderLayout.SOUTH);
	}
	
	private JPanel createMain(){
		JPanel date = createDate();
		
		JPanel panel = new JPanel();
		custInfo = new JButton("Customers");
		ActionListener aCust = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustInfo cust = new CustInfo(conn);
				dispose();
			}
		};
		custInfo.addActionListener(aCust);
		custInfo.setPreferredSize(new Dimension(100, 25));
		
		search = new JButton("Inventory");
		ActionListener aSearch = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search search = new Search(conn);
				dispose();
			}
		};
		search.addActionListener(aSearch);
		search.setPreferredSize(new Dimension(100, 25));
		
		logout = new JButton("Log Out");
		ActionListener aLogout = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogIn login = new LogIn();
				dispose();
			}
		};
		logout.addActionListener(aLogout);
		logout.setPreferredSize(new Dimension(100, 25));

		JPanel holder = new JPanel();
		holder.setBackground(Color.DARK_GRAY);
		holder.add(custInfo);
		holder.add(search);
		holder.add(logout);
		
		GridLayout layout = new GridLayout(3, 1);
		
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(layout);
		panel.add(date);
		panel.add(new JLabel());
		panel.add(holder);
		
		return panel;
	}
	
	private JPanel createDate(){
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setPreferredSize(new Dimension(100, 30));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDateTime time = LocalDateTime.now();
		String date = dtf.format(time);
		JLabel jDate = new JLabel(date);
		jDate.setForeground(Color.WHITE);
		jDate.setFont(new Font(App.FONT, Font.BOLD, 18));
		panel.add(jDate);
		
		return panel;
	}
	
	private JPanel createHeader(){
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(100, 30));
		panel.setBackground(Color.BLACK);
		return panel;
	}
}
