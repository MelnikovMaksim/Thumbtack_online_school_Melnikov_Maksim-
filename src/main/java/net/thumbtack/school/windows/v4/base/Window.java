package net.thumbtack.school.windows.v4.base;

import net.thumbtack.school.windows.v4.Desktop;
import net.thumbtack.school.windows.v4.Point;
import net.thumbtack.school.windows.v4.iface.Movable;
import net.thumbtack.school.windows.v4.iface.Resizable;

import java.util.Objects;

public abstract class Window implements Movable, Resizable {
    private WindowState state;

    public Window(WindowState state) throws WindowException{
        checkState(state);
        this.state = state;
    }

    private static void checkState(WindowState state) throws WindowException {
        if (state == WindowState.DESTROYED || state == null)
            throw new WindowException(WindowErrorCode.WRONG_STATE);
    }

    public WindowState getState() {
        return state;
    }

    public void setState(WindowState state) throws WindowException {
        checkState(this.state);
        this.state = state;
    }

    public abstract boolean isInside(Point point);
    public boolean isInside(int x, int y) {
         return isInside(new Point(x, y));
    }
    public abstract boolean isFullyVisibleOnDesktop(Desktop desktop);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Window)) return false;
        Window window = (Window) o;
        return getState() == window.getState();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getState());
    }
}
