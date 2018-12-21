package states;

import shapes.Shape;

import java.awt.event.MouseEvent;

public class Selected extends State{
    private Shape curShape = null;

    Selected(Shape shape){
        if (shape != null){
            System.out.println(shape);
            curShape = shape;
            shape.selected();
        }
    }
    public State input(MouseEvent event, Mode mode, CanvasAction action, Shape shape){
        if (action == CanvasAction.CANVAS_PRESS
                && event.getButton() == MouseEvent.BUTTON3) {
            curShape.removeSelected();
            return new Wait();
        }
        if (action == CanvasAction.CANVAS_PRESS
                && mode == Mode.SELECTED
                && shape == null){
            curShape.removeSelected();
            return new Wait();
        }
        if (action == CanvasAction.CANVAS_DRAG && mode == Mode.SELECTED){
            return new Move(curShape, event.getPoint());
        }
        return this;
    }
}
