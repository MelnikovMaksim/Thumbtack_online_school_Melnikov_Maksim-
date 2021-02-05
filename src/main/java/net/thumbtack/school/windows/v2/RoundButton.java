package net.thumbtack.school.windows.v2;

import java.util.Objects;

public class RoundButton {
    private Point center;
    private int radius;
    private boolean active;
    private String text;

    public RoundButton(Point center, int radius, boolean active, String text) {
        this.center = center;
        this.radius = radius;
        this.active = active;
        this.text = text;
    }

    public RoundButton(int xCenter, int yCenter, int radius, boolean active, String text) {
        this(new Point(xCenter,yCenter),radius,active,text);
    }

    public RoundButton(Point center, int radius, String text){
        this(center,radius,true, text);
    }

    public RoundButton(int xCenter, int yCenter, int radius, String text){
        this(new Point(xCenter,yCenter),radius,true, text);
    }

    public Point getCenter(){
        return center;
    }
    public int getRadius(){
        return  radius;
    }
    public boolean isActive(){
        return active;
    }
    public String getText(){
        return text;
    }


    public void moveTo(int x, int y){
        center.moveTo(x,y);
    }

    public void moveTo(Point point){
        center = point;
    }

    public void setCenter(int x, int y){
        center.setX(x);
        center.setY(y);
    }

    public void setRadius(int radius){
        this.radius = radius;
    }

    public void setActive(boolean active){
        this.active = active;
    }

    public void setText(String text){
        this.text = text;
    }


    public void moveRel(int dx, int dy){
        center.moveRel(dx,dy);
    }

    public void resize(double ratio){
        radius*=ratio;
        if (radius<1)
            radius = 1;
    }

    public boolean isInside(int x, int y){
        return isInside(new Point(x, y));
    }

    public boolean isInside(Point point){
        return (point.getX()-center.getX())*(point.getX()-center.getX())+(point.getY()-center.getY())*(point.getY()-center.getY())<=radius*radius;
    }

    public boolean isFullyVisibleOnDesktop(Desktop desktop){
        Point topLeft = new Point(center.getX()-radius,center.getY()-radius);
        Point bottomRight = new Point(center.getX()+radius, center.getY()+radius);
        return topLeft.isVisibleOnDesktop(desktop) & bottomRight.isVisibleOnDesktop(desktop);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoundButton that = (RoundButton) o;
        return radius == that.radius &&
                active == that.active &&
                text == that.text &&
                center.equals(that.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius, active);
    }
}
