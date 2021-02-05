package net.thumbtack.school.windows.managers;

import net.thumbtack.school.windows.v4.base.Window;
import net.thumbtack.school.windows.v4.base.WindowException;

// REVU Manager is a raw type. References to generic type Manager<T> should be parameterized
public class NamedManager<T extends Window> extends Manager<T> {
    private String name;
    NamedManager(T window,String name) throws WindowException {
        super(window);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
