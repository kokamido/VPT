package VPT.libs;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.HashMap;

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
		for(int i = 1; i<args.length-1; i=i+2){
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
	
}	