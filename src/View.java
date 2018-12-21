import javax.swing.*;
import java.awt.*;

public class View {

    JFrame frame = new JFrame("MiniCAD");
    private Canvas canvas = null;
    private ControlPanel controlPanel = null;
    private Control control = null;
    private Model model = null;

    void setControl(Control control){
        this.control = control;
        this.controlPanel = new ControlPanel(this.control);
        this.canvas = new Canvas(control, model);
        frame.add(canvas, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.EAST);
    }

    View(Model model){
        this.model = model;
        frame.setLayout(new BorderLayout());
    }

    // A basic framework for UI
    // referenced from TIJ
    public static void run(
            final JFrame f, final int width, final int height){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize(width, height);
                f.setVisible(true);
            }
        });
    }

    // View Test
    public static void main(String[] args){
//        View view = new View();

//        View.run(view.frame, 700, 700);
    }
}
