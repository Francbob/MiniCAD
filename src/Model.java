import shapes.Shape;

import java.util.ArrayList;

public class Model extends ArrayList<Shape> {

    private View view = null;

    public void setView(View view){
        this.view = view;
    }

    Model(){
        super();
    }


}
