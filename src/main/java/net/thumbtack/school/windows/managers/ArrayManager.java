package net.thumbtack.school.windows.managers;

import net.thumbtack.school.windows.v4.Desktop;
import net.thumbtack.school.windows.v4.base.Window;
import net.thumbtack.school.windows.v4.base.WindowErrorCode;
import net.thumbtack.school.windows.v4.base.WindowException;
import net.thumbtack.school.windows.v4.cursors.Cursor;

public class ArrayManager<T extends Window> {
    private T[] windows;

    ArrayManager(T[]  windows) throws WindowException{
        setWindows(windows);
    }

    public T[] getWindows() {
        return windows;
    }

    public void setWindows(T[] windows) throws WindowException{
        for (T window: windows)
            if (window == null)
                throw new WindowException(WindowErrorCode.NULL_WINDOW);
        this.windows = windows;
    }

    public T getWindow(Integer index) {
        return windows[index];
    }

    public void setWindow(T window, Integer index)throws WindowException{
        if (window == null)
            throw new WindowException(WindowErrorCode.NULL_WINDOW);
        windows[index] = window;
    }

    public boolean isSameSize(ArrayManager<? extends Window> arrayManager2){
        return windows.length == arrayManager2.windows.length;
    }

    public boolean allWindowsFullyVisibleOnDesktop(Desktop desktop){
        for (T window: windows)
            if (!window.isFullyVisibleOnDesktop(desktop)){
                return false;
            }
        return true;
    }

    public boolean anyWindowFullyVisibleOnDesktop(Desktop desktop){
        for (T window: windows)
            if (window.isFullyVisibleOnDesktop(desktop)){
                return  true;
            }
        return false;
    }

    public Window getFirstWindowFromCursor(Cursor cursor){
        for (Integer index = 0; index<windows.length; index++)
            if (windows[index].isInside(cursor.getX(),cursor.getY())){
                return windows[index];
            }
        return null;
    }

}
