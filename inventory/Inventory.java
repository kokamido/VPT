package VPT.inventory;

import VPT.gameObjects.GameObject;
import VPT.libs.Message;
import VPT.libs.Message.*;
import java.util.HashMap;

public class Inventory implements MailBox{

	private Core core;
	private HashMap<Integer,GameObject> gameObjects = new HashMap<Integer,GameObject>();

	public void getMessage(Message message){}

	public void addObject(GameObject obj){
		gameObjects.put(obj.getID(), obj);
	}
	public void deleteObject(GameObject obj){
		gameObjects.remove(obj.getID());
	}
	public GameObject getObject(int id){
		return gameObjects.get(id);  //!!! Clone
	}
}