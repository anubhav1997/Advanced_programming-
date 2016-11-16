import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GUI {
	public static JFrame frame1;
	public static int choice=0;
	
	public static void main(String[] args){
		getframe();
	}
	public static String name;
	public static int year, range1,range2,noofpub;
	
	public static void getframe(){	
		frame1 = new JFrame();
		JLabel l = new JLabel("DBLP QUERY ENGINE",JLabel.CENTER);
		String[] query = {"Select Query","Query 1", "Query 2"};
		JComboBox jbox = new JComboBox(query);
		l.setBounds(300,20,500,75);
		l.setFont(new Font("Serif", Font.PLAIN, 40));
		JTextField results = new JTextField();
		jbox.setBounds(50,125,160,30);
		event1 e1 = new event1();
		jbox.addItemListener(e1);
		frame1.add(l);
		frame1.add(jbox);
		if(choice ==1){
			String[] searchby = {"Search by"};
			JComboBox jbox2 = new JComboBox(searchby);
			jbox2.setBounds(50,175,100,30);
			frame1.add(jbox2);
			final JTextField tname = new JTextField(15);
			JLabel lname= new JLabel("Name/Title Tags",JLabel.CENTER);
			tname.setBounds(155,215,100,30);
			lname.setBounds(30,215,120,30);
			frame1.add(tname);
			frame1.add(lname);
			final JTextField tname2 = new JTextField(15);
			JLabel lname2 = new JLabel("Since Year",JLabel.CENTER);
			tname2.setBounds(135,260,100,30);
			lname2.setBounds(30,260,100,30);
			frame1.add(tname2);
			frame1.add(lname2);
			final JTextField tname3 = new JTextField(15);
			final JTextField tname3b = new JTextField(15);
			JLabel lname3 = new JLabel("Custom Range",JLabel.CENTER);
			tname3.setBounds(135,305,50,30);
			tname3b.setBounds(195,305,50,30);
			JLabel lname3b = new JLabel("-",JLabel.CENTER);
			lname3b.setBounds(185,305,10,30);
			lname3.setBounds(20,305,120,30);
			frame1.add(tname3);
			frame1.add(tname3b);
			frame1.add(lname3);
			frame1.add(lname3b);
			JRadioButton r1 = new JRadioButton("Sort By year");
			r1.setBounds(40,350,150,30);
			frame1.add(r1);
			JRadioButton r2 = new JRadioButton("Sort By Relevance");
			r2.setBounds(40,390,200,30);
			frame1.add(r2);
			JButton b1 = new JButton("Search");
			b1.setBounds(40,450,100,30);
			b1.setBackground(Color.BLACK);
			frame1.add(b1);
			class event2 implements ActionListener{
				public void actionPerformed(ActionEvent e){
					name = tname.getText();
					year = Integer.parseInt(tname2.getText());
					range1 = Integer.parseInt(tname3.getText());
					range2 = Integer.parseInt(tname3b.getText());
					//System.out.println(name+ year+range1+range2);
					
				}
			}
			class event3 implements ActionListener{
				public void actionPerformed(ActionEvent e){
					name=null;
					year= 0;
					range1=0;
					range2=0;
				}
			}
			event2 e2 = new event2();
			b1.addActionListener(e2);
			JButton b2 = new JButton("Reset");
			b2.setBounds(150,450,100,30);
			b2.setBackground(Color.RED);
			event3 e3 = new event3();
			b2.addActionListener(e3);
			frame1.add(b2);
			
		}
		else if(choice==2){
			final JTextField tname = new JTextField(15);
			JLabel lname = new JLabel("No. of publications",JLabel.CENTER);
			tname.setBounds(180,180,100,30);
			lname.setBounds(30,180,145,30);
			frame1.add(tname);
			frame1.add(lname);
			class event2 implements ActionListener{
				public void actionPerformed(ActionEvent e){
					noofpub = Integer.parseInt(tname.getText());
					//System.out.println(noofpub);
				
				}
			}
			class event3 implements ActionListener{
				public void actionPerformed(ActionEvent e){
					noofpub=0;
				}
			}
			JButton b1 = new JButton("Search");
			b1.setBounds(40,250,100,30);
			b1.setBackground(Color.BLACK);
			event2 e2 = new event2();
			b1.addActionListener(e2);
			frame1.add(b1);
			JButton b2 = new JButton("Reset");
			b2.setBounds(150,250,100,30);
			b2.setBackground(Color.RED);
			event3 e3 = new event3();
			b2.addActionListener(e3);
			
			frame1.add(b2);
		}
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setBounds(300,85,7,1000);
		frame1.getContentPane().add(splitPane);
		JSplitPane splitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPane2.setBounds(0,85,1000,10);
		frame1.getContentPane().add(splitPane2);
		frame1.setSize(1000,1000);
		frame1.setLayout(null);
		frame1.setVisible(true);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static class event1 implements ItemListener{  
		public void itemStateChanged(ItemEvent itemEvent){
			frame1.setVisible(false);
			if(itemEvent.getItem().equals("Query 2")){
				choice=2;
				getframe();
				
			}
			else if(itemEvent.getItem().equals("Query 1")){
				choice=1;
				getframe();
				
			}
		}
	}
	
}
