import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
public class parsexml {
    public static void main(String argv[]) {
    try {

    SAXParserFactory factory = SAXParserFactory.newInstance();
	SAXParser saxParser = factory.newSAXParser();

	DefaultHandler handler = new DefaultHandler() 
	{
		boolean author = false;
		boolean title = false;
		boolean pages = false;
		boolean year = false;
		boolean volume = false;
		boolean journal = false;
		boolean number = false;
		boolean url = false;
		boolean ee = false;

		public void startElement(String uri, String localName,String qName,Attributes attributes) throws SAXException {

		//System.out.println("Start Element :" + qName);

		if (qName.equalsIgnoreCase("AUTHOR")) {
			author = true;
		}

		if (qName.equalsIgnoreCase("TITLE")) {
			title = true;
		}

		if (qName.equalsIgnoreCase("PAGES")) {
			pages = true;
		}

		if (qName.equalsIgnoreCase("YEAR")) {
			year = true;
		}

		if (qName.equalsIgnoreCase("VOLUME")) {
			volume = true;
		}


		if (qName.equalsIgnoreCase("JOURNAL")) {
			journal = true;
		}

		if (qName.equalsIgnoreCase("NUMBER")) {
			number = true;
		}

		if (qName.equalsIgnoreCase("URL")) {
			url = true;
		}
		if (qName.equalsIgnoreCase("EE")) {
			ee = true;
		}
		
	}

		public void endElement(String uri, String localName,String qName) throws SAXException {

														}

		public void characters(char ch[], int start, int length) throws SAXException {

		if (author) {
			System.out.println("Author Name : " + new String(ch, start, length));
			author = false;
		}

		if (title) {
			System.out.println("Title : " + new String(ch, start, length));
			title = false;
		}

		if (pages) {
			System.out.println("Pages : " + new String(ch, start, length));
			pages  = false;
		}

		if (year) {
			System.out.println("YEAR : " + new String(ch, start, length));
			year = false;
		}

		if (volume) {
			System.out.println("Volume : " + new String(ch, start, length));
			volume = false;
		}

		if (journal) {
			System.out.println("Journal : " + new String(ch, start, length));
			journal = false;
		}

		if (number) {
			System.out.println("Number : " + new String(ch, start, length));
			number  = false;
		}

		if (url) {
			System.out.println("URL : " + new String(ch, start, length));
			url = false;
		}

		if (ee) {
			System.out.println("EE : " + new String(ch, start, length));
			ee = false;
		}

	}


    };

    saxParser.parse("Dataset.xml", handler);
	}
	catch (Exception e) {
       e.printStackTrace();
	}

	}
	
}
