package net.thumbtack.school.windows.v4.base;

import net.thumbtack.school.windows.v4.Desktop;
import net.thumbtack.school.windows.v4.Point;

import java.util.Objects;

abstract public class RectWindow extends Window {
	// REVU по одному поллю на строке
    private Point topLeft;
    private  Point bottomRight;

    public RectWindow(Point topLeft, Point bottomRight, WindowState state) throws WindowException {
        super(state);
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }


    public Point getTopLeft() {
        return topLeft;
    }
    public Point getBottomRight() {
        return bottomRight;
    }
    public int getWidth() {
        return bottomRight.getX()-topLeft.getX()+1;
    }
    public int getHeight() {
        return bottomRight.getY()-topLeft.getY()+1;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }
    public void setBottomRight(Point bottomRight) {
        this.bottomRight = bottomRight;
    }

    @Override
    public void moveTo(int x, int y) {
        bottomRight.moveTo(x+getWidth()-1, y+getHeight()-1);
        topLeft = new Point(x, y);
    }

    @Override
    public void moveRel(int dx, int dy) {
        topLeft.moveRel(dx,dy);
        bottomRight.moveRel(dx,dy);
    }

    @Override
    public void resize(double ratio) {
        int widthNew,heightNew;
        if (getWidth()*ratio<1)
            widthNew = 1;
        else widthNew = (int)(getWidth()*ratio);
        if (getHeight()*ratio<1)
            heightNew = 1;
        else heightNew = (int)(getHeight()*ratio);
        bottomRight.moveTo(topLeft.getX()+widthNew-1, topLeft.getY()+heightNew-1);
    }

    @Override
    public boolean isInside(Point point) {
        return point.getX()>=topLeft.getX() & point.getX()<=bottomRight.getX() & point.getY()>=topLeft.getY() & point.getY()<=bottomRight.getY();
    }

    @Override
    public boolean isFullyVisibleOnDesktop(Desktop desktop) {
        return topLeft.isVisibleOnDesktop(desktop) & bottomRight.isVisibleOnDesktop(desktop);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RectWindow)) return false;
        if (!super.equals(o)) return false;
        RectWindow that = (RectWindow) o;
        return getTopLeft().equals(that.getTopLeft()) &&
                getBottomRight().equals(that.getBottomRight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTopLeft(), getBottomRight());
    }
}
