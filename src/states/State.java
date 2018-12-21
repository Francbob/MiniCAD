package states;

import shapes.Shape;

import java.awt.event.MouseEvent;

public abstract class State {
    // Current operating shape
    Shape curShape = null;

    public abstract State input(MouseEvent event, Mode mode, CanvasAction action, Shape shape);
}
