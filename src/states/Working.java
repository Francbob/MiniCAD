package states;

import shapes.Polygon;
import shapes.Polyline;
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

        // the state's transfer is different in polyline implementation
        // you have to go back to ready state
        if (action == CanvasAction.CANVAS_PRESS
                && curShape.getClass() == Polyline.class && mode == Mode.DRAW){
            this.curShape.setEnd(event.getX(), event.getY());
            ((Polyline)this.curShape).newLine(event.getX(),event.getY());
            return new Ready(curShape);
        }
        if (action == CanvasAction.CANVAS_PRESS
                && curShape.getClass() == Polygon.class && mode == Mode.DRAW){
            this.curShape.setEnd(event.getX(), event.getY());
            ((Polygon)this.curShape).newLine(event.getX(),event.getY());
            if (((Polygon) this.curShape).getIsEnd())
                return new Wait();
            return new Ready(curShape);
        }
        if (action == CanvasAction.CANVAS_RELEASE
                && curShape.getClass() != Polyline.class && mode == Mode.DRAW){
            this.curShape.setEnd(event.getX(), event.getY());
            return new Wait();
        }
        this.curShape.setEnd(event.getX(), event.getY());
        return this;
    }
}
