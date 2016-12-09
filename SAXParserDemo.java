import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.*;
public class SAXParserDemo {
   static List<Journals> Database = new ArrayList<Journals>();
   static Journals obj=new Journals(); ;
  
   //static String authorsearch=null;
   static int flag=0;

   public static int year, range1,range2,noofpub,choice,query;
   public static String name;
   public static GUI gui;
   public static void main(String[] args)
   {
     //callfunc();
     
      gui = new GUI();
      
      String s = null;
      gui.getframe();
      name=gui.name;
      noofpub= gui.noofpub;
      range1=gui.range1;
      range2=gui.range2;
      year=gui.year;
      choice=gui.choice;
      query=gui.query;

   } 
   public static void callfunc(){
     try {  
          
         File inputFile = new File("Dataset.xml");
           SAXParserFactory factory = SAXParserFactory.newInstance();
           SAXParser saxParser = factory.newSAXParser();
           UserHandler userhandler = new UserHandler();
           saxParser.parse(inputFile, userhandler);     
        } catch (Exception e) {
           e.printStackTrace();
        } 
   }
}

class UserHandler extends DefaultHandler {

      boolean author = false;
      boolean title = false;
      boolean pages = false;
      boolean year = false;
      boolean volume = false;
      boolean journal = false;
      boolean number = false;
      boolean url = false;
      boolean ee = false;
      boolean booktitle = false;
      boolean crossref = false;
      boolean school = false;
     

  public void startDocument()
    {
          System.out.println("Begin Parsing ...........");
      }

  public void endDocument()
  {
    System.out.println("End parsing document ..");
  }

   @Override
   public void startElement(String uri, 
      String localName, String qName, Attributes attributes)
         throws SAXException {

//
         // System.out.println("In startElement");

         // System.out.println(qName);

      

      if (qName.equalsIgnoreCase("article")) {
         // System.out.println("1");
         String key = attributes.getValue("key");
         String mdate=attributes.getValue("mdate");
         SAXParserDemo.obj.setmdate(mdate);
         
         //System.out.printf("Key: %s\n",key);

      }

  if (qName.equalsIgnoreCase("www")) {
         /// System.out.println("11414");
         String key = attributes.getValue("key");
         String mdate=attributes.getValue("mdate");
   //SAXParserDemo.obj.setmdate(mdate);
         //System.out.printf("Key: %s\n",key);

      }

  if (qName.equalsIgnoreCase("inproceeding")) {
        //System.out.println("1");
         String key = attributes.getValue("key");
         String mdate=attributes.getValue("mdate");
   SAXParserDemo.obj.setmdate(mdate);
         //System.out.printf("Key: %s\n",key);

      }

  if (qName.equalsIgnoreCase("incollection")) {
        //System.out.println("1");
         String key = attributes.getValue("key");
         String mdate=attributes.getValue("mdate");
  SAXParserDemo.obj.setmdate(mdate);
         //System.out.printf("Key: %s\n",key);

      } 

  if (qName.equalsIgnoreCase("phdthesis")) {
          //System.out.println("11414");
         String key = attributes.getValue("key");
         String mdate=attributes.getValue("mdate");
   SAXParserDemo.obj.setmdate(mdate);
        // System.out.printf("Key: %s\n",key);

      }

  if (qName.equalsIgnoreCase("booktitle")) {
                   //System.out.println("1313");
         booktitle = true;
      }

      if (qName.equalsIgnoreCase("school")) {
                   //System.out.println("1313");
         school = true;
      }

       if (qName.equalsIgnoreCase("crossref")) {
                  // System.out.println("1212");
         crossref = true;
      }



      if (qName.equalsIgnoreCase("AUTHOR")) {
                   //System.out.println("2");
         author = true;
      }

      if (qName.equalsIgnoreCase("TITLE")) {
                   //System.out.println("3");
         title = true;
      }

      if (qName.equalsIgnoreCase("PAGES")) {
                  // System.out.println("4");
         pages = true;
      }

      if (qName.equalsIgnoreCase("YEAR")) {
                  // System.out.println("5");
         year = true;
      }

      if (qName.equalsIgnoreCase("VOLUME")) {
                  // System.out.println("6");
         volume = true;
      }


      if (qName.equalsIgnoreCase("JOURNAL")) 
      {
                  // System.out.println("7");
         journal = true;
      }

      if (qName.equalsIgnoreCase("NUMBER")) 
      {
                  // System.out.println("8");
         number = true;
      }

      if (qName.equalsIgnoreCase("URL")) {
                  // System.out.println("9");
         url = true;
      }
      if (qName.equalsIgnoreCase("EE")) {
                  // System.out.println("10");
         ee = true;
      }

   }

   @Override
   public void endElement(String uri, 
      String localName, String qName) throws SAXException {

       //System.out.println("In endElement");
        //System.out.println(qName);   

       
        
       if(GUI.choice==1){
         //System.out.println(GUI.name);
         if(qName.equalsIgnoreCase("article") || qName.equalsIgnoreCase("inproceedings") || qName.equalsIgnoreCase("incollection") || qName.equalsIgnoreCase("phdthesis"))
           {
          
            if(SAXParserDemo.flag==1)
            {
               
              SAXParserDemo.Database.add(SAXParserDemo.obj);
               
               SAXParserDemo.flag=0;
            }
            SAXParserDemo.obj=new Journals();
           }
         if(qName.equalsIgnoreCase("title")){
           
           //System.out.println(SAXParserDemo.flag);
           if(SAXParserDemo.flag==2 || SAXParserDemo.obj.gettitle().equalsIgnoreCase(GUI.name) || SAXParserDemo.obj.gethits()>1){
                System.out.println(SAXParserDemo.flag);
                SAXParserDemo.Database.add(SAXParserDemo.obj);
                      //System.out.println(SAXParserDemo.obj.gettitle());
                SAXParserDemo.obj=new Journals();
                SAXParserDemo.flag=0;
            }
           }
       }
       else if(GUI.choice==2){
         //sinceyear(GUI.year);
         if(qName.equalsIgnoreCase("article") || qName.equalsIgnoreCase("inproceedings") || qName.equalsIgnoreCase("incollection") || qName.equalsIgnoreCase("phdthesis"))
           {
           if(SAXParserDemo.obj.getmdate()!=null){
        	 String[] temp = SAXParserDemo.obj.getmdate().split("-");
           int mdate1= Integer.parseInt(temp[0]);
           if(mdate1>GUI.year){
             SAXParserDemo.Database.add(SAXParserDemo.obj);
                   //System.out.println(SAXParserDemo.obj.gettitle());
             
                
           }
           }
           SAXParserDemo.obj=new Journals();
           }
         sinceyear(GUI.year);
           }
       else if(GUI.choice==3){
       
        if(qName.equalsIgnoreCase("article") || qName.equalsIgnoreCase("inproceedings") || qName.equalsIgnoreCase("incollection") || qName.equalsIgnoreCase("phdthesis"))
           {
           String[] temp = SAXParserDemo.obj.getmdate().split("-");
           int mdate1= Integer.parseInt(temp[0]);
           if(mdate1>GUI.range1 && mdate1<GUI.range2){
             SAXParserDemo.Database.add(SAXParserDemo.obj);
                   //System.out.println(SAXParserDemo.obj.gettitle());
             
                
           }
           SAXParserDemo.obj=new Journals();
           }
         between(GUI.range1,GUI.range2);
       }
        //Iterator<Journals> it = SAXParserDemo.Database.iterator();
       // while(it.hasNext())
       // {
        /// Journals o = (Journals)it.next();
          //System.out.println(o.getauth()+ " " + o.gettitle());
        //}
       if(GUI.sort==1){
         sortbydate();
       }

       if(GUI.sort==2)
       {
        sortbyrel();
       }
       if(GUI.query==3){
    	   if(qName.equalsIgnoreCase("article") || qName.equalsIgnoreCase("inproceedings") || qName.equalsIgnoreCase("incollection") || qName.equalsIgnoreCase("phdthesis"))
           {
           if(SAXParserDemo.obj.getmdate()!=null){
        	 String[] temp = SAXParserDemo.obj.getmdate().split("-");
           int mdate1= Integer.parseInt(temp[0]);
           if(mdate1<GUI.q3_year && (SAXParserDemo.obj.getauthor().contains(GUI.author1)||SAXParserDemo.obj.getauthor().contains(GUI.author2)||SAXParserDemo.obj.getauthor().contains(GUI.author3)||SAXParserDemo.obj.getauthor().contains(GUI.author4)||SAXParserDemo.obj.getauthor().contains(GUI.author5))){
             SAXParserDemo.Database.add(SAXParserDemo.obj);
                   //System.out.println(SAXParserDemo.obj.gettitle());
           }
           }
           SAXParserDemo.obj=new Journals();
           }
    	   
    	   String author1,author2,author3,author4,author5;
    	   author1 = GUI.author1;
    	   author2 = GUI.author2;
    	   author3 = GUI.author3;
    	   author4 = GUI.author4;
    	   author5 = GUI.author5;
    	   table3.model.setRowCount(0);
    	   int i=1;
    	   //System.out.println("helloo");
    	   table3.model.addRow(new Object[]{i++,"abc","abc"});
           
       }
       if(GUI.query==1){
       String s=null;

       int i=0,j=0;
       table.model.setRowCount(0);
       for(Journals o:SAXParserDemo.Database){
        //s = s+ o.toString();
        //s = s + "\n";
        //s = s+"\n \n \n";
        String[] temp=null;
         if(o.getmdate()!=null){
            
            temp= o.getmdate().split("-");
              int mdate1= Integer.parseInt(temp[0]);
         } 
         if(o.getauthor().toString()!=null )
         {
           // try{
            	table.model.addRow(new Object[]{i++,o.getauthor().toString(),o.gettitle(),o.getpages(),temp[0],o.getvolume(),o.getjournal(),o.geturl()});
           // }
            //catch(NullPointerException e){
            	//System.out.println("abc");
            	//j=1;
           // 	break;
            	
           // }
            
         }
         else
         {
          System.out.println("NULLL");
         }
        // if(j==1){
        	// break;
         //}
         GUI.f.setText(s);
         }
         //table.model.addRow(new Object[]{i++,o.getauthor().toString(),o.gettitle(),o.getpages(),temp[0],o.getvolume(),o.getjournal(),o.geturl()});
       }
       //gui=new GUI();
     
   }
   public void sortbydate(){
    class CustomComparator implements Comparator<Journals> {
      //@Override
        public int compare(Journals o1, Journals o2) {
            return -(o1.getmdate().compareTo(o2.getmdate()));
        }
    };
    Collections.sort(SAXParserDemo.Database, new CustomComparator());
    
    //String temp = SAXParserDemo.Database.get(0).getmdate().split("-");
   }

   public void sortbyrel(){

    class CustomComparator implements Comparator<Journals> {
      //@Override
        public int compare(Journals o1, Journals o2) {
            return o2.gethits()-o1.gethits();
        }
    };
    Collections.sort(SAXParserDemo.Database, new CustomComparator());
    
    //String temp = SAXParserDemo.Database.get(0).getmdate().split("-");
   }


   
   



   public void between(int a,int b){
     if(SAXParserDemo.Database!=null){
       Iterator it = SAXParserDemo.Database.iterator();
         while(it.hasNext()){
           Journals o = (Journals)it.next();
             String[] temp = o.getmdate().split("-");
             int mdate1= Integer.parseInt(temp[0]);
             //System.out.println(mdate1);
             if(!(mdate1<b &&mdate1>a)){
         SAXParserDemo.Database.remove(o);
       }
     }
     }
   }
   public void sinceyear(int a){
     for(Journals o : SAXParserDemo.Database){
       String[] temp = o.getmdate().split("-");
       int mdate1= Integer.parseInt(temp[0]);
       if(!(mdate1>a)){
         SAXParserDemo.Database.remove(o);
       }
     }
     
   }
   public void tillyear(int a){
	   for(Journals o : SAXParserDemo.Database){
	       String[] temp = o.getmdate().split("-");
	       int mdate1= Integer.parseInt(temp[0]);
	       if((mdate1>a)){
	         SAXParserDemo.Database.remove(o);
	       }
	     }
	       
   }
   @Override
   public void characters(char ch[], 
      int start, int length) throws SAXException {
      String temp1;
      String temp2;
      String temp3;
      String temp4;
      String temp5;
      String temp6;
      String temp7;
      String temp8;
      String temp9;
      String temp10;
      String temp11;
      String temp12;
     // String temp10;

       //System.out.println("In characters");

            if (author) {
              //System.out.println(GUI.name+" "+GUI.choice);
         temp1=new String(ch,start,length);
         if(temp1.equals( GUI.name)&& GUI.choice==1)
         {
            System.out.println("FLAG SET");
            System.out.println(temp1);
            SAXParserDemo.flag=1;
         }

         //System.out.println("11");
         SAXParserDemo.obj.setauth(temp1);
         //System.out.println(obj.getauth());
         //System.out.println("Author Name : " + temp1);
         author = false;
      }

      if (title) {
        int hits=0;
        if(GUI.choice==1){
         String[] rel =(GUI.name).split(" ");
          temp2=new String(ch,start,length);
          String[] name=temp2.split("\\s+");
          int hit=0;
          for(String a :  rel)
          {
            for(String b : name)
            {
              if(a.equals(b))
              {
                hits++;
                if(b.equalsIgnoreCase("are")||b.equalsIgnoreCase("the")||b.equalsIgnoreCase("is")||b.equalsIgnoreCase("and")||b.equalsIgnoreCase("in")||b.equalsIgnoreCase("a"))
                  hit--;
              }
            }
          }
          

          if(hit>1)
          {
            SAXParserDemo.flag=2;
          }
        
          SAXParserDemo.obj.sethits(hits);
         SAXParserDemo.obj.settitle(temp2);
         if(temp2.equals( SAXParserDemo.name)&& GUI.choice==1)
         {
            SAXParserDemo.flag=2;
         }
         //System.out.println("Title : " + temp2);
         title = false;
        }
        }

      if (pages) {
          temp3=new String(ch,start,length);
          //System.out.println("13");

         SAXParserDemo.obj.setpages(temp3);

         

         //System.out.println("Pages : " + temp3);
         pages  = false;
      }

      if (year) {
         temp4=new String(ch,start,length);
         //System.out.println("14");
         SAXParserDemo.obj.setyear(temp4);
         //System.out.println("YEAR : " + temp4);
         year = false;
      }

      if (volume) {
          temp5=new String(ch,start,length);
          //System.out.println("15");
         SAXParserDemo.obj.setvolume(temp5);
        // System.out.println("Volume : " +temp5);
         volume = false;
      }

      if (journal) {
         temp6=new String(ch,start,length);
        // System.out.println("16");
         SAXParserDemo.obj.setjournal(temp6);
        // System.out.println("Journal : " + temp6);
         journal = false;
      }

      if (number) {
         temp7=new String(ch,start,length);
         //System.out.println("17");
         SAXParserDemo.obj.setnumber(temp7);
         //System.out.println("Number : " +temp7);
         number  = false;
      }

      if (url) 
      {
          temp8=new String(ch,start,length);
         // System.out.println("18");
         SAXParserDemo.obj.seturl(temp8);
        // System.out.println("URL : " + temp8);
         url = false;
      }

      if (ee) 
      {

       temp9=new String(ch,start,length);
      // System.out.println("19");
        SAXParserDemo.obj.setee(temp9);
         // System.out.println("Hello");
       //  System.out.println("EE : " + temp9);
         ee = false;
      }
}


}