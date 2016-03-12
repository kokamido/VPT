package VPT.libs;

import java.util.ArrayList;
import java.lang.Math.*;
//import VPT.libs.Point;
//import VPT.libs.Orientation;


public class Shape{
	
	private ArrayList<Point> apexes = new ArrayList<Point>();
	private Point controlPoint;
	
	public Shape(){}

	public Shape(Point controlPoint, ArrayList<Point> apexes){
		this.controlPoint = controlPoint;
		this.apexes = apexes;
	}

	/**
	*
	*@param points Control point should be first.
	*/
	public Shape(Point ... points){
		controlPoint = points[0];
		for(int i = 1; i <= (points.length-1); i++){
			apexes.add(points[i]);
		}
	}

	/**
	*
	*@param coords Coordinates of control point(first two arguments) and other points of the form in order (x,y).
	*/
	public Shape(double ... coords){
		controlPoint.setX(coords[0]);
		controlPoint.setY(coords[1]);
		for(int i = 2; i <= coords.length-2; i=i+2){
			apexes.add(new Point(coords[i],coords[i+1]));
		}
	}

	/**
	*
	*{@literal} Method rotates the form by a given angle.
	*@param angle Angle in radians.
	*/
	public Shape rotation(double angle){
		Point buf = new Point();
		ArrayList<Point> newApexes = new ArrayList<Point>();
		for(Point i: apexes){
			//Поворот вокруг центра на угол angle
			buf.setX(i.getX()*Math.cos(angle)-i.getY()*Math.sin(angle));
			buf.setY(i.getX()*Math.sin(angle)+i.getY()*Math.cos(angle));
			newApexes.add(buf.clone());
		}
		return new Shape(this.controlPoint, newApexes);
	}

	/**
	*
	*{@literal}Method rotates the form by a given orientation
	*@see VPT.libs.Orientation VPT.libs.Orientation 
	*/
	public Shape rotation (Orientation orient){
		return this.rotation(orient.angle);
	}

	/**
	*
	*{@literal} Returns a list of apexes.
	*/
	public ArrayList<Point> getApexes(){
		return apexes;
	}

	/**
	*
	*{@literal} Returns a control point.
	*/
	public Point getControlPoint(){
		return controlPoint;
	}

	/**
	*
	*{@literal}sets control point.
	*/
	public void setCPoint(Point newCPoint){
		controlPoint = newCPoint;
	}

	/**
	*
	*{@literal}sets control point.
	*/
	public void setCPoint(double x, double y){//!!!не нужна.
		controlPoint.setX(x);
		controlPoint.setY(y);	
	}

	public Shape clone(){
		return (Shape)this.clone();
	}
}

