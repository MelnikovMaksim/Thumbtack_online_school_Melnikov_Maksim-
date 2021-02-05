package net.thumbtack.school.windows.v3;

public class RectButton3D extends RectButton {
    private int zHeight;

    public RectButton3D(Point topLeft, Point bottomRight, boolean active, String text, int zHeight) {
        super(topLeft, bottomRight, active, text);
        this.zHeight = zHeight;
    }

    public RectButton3D(int xLeft, int yTop, int width, int height, boolean active, String text, int zHeight){
        this(new Point(xLeft, yTop),  new Point(xLeft+width-1, yTop+height-1),active,text,zHeight);
    }

    public RectButton3D(Point topLeft, Point bottomRight, String text, int zHeight){
        this(topLeft, bottomRight, true,text,zHeight);
    }

    public RectButton3D(int xLeft, int yTop, int width, int height, String text, int zHeight){
        this(xLeft, yTop, width, height, true,text,zHeight);
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
