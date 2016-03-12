package VPT.gameObjects;

import VPT.libs.Point;
import VPT.libs.Shape;
import VPT.libs.Orientation;
import VPT.libs.Picture;


public class CardType{
	private int id;
	private Shape shape;
	private int numOfStates;
	private int backIndex;
	private Picture[] pictures;
	private int orientNum;
	private Orientation[] orients;
	private boolean isClasterable;

	/**
	*
	*@see VPT.libs.Form VPT.libs.Form
	*@param numOfStates Number of card states. For example, chess figure has 1 state, d6 has 6 states.
	*@param backIndex Index of state corresponding to back of the card.
	*@param pictures Array of pictures, corresponding to card statements.
	*@param orientNum Number of card orientations.
	*@param orients Orientations of the card.
	*@param isClasterable Flag allowing grouping cards in a container.
	*/
	public CardType(int id, Shape shape, int numOfStates, int backIndex, Picture[] pictures,
		int orientNum, Orientation[] orients, boolean isClasterable){
		this.id = id;
		this.shape = shape;
		this.numOfStates = numOfStates;
		this.backIndex = backIndex;
		this.pictures = pictures;
		this.orientNum = orientNum;
		this.orients = orients;
		this.isClasterable = isClasterable;
	}

	/**
	*
	*{@literal} Returns the shape with orientation number "num" from orients.
	*@param num Number of applying orientation.
	*@see CardType#orients orients.
	*/
	public Shape applyOrientation(int num){
		return shape.rotation(orients[num]);
	}

	/**
	*
	*{@literal} Returns the type ID
	*@see CardType#id ID
	*/
	public int getID(){
		return id;
	}
	
	/**
	*
	*{@literal} Returns the form of this card type.
	*@see CardType#form form
	*/
	public Shape getShape(){
		return (Shape)shape.clone();
	}
	
	/**
	*
	*{@literal} Returns the number of states of this card type.
	*@see CardType#numOfStates Number of states.
	*/
	public int getNumOfStates(){
		return numOfStates;
	}
	
	/**
	*
	*{@literal} Returns the index of back of the card.
	*@see CardType#backIndex back index.
	*/
	public int getBackIndex(){
		return backIndex;
	}
	
	/**
	*
	*{@literal} Returns the array of pictures of this card type
	*@see CardType#pictures pictures.
	*/
	public Picture[] getPictures(){
		return (Picture[])pictures.clone();
	}
	
	/**
	*
	*{@literal} Returns the picture number "num" from array of pictures of this card type.
	*@see CardType#pictures pictures.
	*/
	public Picture getPicture(int num){
		return (Picture)pictures[num].clone();
	}
	
	/**
	*
	*{@literal} Returns the number of orientations of this card type.
	*@see CardType#orientNum Number of orientations.
	*/
	public int getOrientNum(){
		return orientNum;
	}
	
	/**
	*
	*{@literal} Returns the array of orientations of this card type.
	*@see CardType#orients Orientations.
	*/
	public Orientation[] getOrientations(){
		return (Orientation[])orients.clone();
	}
	
	/**
	*
	*{@literal} Returns flag of clasterable
	*@see CardType#isClasterable Flag.
	*/
	public boolean isClasterable(){
		return isClasterable;
	}
}