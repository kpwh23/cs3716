import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class Main_Frame  extends JFrame{
	private JPanel content_panel;
	private JPanel list_panel;
	private JPanel button_panel;
	
	private JList tournament_list;
	private JButton create_b, refresh_b;
	private JButton register_b;
	private JButton registerCoach_b;
	private JButton view_b;
	
	private DefaultListModel tournament;
	
	private int frameWidth=600;
	private int frameHeight=400;
	
	public Main_Frame() {
		
		tournament = new DefaultListModel();
		setTitle("Volleyball Tournament");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,frameWidth,frameHeight);
		content_panel = new JPanel();
		content_panel.setBorder(new EmptyBorder(5,5,5,5));
		content_panel.setLayout(new GridLayout(1, 2, 10, 10));
		setContentPane(content_panel);
		
		tournament_list = new JList(tournament); //data has type Object[]
		tournament_list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tournament_list.setVisibleRowCount(-1);
		tournament_list.setFixedCellWidth((int)(0.45*frameWidth));
		
		readTournaments();
		
		
		JScrollPane listScroller = new JScrollPane(tournament_list);
		listScroller.setPreferredSize(new Dimension(250, 80));
		
		list_panel = new JPanel();
		list_panel.setLayout(new BorderLayout());
		list_panel.setBorder(new LineBorder(Color.BLACK));
		list_panel.setBackground(Color.WHITE);

		button_panel= new JPanel();
		button_panel.setLayout(new GridLayout(10,1));
		button_panel.setBounds(360,350,(int)(frameWidth/2),(int)(0.45*frameWidth));
		
		create_b = new JButton("Create Tournament");
		register_b= new JButton("Register Team");
		registerCoach_b = new JButton("RegisterCoach");
		refresh_b = new JButton("Refresh");
		view_b= new JButton("Select Tournament");
		
		// actionlister for the button
		ActionListener ButtonListener = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(register_b)){
					new RegisterDialog();
				}
				else if (e.getSource().equals(create_b)){
					new CreateTournamentDialog(tournament);
				}
				
				else if(e.getSource().equals(registerCoach_b)){
					new CoachDialog();
				}
				
				else if(e.getSource().equals(refresh_b)){
					tournament.clear();
					readTournaments();
				}
				else if(e.getSource().equals(view_b)){
					new Tournament_Frame(tournament_list.getSelectedValue().toString());
				}
			}
		};
		
		ListSelectionListener listListener = new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		};
		register_b.addActionListener(ButtonListener);
		create_b.addActionListener(ButtonListener);
		registerCoach_b.addActionListener(ButtonListener);
		view_b.addActionListener(ButtonListener);
		refresh_b.addActionListener(ButtonListener);
		
		list_panel.add(tournament_list);
		button_panel.add(create_b);
		button_panel.add(registerCoach_b);
		button_panel.add(register_b);
		button_panel.add(view_b);
		button_panel.add(refresh_b);
		
		content_panel.add(list_panel);
		content_panel.add(button_panel);
		
		
		
		
	}
	
	private void readTournaments() {
		ReadFile r= new ReadFile("Tournament.txt");
		ArrayList<String> tournament_records = new ArrayList<String>();
		tournament_records = r.getLines();
		
		for(int i =0; i<tournament_records.size();i++){
			String record = tournament_records.get(i);
			
			String[] Field = record.split("-");
			
			tournament.addElement(Field[0]);
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Frame frame = new Main_Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
