package VPT.inventory;

import VPT.libs.Action;
import VPT.libs.Message;
import VPT.libs.Message.*;
import VPT.libs.IBasicAction;
import VPT.gameObjects.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.HashMap;

public class Layout implements MailBox{
	
	HashMap<Integer, GameObject> inventory = new HashMap<Integer, GameObject>();
	HashMap<Integer,Card> fields = new HashMap<Integer, Card>();
	HashMap<Integer, Card> hands = new HashMap<Integer,Card>();

	public Layout(Core core){							
		this.core = core;
	}
	
	/*ссылка на ядро*/
	private Core core;                                             
	
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
		if(act.getFuncName() == "addField"){
			addField((Integer)act.getArgs().get("id"),(Card)act.getArgs().get("card"));
		}
		if(act.getFuncName() == "addHand"){
			addHand((Integer)act.getArgs().get("id"),(Card)act.getArgs().get("card"));
		}
		if(act.getFuncName() == "action"){
			action((Integer)act.getArgs().get("id"),(IBasicAction)act.getArgs().get("action"));
		}
	}

	private void action(Integer id, IBasicAction act){
		act.action(inventory.get(id));	
	}

	private void addObject(GameObject obj){
		inventory.put(obj.getID(),obj);
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