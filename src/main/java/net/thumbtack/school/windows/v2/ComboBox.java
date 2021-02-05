package net.thumbtack.school.windows.v2;

import java.util.Objects;

public class ComboBox extends ListBox {
    private Integer selected;

    public ComboBox(Point topLeft, Point bottomRight, boolean active, String[] lines, Integer selected) {
        super(topLeft, bottomRight, active, lines);
        setSelected(selected);
    }

    public ComboBox(int xLeft, int yTop, int width, int height, boolean active, String[] lines, Integer selected) {
        super(xLeft, yTop, width, height, active, lines);
        setSelected(selected);
    }

    public ComboBox(Point topLeft, Point bottomRight, String[] lines, Integer selected) {
        super(topLeft, bottomRight, lines);
        setSelected(selected);
    }

    public ComboBox(int xLeft, int yTop, int width, int height, String[] lines, Integer selected) {
        super(xLeft, yTop, width, height, lines);
        setSelected(selected);
    }

    public Integer getSelected(){
        return selected;
    }


    public void setSelected(Integer selected){
        if (selected != null)
            this.selected = selected;
        else this.selected = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ComboBox comboBox = (ComboBox) o;
        return Objects.equals(selected, comboBox.selected);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), selected);
    }
}
