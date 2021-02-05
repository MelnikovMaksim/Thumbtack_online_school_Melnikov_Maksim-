package net.thumbtack.school.windows.v3.base;

import net.thumbtack.school.windows.v3.Desktop;
import net.thumbtack.school.windows.v3.Point;
import net.thumbtack.school.windows.v3.iface.Movable;
import net.thumbtack.school.windows.v3.iface.Resizable;

import java.util.Objects;

public abstract class Window implements Movable, Resizable {
    private boolean active;
    private String text;

    public Window(boolean active, String text){
        this.active = active;
        this.text = text;
    }

    public boolean isActive() {
        return active;
    }
    public String getText(){
        return text;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public void setText(String text){
        this.text = text;
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
        return isActive() == window.isActive() &&
                getText().equals(window.getText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(isActive(), getText());
    }
}
