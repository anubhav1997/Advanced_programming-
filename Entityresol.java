import java.io.*;
import java.util.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;



public class Entityresol 
{

	static List<Author> alias1 = new ArrayList<Author>();
	Author obj=new Author();
	int count=0;
	int pubs=0;

	public void resolution()
	{
		try
		{
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		SAXParser parser = parserFactory.newSAXParser();
	    DefaultHandler handler = new Parser();
	    parser.parse(new File("Dataset.xml"), handler);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (SAXException e){
			e.printStackTrace();
		}
		catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	public Entityresol()
	{
		resolution();
	}

	// public static void main(String args[])
	// {
	// 	new Entityresol();
	// 	for(Author o : Entityresol.alias1)
 // 			  			{

 // 			  				o.print();
 // 			  				 System.out.println("NEXT DATA");

 // 			  			}


	// }

	private class Parser extends DefaultHandler
	{


		public void startDocument()
		{
			System.out.println("Begin parsing");
		}

		public void endDocument()
		{
			System.out.println("End parsing");
		}

		boolean yes= false;
        boolean yes1=false;
        boolean yes3=false;

		@Override
		public void startElement(String uri, 
      	String localName, String qName, Attributes attributes)
        throws SAXException 
        {

        	if(qName.equalsIgnoreCase("www"))
        	{
        		yes=true;
        	}

        	if(qName.equalsIgnoreCase("author"))
        	{
        		yes1=true;
        		
        	}



        }

        @Override
  		 public void characters(char ch[], 
     	 int start, int length) throws SAXException {

     	 

     	 	if(yes==true && yes1==true)
     	 	{
     	 		String temp=new String (ch,start,length);
     	 		//System.out.println(temp);
     	 		obj.addname(temp);
     	 	}


  		 }


  		 	 @Override
   			public void endElement(String uri, 
     	 	String localName, String qName) throws SAXException 
 			  {

 			  		if (qName.equalsIgnoreCase("www"))
 			  		{
 			  			yes=yes1=false;
 			  			alias1.add(obj);
 			  			obj=new Author();

 			  		}


		    	

 			  }	




    }
	

}


