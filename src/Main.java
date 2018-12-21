public class Main {

    private Model model = new Model();
    private View view = new View(model);
    private Control control = new Control();

    Main(){
        this.model.setView(this.view);
        this.control.setModel(this.model);
        this.view.setControl(this.control);
        View.run(view.frame, 700, 700);
    }
    public static void main(String[] args){
        Main miniCAD = new Main();
    }
}
