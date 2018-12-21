import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.*;

public class View {

    JFrame frame = new JFrame("MiniCAD");
    private Canvas canvas = null;
    private ControlPanel controlPanel = null;
    private Control control = null;
    private Model model = null;
    private JTextField filename = new JTextField(), dir = new JTextField();

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

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem save = new JMenuItem("Save");
        save.addActionListener(new SaveL());
        JMenuItem load = new JMenuItem("Load");
        load.addActionListener(new Load());
        menu.add(save); menu.add(load);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
    }
    class SaveL implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser c = new JFileChooser();
            // Demonstrate "Save" dialog:
            int rVal = c.showSaveDialog(frame);
            if (rVal == JFileChooser.APPROVE_OPTION) {
                filename.setText(c.getSelectedFile().getName());
                dir.setText(c.getCurrentDirectory().toString());
            }
            if (rVal == JFileChooser.CANCEL_OPTION) {
                filename.setText("You pressed cancel");
                dir.setText("");
            }

            // Serialize
            try{
                Path path = Paths.get(dir.getText(), filename.getText());
                System.out.println(path.toString());
                FileOutputStream file = new FileOutputStream(path.toString());
                ObjectOutputStream outputStream = new ObjectOutputStream(file);
                outputStream.writeObject(model);
                outputStream.close();
                file.close();
                System.out.println("Graph data is saved in "+ path);
            }catch (IOException e1){
                e1.printStackTrace();
            }
        }
    }
    class Load implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser c = new JFileChooser();
            // Demonstrate "Open" dialog:
            int rVal = c.showOpenDialog(frame);
            if (rVal == JFileChooser.APPROVE_OPTION) {
                filename.setText(c.getSelectedFile().getName());
                dir.setText(c.getCurrentDirectory().toString());
            }
            if (rVal == JFileChooser.CANCEL_OPTION) {
                filename.setText("You pressed cancel");
                dir.setText("");
            }
            try {
                Path path = Paths.get(dir.getText(), filename.getText());
                System.out.println(path.toString());
                FileInputStream file = new FileInputStream(path.toString());
                ObjectInputStream inputStream = new ObjectInputStream(file);
                model.clear();
                model.addAll((Model) inputStream.readObject());
                inputStream.close();
                file.close();
                System.out.println("Graph data is loaded from "+ path);
                canvas.repaint();
            }catch (IOException|ClassNotFoundException e2){
                e2.printStackTrace();
            }
        }
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
