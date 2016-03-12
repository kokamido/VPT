package VPT.gameObjects;

import VPT.gameObjects.CardType;
import VPT.gameObjects.Container;
import java.util.HashMap;
import java.util.HashSet;

public class Heap extends Container{

	private HashMap<CardType,String> typeContainers= new HashMap<CardType,String>();
	private HashSet<Integer> childObjectsID = new HashSet<Integer>();
	private HashMap<Integer,Container> containers = new HashMap<Integer,Container>();

	public void addContainer(Container container){
		containers.put(container.getID(), container);
	}




}