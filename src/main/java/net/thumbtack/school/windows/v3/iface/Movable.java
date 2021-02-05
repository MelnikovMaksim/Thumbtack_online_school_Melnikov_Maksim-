package net.thumbtack.school.windows.v3.iface;

import net.thumbtack.school.windows.v3.Point;

public interface Movable {
    // REVU отформатируйте, Ctrl-Alt-L
    default void moveTo(Point point) {
        this.moveTo(point.getX(), point.getY());
    }

    void moveTo(int x, int y);

    void moveRel(int dx, int dy);
}
