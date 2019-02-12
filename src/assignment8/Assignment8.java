package Assignment8;

import java.awt.Desktop;
import static java.lang.System.gc;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Basic demonstration of mouse events in action.
 *
 * @author Dhrumil Thaker
 */
public class Assignment8 extends Application {

    double x, y; //varialbes for location
    double radius; //radius for circle
    private GraphicsContext g; //object of graphics context
    private TextField t1, t2, t3, t4, t5, t6; //objexst to create the textfirld

    private void pressHandler(ActionEvent e) { //function to work when user press the button
        x = Integer.parseInt(t1.getText()); //get the x value from t1
        y = Integer.parseInt(t2.getText()); //get the y value from t2
        radius = Double.parseDouble(t3.getText()); //get enetered radius
        System.out.println("Drawn circle at (" + x + "," + y + ").");
        drawCircle(Integer.parseInt(t4.getText()), Integer.parseInt(t5.getText()), Integer.parseInt(t6.getText())); //call drawcircle method
    }

    private void pressHandler(MouseEvent me) { //function to call when mousr button clicked
        x = me.getX(); //get the x value
        y = me.getY(); //get the y value
        radius = Double.parseDouble(t3.getText()); //get the radius
       
        System.out.println("Pressed " + me.getButton() + " at (" + me.getX() + "," + me.getY() + ").");
        drawCircle(Integer.parseInt(t4.getText()), Integer.parseInt(t5.getText()), Integer.parseInt(t6.getText())); //call draw method
    }

    private void releaseHandler(MouseEvent me) { //function call when user release button
        System.out.println("Released " + me.getButton() + " at (" + me.getX() + "," + me.getY() + ").");
    }

    private void draggedHandler(MouseEvent me) { //function call when user drag on screen
        x = me.getX(); //get x
        y = me.getY(); // get y
        radius = Double.parseDouble(t1.getText()); //get raduis
        System.out.println("x = " + x + " y = " + y);
        drawCircle(Integer.parseInt(t4.getText()), Integer.parseInt(t5.getText()), Integer.parseInt(t6.getText())); //function call to draw function

    }

    private void drawCircle(int a, int b, int c) { //draw method
        Color clr = Color.rgb(a, b, c); //object of color

        g.setFill(clr); //set color
        g.fillOval(x, y, radius, radius); //draw oval

    }

    /**
     * This is where you create your components and the model and add event
     * handlers.
     *
     * @param stage The main stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, 700, 500); // set the size here
        stage.setTitle("Assignment 8"); // set the window title here
        stage.setScene(scene);
        // TODO: Add your GUI-building code here

        Canvas c = new Canvas(700, 500); //creating canvas
        Label l1 = new Label("Location"); // create label location
        Label l2 = new Label("Radius"); //create label readius
        Label l3 = new Label("Colour: "); //create label colors
        t1 = new TextField("0"); // inializing the textfield 1
        t2 = new TextField("0"); // inializing the textfield 2 
        t3 = new TextField("10"); // inializing the textfield 3 RADIUS - 10
        t4 = new TextField("0"); // inializing the textfield 4
        t5 = new TextField("0"); // inializing the textfield 5
        t6 = new TextField("0"); // inializing the textfield 6
        Button b = new Button("PRESS");

        //Adding components to canvas
        root.getChildren().add(c);
        root.getChildren().add(b);
        root.getChildren().add(l1);
        root.getChildren().add(l2);
        root.getChildren().add(l3);
        root.getChildren().add(t1);
        root.getChildren().add(t2);
        root.getChildren().add(t3);
        root.getChildren().add(t4);
        root.getChildren().add(t5);
        root.getChildren().add(t6);

        //drawing on canvas
        g = c.getGraphicsContext2D();
        g.setFill(Color.WHITE);
        g.fillRect(0, 0, 700, 500);
        g.setFill(Color.LIGHTGRAY);
        g.fillRect(0, 479, 700, 21);
        // 5. Add Event Handlers and do final setup
        c.addEventHandler(MouseEvent.MOUSE_PRESSED, this::pressHandler); //event when mouse pressed
        c.addEventHandler(MouseEvent.MOUSE_RELEASED, this::releaseHandler); //event when  mouse released
        c.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::draggedHandler); //eveny when mouse dragged

        //int x7 = input.nextInt();
        //int y7 = input.nextInt();
        //setting the width for the componetns
        t1.setPrefWidth(30);
        t2.setPrefWidth(30);
        t3.setPrefWidth(30);
        t4.setPrefWidth(30);
        t5.setPrefWidth(30);
        t6.setPrefWidth(30);

        //set layouts for the label, textf fields and button
        l1.setLayoutX(0);
        l1.setLayoutY(455);
        t1.setLayoutX(50);
        t1.setLayoutY(452);
        t2.setLayoutY(452);
        t2.setLayoutX(80);

        l2.setLayoutX(120);
        l2.setLayoutY(455);
        t3.setLayoutY(452);
        t3.setLayoutX(160);

        l3.setLayoutX(200);
        l3.setLayoutY(455);
        t4.setLayoutY(452);
        t4.setLayoutX(270);
        t5.setLayoutY(452);
        t5.setLayoutX(300);
        t6.setLayoutY(452);
        t6.setLayoutX(330);

        b.setLayoutX(380);
        b.setLayoutY(452);
        b.setOnAction(this::pressHandler);

        stage.show();
    }

    /**
     *
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}
