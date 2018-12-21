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

    public void SelectHandler(){
        this.mode = Mode.SELECTED;
    }

    // Canvas Press Action
    public void CanvasPressHandler(MouseEvent event){
        if (this.mode == Mode.DRAW){
            try {
                Shape shape = curShape.getConstructor().newInstance();
                this.model.add(shape);
                // get into ready state
                    curState = curState.input(event, this.mode, CanvasAction.CANVAS_PRESS, shape);
            }catch (NoSuchMethodException|
                    IllegalAccessException|
                    InstantiationException|
                    InvocationTargetException e){
                e.printStackTrace();
            }
//            curState = curState.input(event, this.mode, true, selectedShape);
            return;
        }
        if (this.mode == Mode.SELECTED || this.mode == Mode.DELETE){
            if (curState.getClass() == Selected.class){
                curState = curState.input(event, this.mode, CanvasAction.CANVAS_PRESS, selectedShape);
                return;
            }
            // find the target shap
            boolean flag = false;
            for (Shape shape:model){
                if (shape.isInBox(event.getPoint())){
                    if (this.mode == Mode.DELETE){
                        model.remove(shape);
                        return;
                    }
                    selectedShape = shape;
                    flag = true;
                    break;
                }
            }
            if (flag){
                curState = curState.input(event, mode, CanvasAction.CANVAS_PRESS, selectedShape);
            } else {
                curState = curState.input(event, mode, CanvasAction.CANVAS_PRESS, null);
            }
        }

    }

    // Canvas Drag Action
    public void CanvasDragHandler(MouseEvent event){
        // System.out.println("Drag begin!");
        curState = curState.input(event, this.mode, CanvasAction.CANVAS_DRAG, null);
    }

    // Canvas Release Action
    public void CanvasReleaseHandler(MouseEvent event){
        curState = curState.input(event, this.mode, CanvasAction.CANVAS_RELEASE, null);
    }

    // Canvas Move Action
    public void CanvasMoveHandler(MouseEvent event){
        curState = curState.input(event, this.mode, CanvasAction.CANVAS_MOVE, null);
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

    public void fEllipseClickHandler(){
        this.mode = Mode.DRAW;
        this.curShape = FilledEllipse.class;
    }

    public void fRectClickHandler(){
        this.mode = Mode.DRAW;
        this.curShape = FilledRect.class;
    }

    public void polylineClickHandler(){
        this.mode = Mode.DRAW;
        this.curShape = Polyline.class;
    }

    public void polygonClickHandler(){
        this.mode = Mode.DRAW;
        this.curShape = Polygon.class;
    }

    public void trashClickHandler(){
        this.mode = Mode.DELETE;
    }
}
