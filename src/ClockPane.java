import java.util.Calendar;
import java.util.GregorianCalendar;

import javafx.animation.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.util.Duration;


public class ClockPane extends Pane {
	private double hour;
	private double minute;
	private int second;
	
	public ClockPane() {
		setCurrentTime();
		
	}

	public ClockPane(double hour, double minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		
	}

	public int getHour() {
		return (int)hour;
	}
	
	public void setHour(double hour) {
		this.hour = hour;
		paintClock();
	}

	public int getMinute() {
		return (int)minute;
	}
	
	public void setMinute(double minute) {
		this.minute = minute;
		paintClock();
	}
	
	public int getSecond() {
		return second;
	}
	
	public void setSecond(int second) {
		this.second = second;
		paintClock();
	}

	
	public void setCurrentTime() {
		Calendar calendar = new GregorianCalendar();
		this.second = calendar.get(Calendar.SECOND);
		this.minute = calendar.get(Calendar.MINUTE) + (double) this.second/60;
		this.hour = calendar.get(Calendar.HOUR_OF_DAY) + this.minute/60;
		//System.out.println("Second="+second+ "  Minute="+minute+ "  Hour="+hour);
		paintClock();
	}
	
	private void paintClock() {
		// Code the clock based upon getWidth(), getHeight();
		double clockRadius = 2*getWidth()/5;
		double centerX = getWidth()/2;
		double centerY = getHeight()/2;
		
		Circle circle = new Circle(centerX, centerY, clockRadius);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		
		// don't touch this code...
		Text t1 = new Text(centerX-5,centerY-clockRadius+12,"12");
		Text t2 = new Text(centerX-clockRadius+3,centerY+5,"9");
		Text t3 = new Text(centerX+clockRadius-10,centerY+3,"3");
		Text t4 = new Text(centerX-3,centerY+clockRadius-3,"6");
		
                // sLength is the length of the second hand
		double sLength = clockRadius*0.9;
		// You need to calculate the X,Y values of the endpoint
		double secondX = centerX +sLength * Math.sin((2* Math.PI/60)*second); 
		double secondY = centerY -sLength * Math.cos((2* Math.PI/60)*second); 
		Line sLine = new Line(centerX,centerY,secondX,secondY);
		sLine.setStroke(Color.BLACK); // adjust your own color here
		
                // mLength is the length of the minute hand
		double mLength = clockRadius*0.7;
		// You need to calculate the X,Y values of the endpoint
		double minuteX = centerX+mLength* Math.sin((2*Math.PI/60 )*minute);
		double minuteY = centerY-mLength* Math.cos((2*Math.PI/60 )*minute);
		Line mLine = new Line(centerX,centerY,minuteX,minuteY);
		mLine.setStroke(Color.BLACK); // adjust your own color here
		
                // hLength is the length of the hour hand
		double hLength = clockRadius*0.5;
		// You need to calculate the X,Y values of the endpoint
		double hourX = centerX+hLength*Math.sin((2* Math.PI/12)* hour);
		double hourY = centerY-hLength*Math.cos((2 * Math.PI/12)* hour);
		Line hLine = new Line(centerX,centerY,hourX,hourY);
		hLine.setStroke(Color.BLACK); // adjust your own color here...
		
		getChildren().clear();
		getChildren().addAll(circle,t1,t2,t3,t4,sLine,mLine,hLine);
	}
	

	
	// The next two methods of BorderPane are overridden because we need to force a repaint of the clock
	@Override 
	public void setWidth(double width) {
		super.setWidth(width);
		paintClock();
	}
	
	@Override
	public void setHeight(double height) {
		super.setHeight(height);
		paintClock();
	}
	
}
