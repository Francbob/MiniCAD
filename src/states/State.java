package states;

import shapes.Shape;

import java.awt.event.MouseEvent;

public abstract class State {
    // Current operating shape
    Shape curShape = null;
    public abstract State input(MouseEvent event, Mode mode, boolean click, Shape shape);
}
