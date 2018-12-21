package shapes;

import javafx.scene.shape.Circle;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import javax.swing.*;

public class Line extends Shape{
//    private int X1;
//    private int Y1;
//    private int X2;
//    private int Y2;
     boolean selected = false;
    Line2D line;
    Point p1;
    Point p2;
     int strokeSize = 1;
     Color strokeColor = Color.black;


    public Line(int x1, int y1, int x2, int y2){
        this.p1 = new Point(x1, y1);
        this.p2 = new Point(x2, y2);
        this.line = new Line2D.Float(this.p1, this.p2);
    }

    public Line(){
        this.p1 = new Point();
        this.p2 = new Point();
        this.line = new Line2D.Float();
    }

    public void setBegin(int x, int y){
        this.p1.setLocation(x, y);
    }

    public void setEnd(int x, int y){
        this.p2.setLocation(x, y);
        this.line.setLine(p1, p2);
    }

    public void render(Graphics2D canvas){
        canvas.setColor(this.strokeColor);
        canvas.setStroke(new BasicStroke(strokeSize));
        canvas.draw(this.line);
        if (selected){
            canvas.setColor(Color.RED);
            canvas.setStroke(new BasicStroke(3));
            canvas.draw(this.line.getBounds2D());
        }
    }
    public void move(int deltaX, int deltaY){
        this.p1.translate(deltaX, deltaY);
        this.p2.translate(deltaX, deltaY);
        this.line.setLine(this.p1, this.p2);
    }
    public void resize(int delta){
        this.p1.setLocation(this.p1.getX()+delta, this.p1.getY()+delta);
        this.p2.setLocation(this.p2.getX()+delta, this.p2.getY()+delta);
        this.line.setLine(this.p1, this.p2);
    }
    public void setStokeColor(Color color){
        this.strokeColor = color;
    }
    public void setStokeSize(int delta){
        if (strokeSize + delta > 0){
            strokeSize += delta;
        }
    }
    public void selected(){
        this.selected = true;
    }
    public void removeSelected(){
        this.selected = false;
    }
    public boolean isInBox(Point2D target){
        return ((target.getX() > p1.getX() && target.getX() < p2.getX()) ||
                        (target.getX() < p1.getX() && target.getX() > p2.getX()))
                &&
                ((target.getY() > p1.getY() && target.getY() < p2.getY()) ||
                        (target.getY() < p1.getY() && target.getY() > p2.getY()));
    }
}
