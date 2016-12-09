import java.io.*;
import java.util.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Que2 {

	Que2()
	{
		new Entityresol();
		try
		{
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		SAXParser parser = parserFactory.newSAXParser();
	    DefaultHandler handler = new Parse();
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

	public static void call() {
		new Que2();

	}


	private class Parse extends DefaultHandler
	{
			
			boolean author,article;
		
			
			public Parse() {

				author=false;
				article=false;
			


			}

			public void startDocument()
			{
				System.out.println("BEGINNN");
			}

		
			@Override
			public void startElement(String namespaceURI, String localName,String rawName, Attributes atts) throws SAXException {
				
				if (rawName.equalsIgnoreCase("article")||rawName.equalsIgnoreCase("inproceedings")||rawName.equalsIgnoreCase("proceedings")||rawName.equalsIgnoreCase("book")||rawName.equalsIgnoreCase("incollection")||rawName.equalsIgnoreCase("phdthesis")||rawName.equalsIgnoreCase("mastersthesis"))
				{
					article=true; 
				}

				if(rawName.equalsIgnoreCase("author"))
				{
					author=true;
				}
			}

			@Override
			public void characters(char ch[], int start, int length) throws SAXException {
				

					if(author)
					{
						String temp =new String(ch, start, length);
						publications(temp);
						author=false;	
					}
			}

		    @Override
		    public void endElement(String uri, String localName, String qName) throws SAXException {
		    	if (qName.equalsIgnoreCase("article")||qName.equalsIgnoreCase("inproceedings")||qName.equalsIgnoreCase("proceedings")||qName.equalsIgnoreCase("book")||qName.equalsIgnoreCase("incollection")||qName.equalsIgnoreCase("phdthesis")||qName.equalsIgnoreCase("mastersthesis")||qName.equalsIgnoreCase("www"))
		    	{
		    	 	article=false;	  
				}
		    	
// 		    	if(qName.equals("dblp"))
// 		    	{
// 		    		//System.out.println("YOOOO");
// //		    		printData();
// 		    	}

			      // System.out.println(x);
		    }

		public void publications(String s)
		{
			for(Author au : Entityresol.alias1)
			{
				for(String a : au.alias)
				{
					if(a.equals(s))
						{ au.pubs++;

							System.out.println(a + " " + au.pubs);
						}

				}

			}
		

		}

	}






}