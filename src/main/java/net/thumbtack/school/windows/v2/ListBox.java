package net.thumbtack.school.windows.v2;

import net.thumbtack.school.base.StringOperations;

import java.util.Arrays;
import java.util.Objects;

public class ListBox {
    private Point topLeft, bottomRight;
    private boolean active;
    private String[] lines;

    public ListBox(Point topLeft, Point bottomRight, boolean active, String[] lines) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
        this.active = active;
        setLines(lines);
    }

    public ListBox(int xLeft, int yTop, int width, int height, boolean active, String[] lines) {
        topLeft = new Point(xLeft, yTop);
        bottomRight = new Point(xLeft + width - 1, yTop + height - 1);;
        this.active = active;
        setLines(lines);
    }

    public ListBox(Point topLeft, Point bottomRight, String[] lines) {
        this(topLeft, bottomRight, true, lines);
    }

    public ListBox(int xLeft, int yTop, int width, int height, String[] lines) {
        this(xLeft, yTop, width, height, true, lines);
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

    public int getWidth() {
        return bottomRight.getX()-topLeft.getX()+1;
    }
    public int getHeight() {
        return bottomRight.getY()-topLeft.getY()+1;
    }

    public String[] getLines() {
        if (lines == null)
            return null;
        return Arrays.copyOf(lines, lines.length);
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

    public void setLines(String[] lines) {
        if (lines == null)
            this.lines = null;
        else {
            this.lines = new String[lines.length];
            System.arraycopy(lines, 0, this.lines, 0, lines.length);
        }
    }

    public String[] getLinesSlice(int from, int to) {
        if (lines == null) return null;
        if (lines.length < to)
            return Arrays.copyOfRange(lines, from, lines.length);
        else
            return Arrays.copyOfRange(lines, from, to);
    }

    public String getLine(int index) {
        //if (lines == null) return null;
        if (index >= 0 && index < lines.length)
            return lines[index];
        return null;
    }

    public void setLine(int index, String line) {
        if (index >= 0 && index < lines.length)
            lines[index] = line;
    }

    public Integer findLine(String line) {
        if (lines == null) return null;
        for (Integer index = 0; index < lines.length; index++) {
            if (lines[index].equals(line))
                return index;
        }
        return null;
    }

    public void reverseLineOrder() {
        if (lines != null)
            for (int i = 0; i < lines.length / 2; i++) {
                String temp;
                temp = lines[i];
                lines[i] = lines[lines.length - 1 - i];
                lines[lines.length - 1 - i] = temp;
            }
    }

    public void reverseLines(){
        if (lines != null)
            for (Integer index = 0; index<lines.length; index++)
                lines[index] = StringOperations.reverse(lines[index]);
    }

    public void duplicateLines(){
        if (lines != null){
            String[] lines2 = new String[lines.length*2];
            for (Integer index = 0;index < lines.length; index++){
                lines2[index*2] = lines[index];
                lines2[index*2+1] = lines2[index*2];
            }
            setLines(lines2);
        }
    }

    public void removeOddLines(){
        if (lines != null){
            String[] lines2 = new String[(lines.length+1)/2];
            for (Integer index = 0;index < lines.length; index+=2){
                lines2[index/2] = lines[index];
            }
            setLines(lines2);
        }
    }

    public boolean isSortedDescendant(){
        if (lines != null){
            String[] lines2 = new String[lines.length];
            System.arraycopy(lines, 0, lines2, 0, lines.length);
            Arrays.sort(lines2);
            for (int i = 0; i < lines2.length / 2; i++) {
                String temp;
                temp = lines2[i];
                lines2[i] = lines2[lines2.length - 1 - i];
                lines2[lines2.length - 1 - i] = temp;
            }
            return Arrays.equals(lines,lines2);
        }
        return true;
    }

    public void moveTo(int x, int y) {
        moveTo(new Point(x, y));
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

    public boolean isIntersects(ListBox listBox) {
        return  isInside(listBox.topLeft) ||
                isInside(listBox.bottomRight) ||
                isInside(listBox.topLeft.getX(),listBox.topLeft.getY()+listBox.getHeight()-1) ||
                isInside(listBox.topLeft.getX()+listBox.getWidth()-1, listBox.topLeft.getY()) ||
                listBox.isInside(topLeft) ||
                listBox.isInside(bottomRight) ||
                listBox.isInside(topLeft.getX(),topLeft.getY()+ getHeight()-1) ||
                listBox.isInside(topLeft.getX()+ getWidth()-1, topLeft.getY());
    }

    public boolean isInside(ListBox listBox) {
        return  isInside(listBox.topLeft) & isInside(listBox.bottomRight);
    }

    public boolean isFullyVisibleOnDesktop(Desktop desktop) {
        return topLeft.isVisibleOnDesktop(desktop) & bottomRight.isVisibleOnDesktop(desktop);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListBox listBox = (ListBox) o;
        return active == listBox.active &&
                topLeft.equals(listBox.topLeft) &&
                bottomRight.equals(listBox.bottomRight) &&
                Arrays.equals(lines, listBox.lines);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(topLeft, bottomRight, active);
        result = 31 * result + Arrays.hashCode(lines);
        return result;
    }
}



