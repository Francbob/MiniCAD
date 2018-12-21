import shapes.Line;
import shapes.Shape;
import states.Mode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Canvas extends JPanel {

    private Control control = null;
    private Model model = null;

    Canvas(Control control, Model model) {
        this.setBackground(Color.white);
        this.control = control;
        this.model = model;

        MouseAdapter ma = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                control.CanvasPressHandler(e);
                repaint();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                control.CanvasReleaseHandler(e);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                control.CanvasDragHandler(e);
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                control.CanvasMoveHandler(e);
                repaint();
            }
        };

        this.addMouseListener(ma);
        this.addMouseMotionListener(ma);

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (Shape shape : model){
            shape.render((Graphics2D)g);
        }
        // test case
//        Line ai = new Line(12,42,63,266);
//        ai.move(50, 50);
//        ai.setStokeColor(Color.blue);
//        ai.setStokeSize(10);
//        ai.render((Graphics2D)g);
    }
}
