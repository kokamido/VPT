package VPT.gameObjects;


import java.util.Hashtable;
import java.util.Iterator;
import java.util.HashSet;
import VPT.libs.Point;
import VPT.libs.Shape;
import VPT.libs.Orientation;
import VPT.libs.Picture;
import VPT.gameObjects.CardType;
import VPT.gameObjects.GameObject;

/**
*
*
*/
public class Card implements GameObject{
	private int cardID;
	private int typeID;
	private String subtypeID;
	private boolean isBeingTransferred = false;
	private int containerID = -1;
	private int ownerID = -1;
	private int currentOrient;
	private Point shift;
	private Hashtable<Integer,Integer> playersVision;
	private HashSet<Integer> childObjects;

	public Card(int cardID, int typeID, String subtypeID, boolean isBeingTransferred, int containerID, int ownerID,
		int currentOrient, Point shift, Hashtable<Integer,Integer> playersVision, HashSet<Integer> childObjects){
		this.cardID = cardID;
		this.typeID = typeID;
		this.subtypeID = subtypeID;
		this.containerID = containerID;
		this.isBeingTransferred = isBeingTransferred;
		this.ownerID = ownerID;
		this.currentOrient = currentOrient;
		this.shift = shift;
		this.playersVision = playersVision;
		this.childObjects = childObjects;
	}

	public Card(int cardID, int typeID, String subtypeID){
		this.cardID = cardID;
		this.typeID = typeID;
		this.subtypeID = subtypeID;
	}
	
	public int getID(){
		return cardID;
	}

	/**
	*
	*{@literal} Returns id of this card type.
	*/
	public int getTypeID(){
		return typeID;
	}

	/**
	*
	*{@literal} Returns id of this card subtype
	*/
	public String getSubTypeID(){
		return subtypeID;
	}

	/**
	*
	*{@literal} Returns the id of the container in which the card or -1 if the card is not stored in the container
	*/
	public int getContatinerID(){
		return containerID;
	}

	/**
	*
	*{@literal}
	*/
	public int getOwnerID(){
		return ownerID;
	}

	/**
	*
	*{@literal}
	*/
	public boolean isBeingTransferred(){
		return isBeingTransferred;
	}

	/**
	*
	*{@literal}
	*/
	public int getCurrentOrientation(){
		return currentOrient;
	}

	/**
	*
	*{@literal}
	*/
	public Point getShift(){
		return shift.clone();
	}

	/**
	*
	*{@literal}
	*/
	public Integer getPlayerVision(int playerID){
		return playersVision.get(playerID);
	}

	/**
	*
	*{@literal}
	*/
	public Iterator<Integer> getChildObjectsIterator(){
		return childObjects.iterator();
	}

	public boolean hasChild(int id){
		return childObjects.contains(id);
	}

	/**
	*
	*{@literal}
	*/
	public void setContainerID(int newID){
		containerID = newID;
	}

	/**
	*
	*{@literal}
	*/
	public void setOwnerID(int newID){
		ownerID = newID;
	}

	/**
	*
	*{@literal}
	*/
	public void setCurrentOrient(int newOrient){
		currentOrient = newOrient;
	}

	/**
	*
	*{@literal}
	*/
	public void changeTransferFlag(){
		isBeingTransferred = !isBeingTransferred;
	}

	/**
	*
	*{@literal}
	*/
	public void setTransferFlag(boolean flag){
		isBeingTransferred = flag;
	}

	/**
	*
	*{@literal}
	*/
	public void setShift(Point newShift){
		shift.setX(newShift.getX());
		shift.setY(newShift.getY());
	}

	/**
	*
	*{@literal}
	*/
	public void setShift(double x, double y){
		shift.setX(x);
		shift.setY(y);
	}

	/**
	*
	*/
	public void setPlayerVision(int playerID, int newVisionState){
		playersVision.remove(playerID);
		playersVision.put(playerID, newVisionState);
	}	

	/**
	*
	*/
	public void addChild(int id){
		childObjects.add(id);
	}

	/**
	*
	*/
	public void deleteChild(int id){
		childObjects.remove(id);
	}

}