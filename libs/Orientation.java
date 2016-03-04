package VPT.libs;

public class Orientation{
	public String name;
	public double angle;

	public Orientation(String name, double angle){
		this.name = name;
		this.angle = angle;
	}

	public Orientation clone(){
		return (Orientation)this.clone();
	}
}