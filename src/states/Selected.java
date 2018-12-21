package states;

import shapes.Shape;

import java.awt.event.MouseEvent;

public class Selected extends State{
    Selected(Shape shape){
        if (shape != null){
            System.out.println(shape);
            shape.selected();
        }
    }
    public State input(MouseEvent event, Mode mode, boolean click, Shape shape){
        if (click && event.getButton() == MouseEvent.BUTTON3) {
            shape.removeSelected();
            return new Wait();
        }
        if (click && event.getButton() == MouseEvent.BUTTON1){
            return new Move(shape, event.getPoint());
        }
        return this;
    }
}
