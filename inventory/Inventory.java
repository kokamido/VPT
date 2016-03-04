package VPT.inventory;                               /*просто заглушка на месте модуля, чтобы потестировать ядро*/

import VPT.libs.Action;
import VPT.libs.Message;
import VPT.libs.Message.*;
import VPT.gameObjects.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.ArrayList;
import java.util.HashMap;

public class Inventory implements MailBox{
	
	ArrayList<GameObject> inventory = new ArrayList<GameObject>();
	HashMap<Integer,Card> fields = new HashMap<Integer, Card>();
	HashMap<Integer, Card> hands = new HashMap<Integer,Card>();

	public Inventory(Core core){							
		this.core = core;
	}
	
	/*ссылка на ядро*/
	Core core;                                             
	
	public void getMessage(Message message){
		while(!message.getActions().isEmpty()){
			actionProcessor(message.getActions().poll());
		}
	}

	public void actionProcessor(Action act){
		if(act.getFuncName() == "addOneObject"){
			addObject((GameObject)act.getArgs().get("object"));
		}
		if(act.getFuncName() == "addObjects"){
			addObject((GameObject[])act.getArgs().get("objects"));
		}
	}

	private void addObject(GameObject obj){
		inventory.add(obj);
	}

	private void addObject(GameObject... objects){
		for(GameObject obj : objects){
			addObject(obj);
		}
	}
	
	private void addField(int id, Card card){
		fields.put(id,card);
	}

	private void addHand(int id, Card card){
		hands.put(id, card);
	}

}