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

  }
}