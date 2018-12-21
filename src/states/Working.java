package states;

import shapes.Shape;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Working extends State{

    private Shape curShape;
    private Point begin;

    Working(Shape shape, Point point){
        System.out.println("Enter Working State!");
        this.curShape = shape;
        this.begin = point;
    }

    public State input(MouseEvent event, Mode mode, CanvasAction action, Shape shape){
        this.curShape.setEnd(event.getX(), event.getY());
        if (action == CanvasAction.CANVAS_RELEASE && mode == Mode.DRAW){
            return new Wait();
        }
        return this;
    }
}
