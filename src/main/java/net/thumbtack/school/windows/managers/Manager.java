package net.thumbtack.school.windows.managers;

import net.thumbtack.school.windows.v4.Point;
import net.thumbtack.school.windows.v4.base.Window;
import net.thumbtack.school.windows.v4.base.WindowErrorCode;
import net.thumbtack.school.windows.v4.base.WindowException;

public class Manager<T extends Window>{
    private T window;

    Manager(T window) throws WindowException{
        setWindow(window);
    }

    public void setWindow(T window) throws WindowException{
        if (window == null)
            throw new WindowException(WindowErrorCode.NULL_WINDOW);
        this.window = window;
    }

    public T getWindow() {
        return window;
    }

    public void moveTo(int x, int y){
        window.moveTo(x,y);
    }

    public void moveTo(Point point){
        window.moveTo(point);
    }

}
