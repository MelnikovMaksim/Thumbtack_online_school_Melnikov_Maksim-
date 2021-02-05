package net.thumbtack.school.windows.v2;

import java.util.Objects;

public class RectButton {
    private Point topLeft, bottomRight;
    private  boolean active;
    private String text;

    public RectButton(Point topLeft, Point bottomRight, boolean active, String text) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
        this.active = active;
        this.text = text;
    }

    public RectButton(int xLeft, int yTop, int width, int height, boolean active, String text){
        topLeft = new Point(xLeft, yTop);
        bottomRight = new Point(xLeft+width-1, yTop+height-1);
        this.active = active;
        this.text = text;
    }

    public RectButton(Point topLeft, Point bottomRight, String text) {
        this(topLeft, bottomRight, true, text);
    }

    public RectButton(int xLeft, int yTop, int width, int height, String text){
        this(xLeft, yTop, width, height, true, text);
    }

    public Point getTopLeft() {
        return topLeft;
    }
    public Point getBottomRight() {
        return bottomRight;
    }
    public boolean isActive() {
        return active;
    }
    public String getText(){
        return text;
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
    public void setActive(boolean active) {
        this.active = active;
    }


    public void moveTo(int x, int y) {
        moveTo(new Point(x, y));
    }

    public void setText(String text){
        this.text = text;
    }


    public void moveTo(Point point) {
        bottomRight.moveTo(point.getX()+getWidth()-1, point.getY()+getHeight()-1);
        topLeft = point;
    }

    public void moveRel(int dx, int dy) {
        topLeft.moveRel(dx,dy);
        bottomRight.moveRel(dx,dy);
    }

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

    public boolean isInside(int x, int y) {
        return isInside(new Point(x, y));
    }

    public boolean isInside(Point point) {
        return point.getX()>=topLeft.getX() & point.getX()<=bottomRight.getX() & point.getY()>=topLeft.getY() & point.getY()<=bottomRight.getY();
    }

    public boolean isIntersects(RectButton rectButton) {
        return  isInside(rectButton.topLeft) ||
                isInside(rectButton.bottomRight) ||
                isInside(rectButton.topLeft.getX(),rectButton.topLeft.getY()+rectButton.getHeight()-1) ||
                isInside(rectButton.topLeft.getX()+rectButton.getWidth()-1, rectButton.topLeft.getY()) ||
                rectButton.isInside(topLeft) ||
                rectButton.isInside(bottomRight) ||
                rectButton.isInside(topLeft.getX(),topLeft.getY()+ getHeight()-1) ||
                rectButton.isInside(topLeft.getX()+ getWidth()-1, topLeft.getY());
    }

    public boolean isInside(RectButton rectButton) {
        return  isInside(rectButton.topLeft) & isInside(rectButton.bottomRight);
    }

    public boolean isFullyVisibleOnDesktop(Desktop desktop) {
        return topLeft.isVisibleOnDesktop(desktop) & bottomRight.isVisibleOnDesktop(desktop);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RectButton that = (RectButton) o;
        return active == that.active &&
                topLeft.equals(that.topLeft) &&
                text == that.text &&
                bottomRight.equals(that.bottomRight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, bottomRight, active);
    }
}
