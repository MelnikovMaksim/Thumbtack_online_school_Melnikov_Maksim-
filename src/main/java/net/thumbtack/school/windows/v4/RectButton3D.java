package net.thumbtack.school.windows.v4;

import net.thumbtack.school.windows.v4.base.WindowException;
import net.thumbtack.school.windows.v4.base.WindowState;

public class RectButton3D extends RectButton {
    private int zHeight;

    public RectButton3D(Point topLeft, Point bottomRight, WindowState state, String text, int zHeight) throws WindowException {
        super(topLeft, bottomRight, state, text);
        this.zHeight = zHeight;
    }

    public RectButton3D(int xLeft, int yTop, int width, int height, WindowState state, String text, int zHeight) throws WindowException {
        this(new Point(xLeft, yTop),  new Point(xLeft+width-1, yTop+height-1),state,text,zHeight);
    }

    public RectButton3D(Point topLeft, Point bottomRight, String text, int zHeight) throws WindowException {
        this(topLeft, bottomRight, WindowState.ACTIVE,text,zHeight);
    }

    public RectButton3D(int xLeft, int yTop, int width, int height, String text, int zHeight) throws WindowException {
        this(xLeft, yTop, width, height, WindowState.ACTIVE,text,zHeight);
    }

    public RectButton3D(Point topLeft, Point bottomRight, String state, String text, int zHeight) throws WindowException {
        this(topLeft, bottomRight, WindowState.fromString(state), text, zHeight);
    }

    public RectButton3D(int xLeft, int yTop, int width, int height, String state, String text, int zHeight) throws WindowException {
        this(new Point(xLeft, yTop),  new Point(xLeft+width-1, yTop+height-1),WindowState.fromString(state),text,zHeight);
    }

    public int getZHeight() {
        return zHeight;
    }

    public void setZHeight(int i) {
        zHeight = i;
    }

    public boolean isInside(RectButton3D rectButton3D){
        return super.isInside(rectButton3D) && this.zHeight>=rectButton3D.zHeight;
    }
}
