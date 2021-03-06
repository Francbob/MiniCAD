package states;

import shapes.Polygon;
import shapes.Polyline;
import shapes.Shape;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Ready extends State{
    Point point;
    private Shape curShape;
    Ready(Shape shape){
        System.out.println("Enter Ready State!");
        this.curShape = shape;
    }
    public State input(MouseEvent event, Mode mode, CanvasAction action, Shape shape){
        if (action == CanvasAction.CANVAS_MOVE
                && (curShape.getClass() == Polyline.class
                || curShape.getClass() == Polygon.class) && mode == Mode.DRAW){
            Point p = event.getPoint();
            curShape.setBegin(p.x,p.y);
            return new Working(this.curShape, p);
        }
        if (action == CanvasAction.CANVAS_DRAG && mode == Mode.DRAW){
            Point p = event.getPoint();
            curShape.setBegin(p.x, p.y);
            return new Working(this.curShape, p);
        }
        if (action == CanvasAction.CANVAS_PRESS && mode == Mode.DRAW && event.getButton() == MouseEvent.BUTTON3){
            this.curShape.setEnd(event.getX(), event.getY());
            return new Wait();
        }
        return this;
    }
}
