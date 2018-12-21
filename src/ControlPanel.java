import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControlPanel extends JPanel {
    // icons for buttons
    private static Icon line;
    private static Icon rect;
    private static Icon ellipse;
    private static Icon polyline;
    private static Icon polygon;
    private static Icon select;
    private static Icon text;
    private static Icon frect;
    private static Icon fellipse;
    private static Icon trash;

    ControlPanel(Control control){
        this.setBackground(Color.lightGray);
        this.setLayout(new GridLayout(15, 2, 2, 2));

        // Draw a line
        line = new ImageIcon(getClass().getResource("/asset/line.jpg"));
        JButton lineButton = new JButton(line);
        lineButton.setBackground(Color.white);
        lineButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Start to draw lines!");
                super.mouseClicked(e);
                control.LineClickHandler();
            }
        });
        this.add(lineButton);

        // Draw a frect
        frect = new ImageIcon(getClass().getResource("/asset/frect.jpg"));
        JButton frectButton = new JButton(frect);
        frectButton.setBackground(Color.white);
        frectButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Start to draw filled rectangle!");
                super.mouseClicked(e);
                control.fRectClickHandler();
            }
        });
        this.add(frectButton);

        // Draw a fellipse
        fellipse = new ImageIcon(getClass().getResource("/asset/fellipse.jpg"));
        JButton fEllipseButton = new JButton(fellipse);
        fEllipseButton.setBackground(Color.white);
        fEllipseButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Start to draw filled Ellipse!");
                super.mouseClicked(e);
                control.fEllipseClickHandler();
            }
        });
        this.add(fEllipseButton);

        // Drow a Rectangle
        rect = new ImageIcon(getClass().getResource("/asset/rect.jpg"));
        JButton rectButton = new JButton(rect);
        rectButton.setBackground(Color.white);
        rectButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Start to draw Rectangle");
                super.mouseClicked(e);
                control.RectClickHandler();
            }
        });
        this.add(rectButton);

        // Drow a Rectangle
        trash = new ImageIcon(getClass().getResource("/asset/trash.jpg"));
        JButton trashButton = new JButton(trash);
        trashButton.setBackground(Color.white);
        trashButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Ready to Delete Images");
                super.mouseClicked(e);
                control.trashClickHandler();
            }
        });
        this.add(trashButton);

        ellipse = new ImageIcon(getClass().getResource("/asset/ellipse.jpg"));
        JButton ellipseButton = new JButton(ellipse);
        ellipseButton.setBackground(Color.white);
        ellipseButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Start to draw Rectangle");
                super.mouseClicked(e);
                control.EllipseClickHandler();
            }
        });
        this.add(ellipseButton);

        polyline = new ImageIcon(getClass().getResource("/asset/polyline.jpg"));
        polygon = new ImageIcon(getClass().getResource("/asset/polygon.jpg"));

        select = new ImageIcon(getClass().getResource("/asset/select.jpg"));
        JButton selectButton = new JButton(select);
        selectButton.setBackground(Color.white);
        selectButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Start to Select Shapes");
                super.mouseClicked(e);
                control.SelectHandler();
            }
        });
        this.add(selectButton);

        text = new ImageIcon(getClass().getResource("/asset/text.jpg"));


        JButton polygonButton = new JButton(polygon);
        polygonButton.setBackground(Color.white);
        polygonButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Start to Draw polygon");
                super.mouseClicked(e);
                control.polygonClickHandler();
            }
        });

        JButton polylineButton = new JButton(polyline);
        polylineButton.setBackground(Color.white);
        polylineButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Start to Draw polyline");
                super.mouseClicked(e);
                control.polylineClickHandler();
            }
        });

        JButton textButton = new JButton(text);
        textButton.setBackground(Color.white);
        this.add(polygonButton);

        this.add(polylineButton);
        this.add(textButton);


    }

}
