package VPT;

import VPT.core.*;
import VPT.inventory.*;
import VPT.libs.Message.*;


/*Здесь стартует вся программа*/
public class Init{
	static MicroCore corre = new MicroCore();       /*Создаю экземпляр ядра*/
	public static void main(String[] args){
		System.out.println("Я родился!");
		Thread coreThread = new Thread(corre);		/*создаю поток, чтобы обрабатывать поступающие в ядро сообщения*/
		coreThread.start();							/*стартую поток*/
		Inventory kek = new Inventory(corre);		/*создаю экземпляр инвентаря(пока просто большая заглушка)*/
		kek.test();									/*вызываю методы инвентаря, чтобы пртустировать как все работает*/
		kek.test1();  
	}
	/*В луа можно передавать ссылку на GameObject  и пусть оно себе тягает данные*/
	/*конкретные днные можно в jsonах*/
	/*формат сценария*/
}
