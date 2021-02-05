package net.thumbtack.school.windows.v3;

import net.thumbtack.school.windows.v3.base.RectWindow;

public class RectButton extends RectWindow {

    public RectButton(Point topLeft, Point bottomRight, boolean active, String text) {
        super(topLeft,bottomRight,active,text);
    }

    public RectButton(int xLeft, int yTop, int width, int height, boolean active, String text){
        this(new Point(xLeft, yTop),  new Point(xLeft+width-1, yTop+height-1),active,text);
    }

    public RectButton(Point topLeft, Point bottomRight, String text) {
        this(topLeft, bottomRight, true,text);
    }

    public RectButton(int xLeft, int yTop, int width, int height, String text){
        this(xLeft, yTop, width, height, true,text);
    }

    public boolean isIntersects(RectButton rectButton) {
        return  isInside(rectButton.getTopLeft()) ||
                isInside(rectButton.getBottomRight()) ||
                isInside(rectButton.getTopLeft().getX(),rectButton.getTopLeft().getY()+rectButton.getHeight()-1) ||
                isInside(rectButton.getTopLeft().getX()+rectButton.getWidth()-1, rectButton.getTopLeft().getY()) ||
                rectButton.isInside(getTopLeft()) ||
                rectButton.isInside(getBottomRight()) ||
                rectButton.isInside(getTopLeft().getX(),getTopLeft().getY()+ getHeight()-1) ||
                rectButton.isInside(getTopLeft().getX()+ getWidth()-1, getTopLeft().getY());
    }

    public boolean isInside(RectButton rectButton) {
        return  isInside(rectButton.getTopLeft()) & isInside(rectButton.getBottomRight());
    }
}
