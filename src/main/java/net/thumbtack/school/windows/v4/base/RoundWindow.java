package net.thumbtack.school.windows.v4.base;

import net.thumbtack.school.windows.v4.Desktop;
import net.thumbtack.school.windows.v4.Point;

import java.util.Objects;

abstract public class RoundWindow extends Window {
    private Point center;
    private int radius;

    public RoundWindow(Point center, int radius, WindowState state) throws WindowException{
        super(state);
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter(){
        return center;
    }
    public int getRadius(){
        return  radius;
    }

    public void setCenter(int x, int y){
        center.setX(x);
        center.setY(y);
    }
    public void setRadius(int radius){
        this.radius = radius;
    }

    @Override
    public void moveTo(int x, int y){
        center.moveTo(x,y);
    }
    @Override
    public void moveRel(int dx, int dy){
        center.moveRel(dx,dy);
    }
    @Override
    public void resize(double ratio){
        radius*=ratio;
        if (radius<1)
            radius = 1;
    }
    @Override
    public boolean isInside(Point point){
        return (point.getX()-center.getX())*(point.getX()-center.getX())+(point.getY()-center.getY())*(point.getY()-center.getY())<=radius*radius;
    }
    @Override
    public boolean isFullyVisibleOnDesktop(Desktop desktop){
        Point topLeft = new Point(center.getX()-radius,center.getY()-radius);
        Point bottomRight = new Point(center.getX()+radius, center.getY()+radius);
        return topLeft.isVisibleOnDesktop(desktop) & bottomRight.isVisibleOnDesktop(desktop);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoundWindow)) return false;
        if (!super.equals(o)) return false;
        RoundWindow that = (RoundWindow) o;
        return getRadius() == that.getRadius() &&
                Objects.equals(getCenter(), that.getCenter());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCenter(), getRadius());
    }
}
