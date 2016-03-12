package VPT.gameObjects;

import VPT.libs.Shape;
import VPT.libs.Orientation;
import VPT.libs.Picture;
import VPT.libs.Point;
import VPT.gameObjects.CardType;
import java.util.HashMap;
import java.util.HashSet;

public class Container implements GameObject{
		
	private int containerID;
	private int parentID;
	private Shape shape;
	//<привязка к форме родителя>
	private Orientation orientationFromParent;
	private Point shiftFromParent;
	//</привязка к форме родителя>
	private boolean canMove;
	private Picture picture;
	private boolean isStatic;
	private int ownerID;
	private HashSet<CardType> permittedTypes;
	private HashMap<CardType, Picture> defaultOwnerVision;
	private HashMap<CardType, Picture> defaultNotOwnerVision;
	private HashSet<Integer> childObjects;

	public Container(int containerID, int parentID, Shape shape, Orientation orientationFromParent,
		Point shiftFromParent, boolean canMove, Picture picture, boolean isStatic, int ownerID,
		HashSet<CardType> permittedTypes, HashMap<CardType, Picture> defaultOwnerVision,
		HashMap<CardType, Picture> defaultNotOwnerVision, HashSet<Integer> childObjects){
		this.containerID = containerID;
		this.parentID = parentID;
		this.shape = shape;
		this.orientationFromParent = orientationFromParent;
		this.shiftFromParent = shiftFromParent;
		this.canMove = canMove;
		this.picture = picture;
		this.isStatic = isStatic;
		this.ownerID = ownerID;
		this.permittedTypes = permittedTypes;
		this.defaultOwnerVision = defaultOwnerVision;
		this.defaultNotOwnerVision = defaultNotOwnerVision;
		this.childObjects = childObjects;
	}

	public Container(){};

	public int getID(){
		return containerID;
	}

	public int getParentID(){
		return parentID;
	}

	public Shape getShape(){
		return shape.clone();
	}

	public Orientation getOrientationFromParent(){
		return orientationFromParent.clone();
	}

	public Point getShiftFromParent(){
		return shiftFromParent.clone();
	}
	
	public boolean canMove(){
		return canMove;
	}
	
	public Picture getPicture(){
		return picture.clone();
	}
	
	public boolean isStatic(){
		return isStatic;
	}
	
	public int getOwnerID(){
		return ownerID;
	}
	
	public boolean isTypePermit(CardType type){
		return permittedTypes.contains(type);
	}		

	public void addPermittedType(CardType type){
		permittedTypes.add(type);
	}

	public void deletePermittedType(CardType type){
		permittedTypes.remove(type);
	}

	public Picture getDefaultTypePictureForOwner(CardType type){
		return defaultOwnerVision.get(type);
	}

	public void setDefaultTypePictureForOwner(CardType type, Picture pic){
		defaultOwnerVision.remove(type);
		defaultOwnerVision.put(type, pic);
	}

	public Picture getDefaultTypePictureForNotOwner(CardType type){
		return defaultNotOwnerVision.get(type);
	}

	public void setDefaultTypePictureForNotOwner(CardType type, Picture pic){
		defaultNotOwnerVision.remove(type);
		defaultNotOwnerVision.put(type, pic);
	}

	public boolean isItChild(int id){
		return childObjects.contains(id);
	}

	public void addChild(int id){
		childObjects.add(id);
	}

	public void deleteChild(int id){
		childObjects.remove(id);
	}
}