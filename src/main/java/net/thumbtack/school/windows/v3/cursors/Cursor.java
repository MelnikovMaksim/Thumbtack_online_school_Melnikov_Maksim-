package net.thumbtack.school.windows.v3.cursors;

import net.thumbtack.school.windows.v3.Point;
import net.thumbtack.school.windows.v3.iface.Movable;

public class Cursor implements Movable {
    private int cursorForm;
    private Point point;

    public Cursor(int x, int y, int cursorForm){
        this(new Point(x, y),cursorForm);
    }

    public Cursor(Point point, int cursorForm) {
        this.point = point;
        this.cursorForm = cursorForm;
    }

    public int getCursorForm(){
        return cursorForm;
    }

    public  void setCursorForm(int cursorForm){
        this.cursorForm = cursorForm;
    }

    public  int getX(){
        return point.getX();
    }

    public  int getY(){
        return point.getY();
    }

    public void setX(int x){
        point.setX(x);
    }

    public void setY(int y){
        point.setY(y);
    }

    @Override
    public void moveTo(int x, int y) {
        point = new Point(x, y);
    }

    @Override
    public void moveRel(int dx, int dy){
        point.moveRel(dx, dy);
    }
}
