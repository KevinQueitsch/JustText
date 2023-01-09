import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.Label;
import javax.swing.JPanel;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
//import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

public class About {

	private JFrame frmClicker;
	private JTextField txtKevinQueitsch;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About window = new About();
					window.frmClicker.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public About() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClicker = new JFrame();
		frmClicker.setBackground(Color.WHITE);
		
		Image img = new ImageIcon(this.getClass().getResource("/Text-Edit-icon.png")).getImage();
		frmClicker.setIconImage(img);
		
		frmClicker.getContentPane().setBackground(Color.WHITE);
		frmClicker.setResizable(false);
		frmClicker.setTitle("About");
		frmClicker.setBounds(100, 100, 259, 137);
		
		JLabel lblNewLabel = new JLabel("Written by:");
		lblNewLabel.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		
		JLabel lblNewLabel_1 = new JLabel("Version:");
		lblNewLabel_1.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		
		JLabel lblNewLabel_2 = new JLabel("Date:");
		lblNewLabel_2.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		
		txtKevinQueitsch = new JTextField();
		txtKevinQueitsch.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		txtKevinQueitsch.setBackground(Color.WHITE);
		txtKevinQueitsch.setText("Kevin Queitsch");
		txtKevinQueitsch.setEditable(false);
		txtKevinQueitsch.setColumns(10);
		
		textField = new JTextField();
		textField.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		textField.setBackground(Color.WHITE);
		textField.setText("1.0");
		textField.setEditable(false);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Nirmala UI", Font.PLAIN, 11));
		textField_1.setBackground(Color.WHITE);
		textField_1.setText("2022");
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frmClicker.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtKevinQueitsch, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
						.addComponent(textField)
						.addComponent(textField_1))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtKevinQueitsch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_2))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		frmClicker.getContentPane().setLayout(groupLayout);
	}
}
