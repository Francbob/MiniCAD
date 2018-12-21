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

    public State input(MouseEvent event, Mode mode, boolean click, Shape shape){
        curShape.move((int)(event.getX()-begin.getX()), (int)(event.getY()-begin.getY()));

        if (!click && mode == mode.SELECTED){

            return new Move(curShape, event.getPoint());
        }
        return new Selected(curShape);
    }
}
