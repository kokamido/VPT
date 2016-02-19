package VPT.core;

import VPT.libs.*;						/*импортирую определённые мною классы, чтобы была возможность писать сообщения*/
import VPT.libs.Message.*;				/*согласно спецификациям*/
import java.util.concurrent.ConcurrentLinkedQueue;  /*стандартная очередь, вроде как хорошо дружит с потоками*/
import java.util.HashMap;							/*стандартный хэшмэп*/


public class MicroCore implements Runnable, Core, MailBox{

	/*тут регистрируются системные компоненты*/
	private HashMap<Integer, MailBox> systemComponents = new HashMap<Integer, MailBox>();		
	
	/*тут копятся сообщения ожидающие доставки до адресата*/
	private ConcurrentLinkedQueue<Message> messageQueue = new ConcurrentLinkedQueue<Message>(); 

	/**
	*
	*{@literal} Constructor, also registers core.
	*/
	public MicroCore(){																			
		regsterSystemComp(this);																
	}
	
	/**
	*
	*{@literal} Implementation of MailBox interface, incoming messages processing function.
	*@param message Incoming message
	*/
	public void getMessage(Message message){													
			while(!message.getActions().isEmpty()){													
			actionProcessor(message.getActions().poll());
		}
	}
	
	/*Вспомогательный метод для getMessage*/
	private void actionProcessor(Action act){													
			if (act.getFuncName() == "registerSystemComp"){											
			System.out.println("Core:(Report) Registration");
			regsterSystemComp((MailBox)act.getArgs().get("box"));				
		}	
		if (act.getFuncName() == "unregisterSystemComp"){
			System.out.println("Core: deleteing");
			unregisterSystemComp((Integer)act.getArgs().get("id"));
		}
	}												
	
	/**
	*
	*{@literal} Implementation of Runnable interface, sends messages to recepients.
	*/	
	public void run(){																			
		Message buf = new Message();	
		/*TODO нужно спать пока нечего делать*/													
		while(true){																			
			if (!messageQueue.isEmpty()){														
				while (!messageQueue.isEmpty()){												
					buf = messageQueue.poll();													
					System.out.println(buf.getID());
					systemComponents.get(buf.getID()).getMessage(buf);							
				}
			}
		}
	};																		 

	/**
	*
	*{@literal} Other modules calls this method for send message
	*/
	public void sendMessage(Message message){
		messageQueue.offer(message);
	}

	/*регистрируем модуль*/
	private void regsterSystemComp(MailBox box){												
		systemComponents.put(systemComponents.size(), box);
	}

	/*удаляем модуль*/
	private void unregisterSystemComp(Integer id){												
		systemComponents.remove(id);
	}
} 
