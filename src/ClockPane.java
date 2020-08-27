import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;


public class ClockPane extends Pane {
	private int hour;
	private int minute;
	private int second;
	
	public ClockPane() {
		setCurrentTime();
	}

	public ClockPane(int hour, int minute, int second) {

	}

	public int getHour() {
		return hour;
	}
	
	public void setHour(int hour) {
		this.hour = hour;
		paintClock();
	}

	public int getMinute() {
		return minute;
	}
	
	public void setMinute(int minute) {
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
		this.minute = calendar.get(Calendar.MINUTE);
		this.hour = calendar.get(Calendar.HOUR_OF_DAY);
		paintClock();
	}
	
	private void paintClock() {
		// Code the clock based upon getWidth(), getHeight();
		double clockRadius = ;
		double centerX = ;
		double centerY = ;
		
		Circle circle = new Circle(centerX, centerY, clockRadius);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		
		// don't touch this code...
		Text t1 = new Text(centerX-5,centerY-clockRadius+12,"12");
		Text t2 = new Text(centerX-clockRadius+3,centerY+5,"9");
		Text t3 = new Text(centerX+clockRadius-10,centerY+3,"3");
		Text t4 = new Text(centerX-3,centerY+clockRadius-3,"6");
		
		double sLength = clockRadius*0.8;
		// You need to calculate the X,Y values of the endpoint
		double secondX = 
		double secondY = 
		Line sLine = new Line(centerX,centerY,secondX,secondY);
		sLine.setStroke(); // adjust your own color here
		
		double mLength = clockRadius*0.65;
		double minuteX = 
		double minuteY = 
		Line mLine = new Line(centerX,centerY,minuteX,minuteY);
		mLine.setStroke(); // adjust your own color here
		
		double hLength = clockRadius*0.5;
		double hourX = 
		double hourY = 
		Line hLine = new Line(centerX,centerY,hourX,hourY);
		hLine.setStroke(); // adjust your own color here...
		
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
