//U10416019鄭文琪

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import java.security.SecureRandom;

public class BallPane extends Pane {
	//data fields
   	public final double radius = 20;
 	private double x1 = radius, y1 = radius;
    private double x2 = 200, y2 = 20;
    private double dx1 = 1, dy1 = 1;
    private double dx2 = -1, dy2 = -1;
  	//these random determine how is the color of the ball
    private SecureRandom red = new SecureRandom();
	private SecureRandom green = new SecureRandom();
	private SecureRandom blue = new SecureRandom();
	private Circle circle1 = new Circle(x1, y1, radius);
	private Circle circle2 = new Circle(x2, x2, radius);
	private Timeline animation;
	
	//create a constructor of BallPane
	public BallPane() {
		//set the ball color with random
    	circle1.setFill(new Color((red.nextInt(10) + 1) * 0.1, (green.nextInt(10) + 1) * 0.1, (blue.nextInt(10) + 1) * 0.1, 1));
    	circle2.setFill(new Color((red.nextInt(10) + 1) * 0.1, (green.nextInt(10) + 1) * 0.1, (blue.nextInt(10) + 1) * 0.1, 1));
    	// Place two ball into this pane
    	getChildren().add(circle1); 
    	getChildren().add(circle2);

    // Create an animation for moving the ball
    animation = new Timeline(
      	new KeyFrame(Duration.millis(50), e -> moveBall()));
    	animation.setCycleCount(Timeline.INDEFINITE);
    	animation.play(); // Start animation
  	}

  	public void play() {
    	animation.play();
  	}

  	public void pause() {
    	animation.pause();
  	}

  	public void increaseSpeed() {
    	animation.setRate(animation.getRate() + 0.1);
  	}

  	public void decreaseSpeed() {
    	animation.setRate(
      	animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
  	}

  	public DoubleProperty rateProperty() {
    	return animation.rateProperty();
  	}
  
  	protected void moveBall() {
    	// Check boundaries
    	// Change ball move direction and ball color when touch the wall
    	if (x1 < radius || x1 > getWidth() - radius) {
      		dx1 *= -1; 
	      	circle1.setFill(new Color((red.nextInt(10) + 1) * 0.1, (green.nextInt(10) + 1) * 0.1, (blue.nextInt(10) + 1) * 0.1, 1));
    	}
    	if (y1 < radius || y1 > getHeight() - radius) {
    	  	dy1 *= -1;
      		circle1.setFill(new Color((red.nextInt(10) + 1) * 0.1, (green.nextInt(10) + 1) * 0.1, (blue.nextInt(10) + 1) * 0.1, 1)); // Set ball color
    	}
   	 	if (x2 < radius || x2 > getWidth() - radius) {
	      	dx2 *= -1;
    	  	circle2.setFill(new Color((red.nextInt(10) + 1) * 0.1, (green.nextInt(10) + 1) * 0.1, (blue.nextInt(10) + 1) * 0.1, 1));
    	}
	    if (y2 < radius || y2 > getHeight() - radius) {
    	  	dy2 *= -1;
      		circle2.setFill(new Color((red.nextInt(10) + 1) * 0.1, (green.nextInt(10) + 1) * 0.1, (blue.nextInt(10) + 1) * 0.1, 1));
    	}

    //calculate the distance of the two balls
    //then determine whether they touch
    double dox = Math.abs(x2 - x1);
  	double doy = Math.abs(y2 - y1);
  	int s = (int)Math.hypot(dox, doy);
  	if(s <= 2 * radius){
  		dx1 *= -1;
    	dx2 *= -1;
    	dy2 *= -1;
  	}
	
    // Adjust ball position
    x1 += dx1;
    y1 += dy1;
    x2 += dx2;
    y2 += dy2;
    circle1.setCenterX(x1);
    circle1.setCenterY(y1);
    circle2.setCenterX(x2);
    circle2.setCenterY(y2);
  }
}