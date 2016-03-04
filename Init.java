package VPT;

import VPT.core.*;
import VPT.inventory.*;
import VPT.libs.Message.*;
import VPT.tests.*;
import VPT.libs.*;

/*Здесь стартует вся программа*/
public class Init{
	static MicroCore corre = new MicroCore();       /*Создаю экземпляр ядра*/
	static CoreTest cTest = new CoreTest(corre);	/*Тест*/
	public static void main(String[] args){
		System.out.println("Я родился!");
		Point kek = new Point();
		Thread coreThread = new Thread(corre);		/*создаю поток, чтобы обрабатывать поступающие в ядро сообщения*/
		coreThread.start();							/*стартую поток*/
		cTest.go();
	}
}
