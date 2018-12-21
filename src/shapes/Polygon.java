package shapes;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Polygon extends Polyline{
    private Point firstP;
    private Rectangle2D firstPointRegion = new Rectangle2D.Float();
    private boolean isEnd = false;

    public boolean getIsEnd() { return isEnd; }

    @Override
    public void setBegin(int x, int y){
        if (!isInit){
            this.p1.setLocation(x, y);
            firstP = this.p1;
            firstPointRegion.setFrameFromCenter(firstP, new Point(firstP.x-10, firstP.y-10));
        }

    }
    @Override
    public void setEnd(int x, int y){
        // if the point fall into the region near the start Point
        // finish drawing
        this.p2.setLocation(x, y);

        this.line.setLine(p1, p2);
    }

    public void newLine(int x, int y){
        if (firstPointRegion.contains(p2)){
            this.p2.setLocation(firstP);
            this.line.setLine(p1, p2);
            isEnd = true;
        }
        singleLine newLine = new singleLine(line, p1, p2);
        this.lines.add(newLine);
        isInit = true;
        this.p1 = new Point(p2);
        this.p2 = new Point();
        this.line = new Line2D.Float();

    }
}
