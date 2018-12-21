package shapes;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Shape {
//    int width = 0;
//    int height = 0;
//    int X = 0;
//    int Y = 0;
//    int strokeSize = 1;
//    Color strokeColor = Color.black;

    public abstract void render(Graphics2D canvas);
    public abstract void setBegin(int x, int y);
    public abstract void setEnd(int x, int y);
    public abstract void move(int x, int y);
    public abstract void resize(int delta);
    public abstract void setStokeColor(Color color);
    public abstract void setStokeSize(int delta);
    public abstract void selected();
    public abstract void removeSelected();
    public abstract boolean isInBox(Point2D target);
}
