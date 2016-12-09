import java.util.ArrayList;
import java.util.List;

 class Journals{

		private List<String> authors = new ArrayList<String>();
		private int hits ;

		//private String author = null;
		private String title = null;
		private String pages = null;
		private String year = null;
		private String volume = null;
		private String journal = null;
		private String number = null;
		private String url = null;
		private String ee = null;
		private String mdate = null;
		private String booktitle = null;
		private String crossref = null;
		private int i=0;

		// Journals(String a, String b,String c,String d,String e,String f,String g,String h,String i)
		// {
		// 	 String author = a;
		// 	 String title = b;
		// 	 String pages = c;
		// 	 String year = d;
		// 	 String volume = e;
		//  	 String journal = f;
		// 	 String number = g;
		// 	 String url = h;
		// 	 String ee = i;

		// }

		public int gethits()
		{
			return hits;
		}

		public void sethits(int hit)
		{
			this.hits=hit;
		}

		public List<String> getauthor(){
			return authors;
		}
		public String getbt(){
			return booktitle;
		}

		public void setbt( String name){
		
			this.booktitle=name;
		}

		public String getcrossref(){
			return crossref;
		}

		public void setcrossref( String name){
		
			this.crossref=name;
		}


		public List<String> getauth(){
			return authors;
		}

		public void setauth( String name){
		
			authors.add(name);

		}

		public String getmdate(){
			return mdate;
		}
		//public String getauth(){
			//return author;
		//}

		//public void setauth( String name){
		
			//this.author=name;
	//	}
	
		public String gettitle(){
			return title;
		}
		public void setmdate(String mdate){
			this.mdate= mdate;
		}
		public void settitle( String name){
			this.title=name;
		}

		public String getpages(){
			return pages;
		}

		public void setpages( String name){
			this.pages=name;
		}

		public String getyear(){
			return year;
		}

		public void setyear( String name){
			this.year=name;
		}

		public String getvolume(){
			return volume;
		}

		public void setvolume( String name){
			this.volume=name;
		}

		public String getjournal(){
			return journal;
		}

		public void setjournal( String name){
			this.journal=name;
		}

		public String getnumber(){
			return number;
		}

		public void setnumber( String name){
			this.number=name;
		}

		public String geturl(){
			return url;
		}

		public void seturl( String name){
			this.url=name;
		}

		public String getee(){
			return ee;
		}

		public void setee( String name){
			this.ee=name;
		}
		public String toString(){
			//String s;
			return authors.toString()+ " "+ title+ " "+ pages+" "+ mdate+ " "+ volume+" "+ booktitle +" "+journal +" "+" "+url;
			
		}
		// public void toString(Journals obj)
		// {
		// 	System.out.println(this.getauth()+" "+this.gettitle());
		// 	//return p;
		// }

		// public String toString(Journals obj)
		// {
		// 	return obj.author+" "+obj.title;
		// }


}