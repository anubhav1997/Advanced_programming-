import java.io.*;
import java.util.*;


public class Que3
{
	linear q1;


	public static double predval;

	List<Double> year = new ArrayList<Double>();
	List<Double> Journals = new ArrayList<Double>();


	public Que3(String filename, Double y)
	{
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) 
		{
		    String line;	
		    String[] splitter;
		    while ((line = br.readLine()) != null) 
		    {
		    
		       splitter = line.split(" ");
		       year.add(Double.parseDouble(splitter[0]));
		       Journals.add(Double.parseDouble(splitter[1]));
		      
		    }
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		Double yearlist[]=year.toArray(new Double[year.size()]);
		Double publist[]=Journals.toArray(new Double[Journals.size()]);
	
		q1 = new linear(yearlist,publist);

		predval = q1.predict(y);
	}

	public static void main(String[] args) 
	{
		new Que3("input.txt",2008.0);
		
		System.out.println(predval);
		
	}
}