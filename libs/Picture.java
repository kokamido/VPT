package VPT.libs;


public class Picture{
	private String link;

	public Picture(String link){
		this.link = link;
	}

	public String getLink(){
		try{
			return (String)link.getClass().getMethod("clone").invoke(link);
		}
		catch(Throwable e){
			return "getLink error.";
		}
	}

	public Picture clone(){
		return (Picture)this.clone();	
	}
}