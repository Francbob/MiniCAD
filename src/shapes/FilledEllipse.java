package shapes;

import java.awt.*;

public class FilledEllipse extends Ellipse {
    @Override
    public void render(Graphics2D canvas){
        canvas.setColor(this.strokeColor);
        canvas.setStroke(new BasicStroke(strokeSize));
        canvas.fill(this.ellipse);
        if (selected){
            canvas.setColor(Color.RED);
            canvas.setStroke(new BasicStroke(3));
            canvas.draw(this.ellipse.getBounds2D());
        }
    }
}
