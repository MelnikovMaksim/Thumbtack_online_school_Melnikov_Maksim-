package net.thumbtack.school.windows.v4;

import net.thumbtack.school.windows.v4.base.RectWindow;
import net.thumbtack.school.windows.v4.base.WindowException;
import net.thumbtack.school.windows.v4.base.WindowState;

public class RectButton extends RectWindow {

    private String text;

    public RectButton(Point topLeft, Point bottomRight, WindowState state, String text) throws WindowException {
        super(topLeft,bottomRight,state);
        this.text = text;
    }

    public RectButton(int xLeft, int yTop, int width, int height, WindowState state, String text) throws WindowException {
        this(new Point(xLeft, yTop),  new Point(xLeft+width-1, yTop+height-1),state,text);
    }

    public RectButton(Point topLeft, Point bottomRight, String text) throws WindowException {
        this(topLeft, bottomRight, WindowState.ACTIVE,text);
    }

    public RectButton(int xLeft, int yTop, int width, int height, String text) throws WindowException {
        this(xLeft, yTop, width, height, WindowState.ACTIVE,text);
    }

    public RectButton(Point topLeft, Point bottomRight, String state, String text) throws WindowException {
        this(topLeft,bottomRight,WindowState.fromString(state),text);
    }

    public RectButton(int xLeft, int yTop, int width, int height, String state, String text) throws WindowException {
        this(new Point(xLeft, yTop),  new Point(xLeft+width-1, yTop+height-1),WindowState.fromString(state),text);
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

    public String getText(){
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
