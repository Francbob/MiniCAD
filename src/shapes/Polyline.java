package shapes;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Polyline extends Line{
    boolean isInit = false;

   class singleLine{
       Line2D line;
       Point p1;
       Point p2;
       singleLine(Line2D line, Point p1, Point p2){
           this.line = line;
           this.p1 = p1;
           this.p2 = p2;
       }
   }
   ArrayList<singleLine> lines = new ArrayList<>();

    public void setBegin(int x, int y){
        if (!isInit)
            this.p1.setLocation(x, y);
    }

    public void setEnd(int x, int y){
        this.p2.setLocation(x, y);
        this.line.setLine(p1, p2);
    }

    public void newLine(int x, int y){
        singleLine newLine = new singleLine(line, p1, p2);
        this.lines.add(newLine);
        isInit = true;
        this.p1 = new Point(p2);
        this.p2 = new Point();
        this.line = new Line2D.Float();
    }

    public void render(Graphics2D canvas){
        canvas.setColor(this.strokeColor);
        canvas.setStroke(new BasicStroke(strokeSize));
        canvas.draw(line);
        for (singleLine line : this.lines){
            canvas.draw(line.line);
        }
        if (selected){
            canvas.setColor(Color.RED);
            canvas.setStroke(new BasicStroke(3));
            for (singleLine line : this.lines){
                canvas.drawOval(line.p1.x, line.p1.y, 10, 10);
                canvas.drawOval(line.p2.x, line.p2.y, 10, 10);
            }
        }
    }

    public void move(int deltaX, int deltaY){
        for (singleLine line : lines){
            line.p1.translate(deltaX, deltaY);
            line.p2.translate(deltaX, deltaY);
            line.line.setLine(line.p1, line.p2);
        }
    }
    // TODO: very hard transform
}
