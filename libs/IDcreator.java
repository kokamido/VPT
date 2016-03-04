public class IDcreator{
	private IDcreator(){}

	static int nextID = 199;
	static int getID(){
		nextID++;
		return nextID;
	}
}