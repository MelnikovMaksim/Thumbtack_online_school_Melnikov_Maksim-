package net.thumbtack.school.windows.v4;

import net.thumbtack.school.base.StringOperations;
import net.thumbtack.school.windows.v4.base.RectWindow;
import net.thumbtack.school.windows.v4.base.WindowErrorCode;
import net.thumbtack.school.windows.v4.base.WindowException;
import net.thumbtack.school.windows.v4.base.WindowState;

import java.util.Arrays;

public class ListBox extends RectWindow {
    private String[] lines;

    public ListBox(Point topLeft, Point bottomRight, WindowState state, String[] lines) throws WindowException {
        super(topLeft,bottomRight,state);
        setLines(lines);
    }

    public ListBox(int xLeft, int yTop, int width, int height, WindowState state, String[] lines) throws WindowException {
        this(new Point(xLeft, yTop),new Point(xLeft + width - 1, yTop + height - 1),state,lines);
    }

    public ListBox(Point topLeft, Point bottomRight, String[] lines) throws WindowException {
        this(topLeft, bottomRight, WindowState.ACTIVE, lines);
    }

    public ListBox(int xLeft, int yTop, int width, int height, String[] lines) throws WindowException {
        this(xLeft, yTop, width, height, WindowState.ACTIVE, lines);
    }

    public ListBox(Point topLeft, Point bottomRight, String state, String[] lines) throws WindowException {
        this(topLeft,bottomRight,WindowState.fromString(state),lines);
    }

    public ListBox(int xLeft, int yTop, int width, int height, String state, String[] lines) throws WindowException {
        this(xLeft,yTop,width,height,WindowState.fromString(state),lines);
    }


    public String[] getLines() {
        if (lines == null) {
            return null;
        }
        return lines;
    }


    public void setLines(String[] lines) {
        if (lines == null) {
            this.lines = null;
        }
        else {
            this.lines = new String[lines.length];
            System.arraycopy(lines, 0, this.lines, 0, lines.length);
        }
    }

    public String[] getLinesSlice(int from, int to) throws WindowException {
        if (lines == null){
            throw new WindowException(WindowErrorCode.EMPTY_ARRAY);
        }
        if (from<0 || lines.length<to || from>to-1) {
            throw new WindowException(WindowErrorCode.WRONG_INDEX);
        }
        return Arrays.copyOfRange(lines, from, to);
    }

    public String getLine(int index) throws WindowException {
        if (lines == null){
            throw new WindowException(WindowErrorCode.EMPTY_ARRAY);
        }
        if (index < 0 || index >= lines.length){
            throw new WindowException(WindowErrorCode.WRONG_INDEX);
        }
        return lines[index];
    }

    public void setLine(int index, String line) throws WindowException {
        if (lines == null){
            throw new WindowException(WindowErrorCode.EMPTY_ARRAY);
        }
        if (index < 0 || index >= lines.length){
            throw new WindowException(WindowErrorCode.WRONG_INDEX);
        }
        lines[index] = line;
    }

    public Integer findLine(String line) {
        if (lines == null) {
            return null;
        }
        for (Integer index = 0; index < lines.length; index++) {
            if (lines[index].equals(line)) {
                return index;
            }
        }
        return null;
    }

    public void reverseLineOrder() {
        if (lines != null) {
            for (int i = 0; i < lines.length / 2; i++) {
                String temp;
                temp = lines[i];
                lines[i] = lines[lines.length - 1 - i];
                lines[lines.length - 1 - i] = temp;
            }
        }
    }

    public void reverseLines(){
        if (lines != null){
            for (Integer index = 0; index<lines.length; index++)
                lines[index] = StringOperations.reverse(lines[index]);
        }
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

    public boolean isInside(ListBox listBox) {
        return  isInside(listBox.getTopLeft()) & isInside(listBox.getBottomRight());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListBox)) return false;
        if (!super.equals(o)) return false;
        ListBox listBox = (ListBox) o;
        return Arrays.equals(getLines(), listBox.getLines());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(getLines());
        return result;
    }

    public boolean isIntersects(ListBox listBox) {
        return  isInside(listBox.getTopLeft()) ||
                isInside(listBox.getBottomRight()) ||
                isInside(listBox.getTopLeft().getX(),listBox.getTopLeft().getY()+listBox.getHeight()-1) ||
                isInside(listBox.getTopLeft().getX()+listBox.getWidth()-1, listBox.getTopLeft().getY()) ||
                listBox.isInside(getTopLeft()) ||
                listBox.isInside(getBottomRight()) ||
                listBox.isInside(getTopLeft().getX(),getTopLeft().getY()+ getHeight()-1) ||
                listBox.isInside(getTopLeft().getX()+ getWidth()-1, getTopLeft().getY());
    }
}



