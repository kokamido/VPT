package VPT.libs;

import java.util.ArrayList;
import java.lang.Math.*;

/**
*
*{@literal}This is point in R*R.
*/
public class Point extends Object{
	private double x,y;
	
	public Point(){};
	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	/**
	*
	*{@literal} Changes the abscissa.
	*/
	public void setX(double x){
		this.x = x;
	}
	
	/**
	*
	*{@literal} Changes the ordinate.
	*/
	public void setY(double y){
		this.y = y;
	}
	
	/**
	*
	*{@literal} Returns the abscissa.
	*/
	public double getX(){
		return x;
	}
	
	/**
	*
	*{@literal} Returns the ordinate.
	*/
	public double getY(){
		return y;
	}
	
	/**
	*
	*{@literal} Returns the absolute value.
	*/
	public double abs(){
		return Math.sqrt(x*x+y*y);
	}

	public Point clone(){
		return (Point)this.clone();
	}
}