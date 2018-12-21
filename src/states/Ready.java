package states;

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
    public State input(MouseEvent event, Mode mode, boolean click, Shape shape){
        if (click && mode == Mode.DRAW){
            Point p = event.getPoint();
            curShape.setBegin(p.x, p.y);
            return new Working(this.curShape, p);
        }
        if (click && mode == Mode.SELECTED){

        }
        return this;
    }
}
