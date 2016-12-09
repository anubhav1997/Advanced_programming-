import java.awt.*;
import java.awt.List;

import java.awt.event.*;
import java.util.Iterator;

import javax.swing.*;

import java.util.*;

public class GUI {
	public static JFrame frame1;
	public static int query=0;
	public SAXParserDemo parser;
	public static int choice_year=0;
	public static int sort=0;
	//public static void main(String[] args){
	//	getframe();
	//}
	public static int choice;
	public static String name=null;
	public static int year=0, range1=0,range2=0,noofpub=-1;
	public static String author1,author2,author3,author4,author5;
	public static int q3_year;
	public static TextField f = new TextField();
	public void getframe(){	
		frame1 = new JFrame();
		//JPanel p = new JPanel();
		JLabel l = new JLabel("DBLP QUERY ENGINE",JLabel.CENTER);
		String[] query1 = {"Select Query","Query 1", "Query 2","Query 3"};
		JComboBox jbox = new JComboBox(query1);
		l.setBounds(300,20,300,75);
		//l.setBackground(Color.YELLOW);
		l.setFont(new Font("Serif", Font.PLAIN, 27));
		//JTextField results = new JTextField();
		jbox.setBounds(50,125,100,30);
		event1 e1 = new event1();
		jbox.addItemListener(e1);
		//p.add(l);
		//p.setBounds(10,10,100,700);
		frame1.add(l);
		frame1.add(jbox);
		
		//f.setBounds(350,100,600,600);
		//f.setBackground(Color.YELLOW);
		//frame1.add(f);
		if(query ==1){
			String[] searchby = {"Search by","Name/Title tag","Since some given year","Between two years"};
			JComboBox jbox2 = new JComboBox(searchby);
			jbox2.setBounds(50,175,150,30);
			event2 e2 = new event2();
			jbox2.addItemListener(e2);
			JPanel tbpanel = new JPanel();
			tbpanel.setLocation(400,100);
			tbpanel.setSize(550,550);
			tbpanel.setLayout(new BorderLayout());
			

			frame1.add(jbox2);
			tbpanel.add(BorderLayout.CENTER,new table());
			
			// tableSP.setPreferredSize(400);
			frame1.add(tbpanel);   
			final JTextField tname = new JTextField(15);
			JLabel lname= new JLabel("Name/Title Tags",JLabel.CENTER);
			tname.setBounds(135,215,100,30);
			lname.setBounds(30,215,100,30);
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
			lname3.setBounds(30,305,100,30);
			frame1.add(tname3);
			frame1.add(tname3b);
			frame1.add(lname3);
			frame1.add(lname3b);
			JRadioButton r1 = new JRadioButton("Sort By year");
			r1.setBounds(40,350,100,30);
			frame1.add(r1);
			event5 e5 = new event5();
			r1.addActionListener(e5);
			JRadioButton r2 = new JRadioButton("Sort By Relevance");
			r2.setBounds(40,390,200,30);
			frame1.add(r2);
			event6 e6 = new event6();
			r2.addActionListener(e6);
			JButton b1 = new JButton("Search");
			b1.setBounds(40,450,100,30);
			b1.setBackground(Color.BLACK);
			frame1.add(b1);
			
			class event3 implements ActionListener{
				///ArrayList<Journals> temp_data= new ArrayList<Journals>();
				
				public void actionPerformed(ActionEvent e){
					SAXParserDemo.Database.clear();
					if(choice==1){
						name = tname.getText();
						parser= new SAXParserDemo();
						//System.out.println(name);
						SAXParserDemo.callfunc();
					}
					else if(choice==2){
						parser= new SAXParserDemo();
						year = Integer.parseInt(tname2.getText());
						SAXParserDemo.callfunc();
						 
					}
					else if(choice==3){
						parser= new SAXParserDemo();
						
						range1 = Integer.parseInt(tname3.getText());
						range2 = Integer.parseInt(tname3b.getText());
						SAXParserDemo.callfunc();  
						
						
					}
					
				}
			}
			class event4 implements ActionListener{
				public void actionPerformed(ActionEvent e){
					name=null;
					year= 0;
					range1=0;
					range2=0;
					SAXParserDemo.Database.clear();
					f.setText(null);
					table.model.setRowCount(0);
					
				}
			}
			event3 e3 = new event3();
			b1.addActionListener(e3);
			JButton b2 = new JButton("Reset");
			b2.setBounds(150,450,100,30);
			b2.setBackground(Color.RED);
			event4 e4 = new event4();
			b2.addActionListener(e4);
			frame1.add(b2);
			
		}
		else if(query==2){
			final JTextField tname = new JTextField(15);
			JLabel lname = new JLabel("No. of publications",JLabel.CENTER);
			tname.setBounds(170,180,100,30);
			lname.setBounds(30,180,125,30);
			frame1.add(tname);
			frame1.add(lname);
			JPanel tbpanel = new JPanel();
			tbpanel.setLocation(400,100);
			tbpanel.setSize(550,550);
			tbpanel.setLayout(new BorderLayout());
			

			//frame1.add(jbox2);
			tbpanel.add(BorderLayout.CENTER,new table2());
			frame1.add(tbpanel);
			class event4 implements ActionListener{
				public void actionPerformed(ActionEvent e){
					Entityresol.alias1.clear();
					table2.model.setRowCount(0);
					noofpub = Integer.parseInt(tname.getText());
					Que2.call();
			    	int i=1;
					 for(Author au:Entityresol.alias1){
						 
						 if(au.pubs>=noofpub){
							 if(au.alias.toString()!=null){
								 table2.model.addRow(new Object[]{i++,au.alias.toString(),au.pubs});
							 }
						 }
					 }
					
				}
			}
			class event3 implements ActionListener{
				public void actionPerformed(ActionEvent e){
					noofpub=0;
					SAXParserDemo.Database.clear();
					f.setText(null);
					table2.model.setRowCount(0);
					
				}
			}
			JButton b1 = new JButton("Search");
			b1.setBounds(40,250,100,30);
			b1.setBackground(Color.BLACK);
			event4 e4 = new event4();
			b1.addActionListener(e4);
			frame1.add(b1);
			JButton b2 = new JButton("Reset");
			b2.setBounds(150,250,100,30);
			b2.setBackground(Color.RED);
			event3 e3 = new event3();
			b2.addActionListener(e3);
			
			frame1.add(b2);
		}
		else if(query==3){
			final JTextField tname = new JTextField(15);
			JLabel lname= new JLabel("Author 1",JLabel.CENTER);
			tname.setBounds(135,180,100,30);
			lname.setBounds(30,180,100,30);
			frame1.add(tname);
			frame1.add(lname);
			final JTextField tname2 = new JTextField(15);
			JLabel lname2 = new JLabel("Author 2",JLabel.CENTER);
			tname2.setBounds(135,215,100,30);
			lname2.setBounds(30,215,100,30);
			frame1.add(tname2);
			frame1.add(lname2);
			final JTextField tname3 = new JTextField(15);
			JLabel lname3= new JLabel("Author 3",JLabel.CENTER);
			tname3.setBounds(135,250,100,30);
			lname3.setBounds(30,250,100,30);
			frame1.add(tname3);
			frame1.add(lname3);
			final JTextField tname4 = new JTextField(15);
			JLabel lname4 = new JLabel("Author 4",JLabel.CENTER);
			tname4.setBounds(135,285,100,30);
			lname4.setBounds(30,285,100,30);
			frame1.add(tname4);
			frame1.add(lname4);
			final JTextField tname5 = new JTextField(15);
			JLabel lname5 = new JLabel("Author 5",JLabel.CENTER);
			tname5.setBounds(135,320,100,30);
			lname5.setBounds(30,320,100,30);
			frame1.add(tname5);
			frame1.add(lname5);
			final JTextField tname6 = new JTextField(15);
			JLabel lname6 = new JLabel("Year",JLabel.CENTER);
			tname6.setBounds(135,355,100,30);
			lname6.setBounds(30,355,100,30);
			frame1.add(tname6);
			frame1.add(lname6);
			JPanel tbpanel = new JPanel();
			tbpanel.setLocation(400,100);
			tbpanel.setSize(550,550);
			tbpanel.setLayout(new BorderLayout());
			

			//frame1.add(jbox2);
			tbpanel.add(BorderLayout.CENTER,new table3());
			frame1.add(tbpanel);
			class event4 implements ActionListener{
				public void actionPerformed(ActionEvent e){
					SAXParserDemo.Database.clear();
					author1 = tname.getText();
					author2 = tname2.getText();
					author3 = tname3.getText();
					author4 = tname4.getText();
					author5 = tname5.getText();
					q3_year = Integer.parseInt(tname6.getText());
					SAXParserDemo.callfunc();
				}
			}
			class event3 implements ActionListener{
				public void actionPerformed(ActionEvent e){
					SAXParserDemo.Database.clear();
					f.setText(null);
					table3.model.setRowCount(0);
					
				}
			}
			JButton b1 = new JButton("Search");
			b1.setBounds(40,420,100,30);
			b1.setBackground(Color.BLACK);
			event4 e4 = new event4();
			b1.addActionListener(e4);
			frame1.add(b1);
			JButton b2 = new JButton("Reset");
			b2.setBounds(150,420,100,30);
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
	
	public class event1 implements ItemListener{  
		public void itemStateChanged(ItemEvent itemEvent){
			frame1.setVisible(false);
			if(itemEvent.getItem().equals("Query 2")){
				//SAXParserDemo.Database.clear();
				f.setText(null);
				query=2;
				getframe();
				//table.model.setRowCount(0);
			}
			else if(itemEvent.getItem().equals("Query 1")){
				//SAXParserDemo.Database.clear();
				//f.setText(null);
				
				query=1;
				getframe();
				//table.model.setRowCount(0);
			}
			else if(itemEvent.getItem().equals("Query 3")){
				query=3;
				getframe();
			}
		}
	}
	public class event2 implements ItemListener{  
		public void itemStateChanged(ItemEvent itemEvent){
			//frame1.setVisible(false);
			if(itemEvent.getItem().equals("Name/Title tag")){
				//query=2;
				//getframe();
				choice=1;
				choice_year=1;
			}
			else if(itemEvent.getItem().equals("Since some given year")){
				choice =2;
				//choice_year=2;
				//getframe();
				
			}
			else if(itemEvent.getItem().equals("Between two years")){
				choice =3;
				//choice_year=3;
				//getframe();
				//System.out.println("hello");
			}
			
			
		}
	}
	class event5 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			sort=1;
		}
	}
	class event6 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			sort=2;
		}
	}
	public TextField gett(){
		return f;
	}
	public void sett(TextField f){
		GUI.f= f;
	}
	public int getchoice(){
		return choice;
	}
	public void setchoice(int choice){
		GUI.choice= choice;
	}
	public int getquery(){
		return query;
	}
	public void setquery(int query){
		this.query=query;
	}
}