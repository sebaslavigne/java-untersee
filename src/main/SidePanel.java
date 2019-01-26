package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import commons.Screen;

/**
*@author Sebas Lavigne
*/

public class SidePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private GamePanel dataPanel;
	private JPanel commandPanel;
	
	private JTextField commandLine;
	private JTextArea log;
	
	public void initializePanel() {
		this.setLayout(new GridBagLayout());
		dataPanel = new GamePanel();
		commandPanel = new JPanel();
	}
	
	public void initializeComponents() {
		GridBagConstraints settings;
		
		settings = new GridBagConstraints();
		settings.fill = GridBagConstraints.BOTH;
		settings.weightx = 1;
		settings.weighty = 1;
		this.add(dataPanel, settings);
		
		commandPanel.setLayout(new GridBagLayout());
		commandPanel.setBackground(Color.RED);
		settings = new GridBagConstraints();
		settings.fill = GridBagConstraints.BOTH;
		settings.gridy = 1;
		this.add(commandPanel, settings);
		
		log = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(log);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		log.setBackground(Color.GREEN);
		log.setRows(10);
		settings = new GridBagConstraints();
		settings.fill = GridBagConstraints.BOTH;
		settings.weightx = 1;
		settings.weighty = 1;
		commandPanel.add(scrollPane, settings);
		
		commandLine = new JTextField();
		commandLine.setMinimumSize(new Dimension(20, 20));
		commandLine.setColumns(20);
		settings = new GridBagConstraints();
		settings.gridy = 1;
		settings.fill = GridBagConstraints.BOTH;
		settings.weightx = 1;
		settings.weighty = 1;
		commandPanel.add(commandLine, settings);
		
	}
	
	public void initializeListeners() {
		
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		dataPanel.repaint();
	}




	/**
	 * @return the currentScreen
	 */
	public Screen getCurrentScreen() {
		return dataPanel.getCurrentScreen();
	}

	/**
	 * @param currentScreen the currentScreen to set
	 */
	public void setCurrentScreen(Screen currentScreen) {
		dataPanel.setCurrentScreen(currentScreen);
	}

}