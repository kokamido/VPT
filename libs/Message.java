package VPT.libs;
import java.util.concurrent.ConcurrentLinkedQueue; //стандартная очередь
import java.util.HashMap;//стандартный хэшмэп

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

	/**
	*
	*{@literal} Structural unit of the message
	*/
	public class Action{
		
		String funcName = "";
		HashMap<String,Object> args = new HashMap<String,Object>();

		Action(){};
		
		/**
		*
		*@param funcName - Name of called function
		*/
		public Action(String funcName){
			this.funcName = funcName;
		}
		
		/**
		*
		*@param funcName Name of called function
		*@param args HashMap contains names and values of arguments
		*/
		public Action(String funcName, HashMap<String,Object> args){
			this.funcName = funcName;
			this.args = args;
		}
		
		/**
		*
		*@param args a sequence of arguments names and their values, in the order of name, value, name, value, etc.
		*/
		public Action(Object... args){
			this.funcName = (String)args[0];
			for(int i = 1; i<args.length; doubleInc(i)){
				addArg((String)args[i],args[i+1]);
			}
		}
		
		/**
		*
		*{@literal} Adds new argument into Action
		*/
		public void addArg(String argName, Object argValue){
			this.args.put(argName, argValue);
		}
		
		public String getFuncName(){
			return funcName;
		}
		
		public HashMap<String,Object> getArgs(){
			return args;
		}
		
		private int doubleInc(int i) {return (i+2);}
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

	public Action newAction(String funcName, HashMap<String,Object> args){  
		return new Action(funcName, args);										
	}
}
	



