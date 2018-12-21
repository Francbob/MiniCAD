package states;

import shapes.Shape;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Move extends State{

    private Shape curShape;
    private Point begin;

    Move(Shape shape, Point point){
        System.out.println("Enter Move State!");
        this.curShape = shape;
        this.begin = point;
    }

    public State input(MouseEvent event, Mode mode, CanvasAction action, Shape shape){
        curShape.move((int)(event.getX()-begin.getX()), (int)(event.getY()-begin.getY()));

        if (action == CanvasAction.CANVAS_DRAG && mode == Mode.SELECTED){
            return new Move(curShape, event.getPoint());
        }
        if (action == CanvasAction.CANVAS_RELEASE && mode == Mode.SELECTED)
            return new Selected(curShape);
        return this;
    }
}
