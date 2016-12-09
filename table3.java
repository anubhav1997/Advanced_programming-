	import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
	 
	public class table3 extends JPanel
	{
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public static JTable tab;
		public static DefaultTableModel model;
	    public table3()
	    {
	    	setBackground(Color.BLUE);
	    	setLayout(new BorderLayout());
	        //headers for the table
	        String[] columns = new String[] {
	            "S.NO.","Author","Expected publications"
	        };
	        
	        //actual data for the table in a 2d array
	        Object[][] data = new Object[][] {
	        };
	         
	        final Class[] columnClass = new Class[] {
	            Integer.class, String.class, String.class, Integer.class,
	            Integer.class, Integer.class, String.class, String.class
	        };
	 
	        //create table model with data
	        model = new DefaultTableModel(data, columns) {
	 
	            @Override
	            public boolean isCellEditable(int row, int column)
	            {
	                return false;
	            }
	 
	            @Override
	            public Class<?> getColumnClass(int columnIndex)
	            {
	                return columnClass[columnIndex];
	            }
	        };
	         

	       JTable tab = new JTable(model);    
		    add(BorderLayout.CENTER,new JScrollPane(tab));
		    //model.addRow(new Object[]{"abc","abc","abc","abc","abc"});
	    }

	      
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		//new table();
//	}

}
