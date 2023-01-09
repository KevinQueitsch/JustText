import java.awt.Desktop;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JEditorPane;
import java.awt.Font;
import java.awt.Image;
import java.awt.Scrollbar;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.JProgressBar;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseWheelEvent;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;

public class Gui {

	private JFrame frmJusttext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frmJusttext.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	private Gui() {
		initialize(); 
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJusttext = new JFrame();
		
		Image img = new ImageIcon(this.getClass().getResource("/Text-Edit-icon.png")).getImage();
		frmJusttext.setIconImage(img);

		frmJusttext.setBackground(Color.WHITE);
		frmJusttext.setResizable(false);
		frmJusttext.setTitle("JustText");
		frmJusttext.setBounds(100, 100, 894, 579);
		
		// Mein Code
		frmJusttext.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		frmJusttext.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// Ask for confirmeation before termination the programm.
				int option = JOptionPane.showConfirmDialog(frmJusttext, 
						"Are you sure you want to close the application?", 
						"JustText",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if(option == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
						
			}
		});
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(Color.WHITE);
		frmJusttext.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setFont(new Font("Nirmala UI", Font.PLAIN, 12));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItemOpen = new JMenuItem("Open");
		mntmNewMenuItemOpen.setFont(new Font("Nirmala UI", Font.PLAIN, 12));
		mnNewMenu.add(mntmNewMenuItemOpen);
		
		JMenuItem mntmNewMenuItemSaveAs = new JMenuItem("Save As");
		mntmNewMenuItemSaveAs.setFont(new Font("Nirmala UI", Font.PLAIN, 12));
		mnNewMenu.add(mntmNewMenuItemSaveAs);
		
		JMenu mnNewMenuSettings = new JMenu("Settings");
		mnNewMenuSettings.setFont(new Font("Nirmala UI", Font.PLAIN, 12));
		menuBar.add(mnNewMenuSettings);
		
		JMenu mnNewMenuFontSelect = new JMenu("Font");
		mnNewMenuFontSelect.setFont(new Font("Nirmala UI", Font.PLAIN, 12));
		mnNewMenuSettings.add(mnNewMenuFontSelect);
		
		JMenuItem mntmNewMenuArial = new JMenuItem("Arial");
		mntmNewMenuArial.setFont(new Font("Arial", Font.PLAIN, 12));
		mnNewMenuFontSelect.add(mntmNewMenuArial);
		
		JMenuItem mntmNewMenuSegoeUI = new JMenuItem("Segoe UI");
		mntmNewMenuSegoeUI.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnNewMenuFontSelect.add(mntmNewMenuSegoeUI);
		
		JMenuItem mntmNewMenuItemTimesNewRoman = new JMenuItem("Times New Roman");
		mntmNewMenuItemTimesNewRoman.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		mnNewMenuFontSelect.add(mntmNewMenuItemTimesNewRoman);
		
		JMenuItem mntmNewMenuItemCourierNew = new JMenuItem("Courier New");
		mntmNewMenuItemCourierNew.setFont(new Font("Courier New", Font.PLAIN, 12));
		mnNewMenuFontSelect.add(mntmNewMenuItemCourierNew);
		
		JMenuItem mntmNewMenuItemJetBrainsMono = new JMenuItem("JetBrains Mono");
		mntmNewMenuItemJetBrainsMono.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		mnNewMenuFontSelect.add(mntmNewMenuItemJetBrainsMono);
		
		JMenu mnNewMenu_2 = new JMenu("About");
		mnNewMenu_2.setFont(new Font("Nirmala UI", Font.PLAIN, 12));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItemAbout = new JMenuItem("About");
		mntmNewMenuItemAbout.setFont(new Font("Nirmala UI", Font.PLAIN, 12));
		mnNewMenu_2.add(mntmNewMenuItemAbout);
		frmJusttext.getContentPane().setLayout(null);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(Color.WHITE);
		
		editorPane.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		editorPane.setBounds(1, 1, 877, 499);
		frmJusttext.getContentPane().add(editorPane);
		
		
		JScrollPane scrollpane = new JScrollPane(editorPane);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		frmJusttext.getContentPane().add(scrollpane);
		scrollpane.setBounds(1, 1, 877, 499);
		
		
		// Open About Gui
		
		mntmNewMenuItemAbout.addActionListener(ActionEvent -> {
			About ab = new About();
			ab.main(null);
		});
		
		// Write a FILE
		mntmNewMenuItemSaveAs.addActionListener(ActionEvent -> {
			JFileChooser chooser = new JFileChooser();
			int optionSave = chooser.showSaveDialog(editorPane);
			
			if(optionSave == JFileChooser.APPROVE_OPTION) {
				File selectedFile = chooser.getSelectedFile();
				FileWriter fw = null;
				try {
					fw = new FileWriter(selectedFile);
					fw.write(editorPane.getText());
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if(fw != null) {
						try {
							fw.close();
						} catch (IOException e) {
						}
					}
				}
			}
			
		});
		
		// Read a FILE 
		mntmNewMenuItemOpen.addActionListener(ActionEvent -> {
			JFileChooser chooser = new JFileChooser();
			int optionOpen = chooser.showOpenDialog(editorPane);
			
			if(optionOpen == JFileChooser.APPROVE_OPTION) {
				File selectedFile = chooser.getSelectedFile();
				
				BufferedReader reader;
				StringBuilder sb = new StringBuilder();
				try {
					reader = new BufferedReader(new FileReader(selectedFile));
					String line = reader.readLine();
					while(line != null) {
						sb.append(line);
						sb.append(System.lineSeparator());
						line = reader.readLine();
					}
					editorPane.setText(sb.toString());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
			
		});
		
		
		// Select Font Arial
		mntmNewMenuArial.addActionListener(ActionEvent -> {
			editorPane.setFont(new Font("Arial", Font.PLAIN, 12));
		});
		
		// Select Font Segoe UI 
		mntmNewMenuSegoeUI.addActionListener(ActionEvent -> {
			editorPane.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		});
		
		
		// Select Font Time New Roman
		mntmNewMenuItemTimesNewRoman.addActionListener(ActionEvent -> {
			editorPane.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		});
		
		// Select Font Courier New
		mntmNewMenuItemCourierNew.addActionListener(ActonEvent -> {
			editorPane.setFont(new Font("Courier New", Font.PLAIN, 12));
		});
		
		// Select Font JetBrains Mono 
		mntmNewMenuItemJetBrainsMono.addActionListener(ActionEvent -> {
			editorPane.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
		});
		
	}
}
