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

    public State input(MouseEvent event, Mode mode, boolean click, Shape shape){
        this.curShape.setEnd(event.getX(), event.getY());
        if (click && mode == Mode.DRAW){
            return new Wait();
        }
        return this;
    }
}
