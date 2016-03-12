package VPT.tests;

import VPT.libs.Message.*;
import VPT.libs.*;
import VPT.inventory.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.HashMap;

public class CoreTest{

	Core core;
	Layout inv;
	public CoreTest(Core core){
		this.core = core;
	}

	public void go(){
		createLayout();
		inventoryRegister();
		callingInventoryFuncWithCore();
	}

	public void createLayout(){
		inv = new Layout(core);
	}

	public void inventoryRegister(){													/*собираю сообщение чтобы зарегистрироваться в ядре*/
		System.out.println("Inv:(Test0) Registration");
		Action act = new Action("registerSystemComp", "box", inv);
		ConcurrentLinkedQueue<Action> que = new ConcurrentLinkedQueue<Action>();
		que.offer(act);
		Message mess = new Message(0,que);
		core.sendMessage(mess);
	}

	public void callingInventoryFuncWithCore(){												/*пишу сам себе через ядро*/
		System.out.println("Inv:(Test1) sending a message to itself");
		Action act = new Action("testPrint", "uselessArg", 4);
		ConcurrentLinkedQueue<Action> que = new ConcurrentLinkedQueue<Action>();
		que.offer(act);
		Message mess = new Message(1,que);
		core.sendMessage(mess);
	}
}