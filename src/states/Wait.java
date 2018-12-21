package states;

import shapes.Shape;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Wait extends State{
    public Wait(){
        System.out.println("Enter waiting state!");
    }
    public State input(MouseEvent event, Mode mode, CanvasAction action, Shape shape){
        // to be ready, being ready to draw
        if (action == CanvasAction.CANVAS_PRESS && mode == Mode.DRAW){
            if (shape != null)
                return new Ready(shape);
            else
                return this;
        }
        if (action == CanvasAction.CANVAS_PRESS && mode == Mode.SELECTED && shape != null){
            return new Selected(shape);
        }
        return this;
    }
}
