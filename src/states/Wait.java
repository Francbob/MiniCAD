package states;

import shapes.Shape;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Wait extends State{
    public Wait(){
        System.out.println("Enter waiting state!");
    }
    public State input(MouseEvent event, Mode mode, boolean click, Shape shape){
        // to be ready, being ready to draw
        if (click && mode == Mode.DRAW){
            if (shape != null)
                return new Ready(shape);
            else
                return this;
        }
        if (click && mode == Mode.SELECTED){
            return new Selected(shape);
        }
        return this;
    }
}
