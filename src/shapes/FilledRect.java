package shapes;
import shapes.Rect;

import java.awt.*;

public class FilledRect extends Rect{
    @Override
    public void render(Graphics2D canvas){
        canvas.setColor(this.strokeColor);
        canvas.setStroke(new BasicStroke(strokeSize));
        canvas.fill(this.rect);
        if (selected){
            canvas.setColor(Color.RED);
            canvas.setStroke(new BasicStroke(3));
            canvas.drawOval((int)rect.getMaxX(), (int)rect.getMaxY(), 10, 10);
            canvas.drawOval((int)rect.getMaxX(), (int)rect.getMinY(), 10, 10);
            canvas.drawOval((int)rect.getMinX(), (int)rect.getMaxY(), 10, 10);
            canvas.drawOval((int)rect.getMinX(), (int)rect.getMinY(), 10, 10);
        }
    }
}