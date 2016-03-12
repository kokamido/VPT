package VPT.libs;

import VPT.libs.IBasicAction;
import VPT.gameObjects.GameObject;
import VPT.libs.Script;

public abstract class ScriptAction{
	public abstract void action(GameObject obj);
	private Script script;
}