import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

public class RegisterDialog extends JDialog{
	private JPanel contentPanel;
	private JTextField nameField;
	private JComboBox coachlist;
	private JTextField playerField;
	
	public RegisterDialog() {
	contentPanel = new JPanel();
	setTitle("Register Team");
	setContentPane(contentPanel);
	setBounds(100, 100, 400, 300);
	setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	contentPanel.setLayout(new GridLayout(5,1,5,5));
			JLabel lblNewLabel_0 = new JLabel("Enter team Information");
			contentPanel.add(lblNewLabel_0);
			JPanel namepane = new JPanel();
			namepane.setLayout(new GridLayout(1,2));
			JLabel lblNewLabel = new JLabel("Team Name:");
			namepane.add(lblNewLabel);
			nameField = new JTextField();
			nameField.setText("");
			nameField.setColumns(15);
			namepane.add(nameField);
			contentPanel.add(namepane);
			
			
			JPanel  coachPane = new JPanel();
			coachPane.setLayout(new GridLayout(1,2));
			JLabel lblNewLabel_1 = new JLabel("Coach: ");
			coachlist = new JComboBox();
			coachlist.addItem(" ");
			
			ReadFile r= new ReadFile("Coach.txt");
			ArrayList<String> coach_records = new ArrayList<String>();
			coach_records = r.getLines();
			
			for(int i =0; i<coach_records.size();i++){
				String record = coach_records.get(i);
				
				String[] Field = record.split("-");
				
				coachlist.addItem(Field[0]);
			}
			
			coachPane.add(lblNewLabel_1);
			coachPane.add(coachlist);
			contentPanel.add(coachPane);
			// number of play
			JPanel  playerPane= new JPanel();
			playerPane.setLayout(new GridLayout(1,2));
			JLabel lblNewLabel_2 = new JLabel("# Of Players");
			playerField = new JTextField();
			playerField.setText("");
			playerField.setColumns(5);
			playerPane.add(lblNewLabel_2);
			playerPane.add(playerField);
			
			contentPanel.add(playerPane);
			
			JPanel buttonPane= new JPanel();
			JButton add_b = new JButton("Add");
			JButton reset_b = new JButton("Reset");
			JButton cancel_b = new JButton("Cancel");
			
			//when cancel button is click, the window will automatic close
			ActionListener ButtonLister = new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if(e.getSource().equals(cancel_b)){
						dispose();
					}
					
					if(e.getSource().equals(reset_b)){
						nameField.setText("");
						playerField.setText("");
						coachlist.setSelectedIndex(0);
					}
					
					if(e.getSource().equals(add_b)){
						WriteFile f = new WriteFile();
						f.setFilename("Team.txt");
						String line = nameField.getText()+"-"+coachlist.getSelectedItem().toString()+"-"+playerField.getText();
						f.setLine(line);
						f.writeline();
						JOptionPane.showMessageDialog(null, line,"Tournament", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			};
			add_b.addActionListener(ButtonLister);
			reset_b.addActionListener(ButtonLister);
			cancel_b.addActionListener(ButtonLister);
			buttonPane.add(add_b);
			buttonPane.add(reset_b);
			buttonPane.add(cancel_b);
			contentPanel.add(buttonPane);
			
			setResizable(false);
			setVisible(true);
	
	}	
	


}
