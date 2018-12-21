import states.*;
import shapes.*;

import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;

public class Control {
    private State curState = new Wait();
    private Mode mode = Mode.WAIT;
    private Model model = null;
    public Class<? extends Shape> curShape = null;
    public Shape selectedShape = null;

    public void setModel(Model model){
        this.model = model;
    }
    public void CanvasPressHandler(MouseEvent event){
        if (this.mode == mode.DRAW){
            try {
                Shape shape = curShape.getConstructor().newInstance();
                this.model.add(shape);
                // get into ready state
                curState = curState.input(null, this.mode, true, shape);
            }catch (NoSuchMethodException|
                    IllegalAccessException|
                    InstantiationException|
                    InvocationTargetException e){
                e.printStackTrace();
            }
            curState = curState.input(event, this.mode, true, selectedShape);
            return;
        }
        if (this.mode == mode.SELECTED){
            if (curState.getClass() == Selected.class){
                curState = curState.input(event, this.mode, true, selectedShape);
                return;
            }
            boolean flag = false;
            for (Shape shape:model){
                if (shape.isInBox(event.getPoint())){
//                    if (curState.getClass() == Selected.class && !selectedShape.equals(shape)){
//                        curState = curState.input(event, this.mode, true, null);
//                        return;
//                    }
                    selectedShape = shape;
                    flag = true;
                    break;
                }
            }
            if (flag){
                curState = curState.input(event, this.mode, true, selectedShape);
            }
        }

    }
    public void SelectHandler(){
        this.mode = Mode.SELECTED;
    }

    public void CanvasDragHandler(MouseEvent event){
        System.out.println("Drag begin!");
            curState = curState.input(event, this.mode, false, null);
    }

    public void CanvasReleaseHandler(MouseEvent event){
        if (this.mode == mode.DRAW)
            curState = curState.input(event, this.mode, true, null);
    }

    public void LineClickHandler(){
        this.mode = Mode.DRAW;
        this.curShape = Line.class;
    }

    public void RectClickHandler(){
        this.mode = Mode.DRAW;
        this.curShape = Rect.class;
    }

    public void EllipseClickHandler(){
        this.mode = Mode.DRAW;
        this.curShape = Ellipse.class;
    }

    public void DragHandler(){

    }

}
