package VPT.inventory;                               /*просто заглушка на месте модуля, чтобы потестировать ядро*/

import VPT.libs.Message.*;
import VPT.libs.Message;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.HashMap;


public class Inventory implements MailBox{
	
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
		if(act.getFuncName() == "testPrint"){
			testPrint((Integer)act.getArgs().get("uselessArg"));
		}
	}

	private void testPrint(Integer uselessArg){
		System.out.println("Inv:(Report) I am test print from inventory");
		
	}

	public void test(){													/*собираю сообщение чтобы зарегистрироваться в ядре*/
		System.out.println("Inv:(Test0) Registration");
		Message lol = new Message();
		HashMap<String,Object> heh = new HashMap<String,Object>();
		heh.put("box",this);	
		Action act = lol.newAction("registerSystemComp", heh);
		ConcurrentLinkedQueue<Action> que = new ConcurrentLinkedQueue<Action>();
		que.offer(act);
		Message mess = new Message(0,que);
		core.sendMessage(mess);
	}

	public void test1(){												/*пишу сам себе через ядро*/
		System.out.println("Inv:(Test1) sending a message to itself");
		Message lol = new Message();
		HashMap<String,Object> heh = new HashMap<String,Object>();
		heh.put("uselessArg", 4);
		Action act = lol.newAction("testPrint", heh);
		ConcurrentLinkedQueue<Action> que = new ConcurrentLinkedQueue<Action>();
		que.offer(act);
		Message mess = new Message(1,que);
		core.sendMessage(mess);
	}
}