package VPT.gameObjects;

import VPT.libs.Point;
import VPT.libs.Orientation;
import java.util.ArrayList;
import java.util.HashMap;
//ДЕЙСТВИЯ НАД КАРТАМИ

public class Deck extends Container{

	HashMap<CardType,Integer> defaultTypePictureNumberForOwner;
	HashMap<CardType,Integer> defaultTypePictureNumberForNotOwner;
	HashMap<CardType,Orientation> defaultTypeOrientation;//?
	boolean canGroup;
	HashMap<CardType,Orientation> permitOrientations;//?
	//!!!HashMap<CardType,Something> список разрешённых действий
	Card[] cards;
	int numberOfSifts;
	Point[] shifts;
	HashMap<Integer,Point> currentShiftsForPlayers;
	//<cамодеятельность>
	boolean differentShifts = false;
	Point shift;
	//</cамодеятельность>

}