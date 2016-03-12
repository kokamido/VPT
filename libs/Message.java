package VPT.libs;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.HashMap;

public class Message{
	
	Integer id;	
	ConcurrentLinkedQueue<Action> actions = new ConcurrentLinkedQueue<Action>();	
	
	/**
	*
	*{@literal} Message handler, iterated through messages received from the core
	*/
	public interface MailBox{
		public void getMessage(Message message);
	}
	
	public interface Core{
		/**
		*
		*{@literal} Method by which components can transmit messages to send.
		*/
		public void sendMessage(Message message);
	}


	public Message(){};
	/*TODO Конструктор с переменным количеством аргуменов*/
	/**
	*
	*{@literal} Constructs message contaning queue of actions and identifer of recepient.
	*@param id Unique identifer of recepient
	*@param actions Queue of actions
	*@see Action Action
	*/
	public Message(Integer id, ConcurrentLinkedQueue<Action> actions){				
		this.id = id;																
		this.actions = actions;
	}
	
	/**
	*
	*{@literal} Constructs message for calling single function
	*@param id Unique identifer of recepient
	*@param funcName Name of calling function
	*@param args HashMap contains argumetns of callig function in format (Name, Value)
	*/
	public Message(Integer id, String funcName, HashMap<String,Object> args){
		this.id = id;
		ConcurrentLinkedQueue<Action> buf = new ConcurrentLinkedQueue<Action>();
		buf.offer(new Action(funcName, args));
		this.actions = buf;
	}

	/**
	*
	*{@literal} Returns unique identifer of recepient
	*/
	public Integer getID(){
		return id;
	}

	/**
	*
	*{@literal} Returns queue of actions
	*@see Action
	*/
	public ConcurrentLinkedQueue<Action> getActions(){
		return actions;
	}

}
	



