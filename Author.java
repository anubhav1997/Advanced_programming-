import java.util.*;

public class Author{
	public int pubs=0;
	public  List<String> alias = new ArrayList<String>();
	String mapped;

	public void addname (String name)
	{
		alias.add(name);
	}

	public List<String> getalias()
	{
		return alias;
	}

	public void  print()
	{
		for(String temp : alias)
		{
			System.out.println(temp);
		}
	}

	public String valmap()
	{
		mapped=alias.get(0);
		return mapped;
	}

	public void setpubs(int num)
	{
		this.pubs=num;
	}

	public void incpubs()
	{
		pubs++;
	}

	public int findauth(String name)
	{
		
		for(String o : alias)
		{
			if(name.equals(o))
			{
				return 1;

			}
			
		}
		return 0;
	}

}