package net.thumbtack.school.windows.managers;

import net.thumbtack.school.windows.v4.Desktop;
import net.thumbtack.school.windows.v4.base.Window;
import net.thumbtack.school.windows.v4.base.WindowErrorCode;
import net.thumbtack.school.windows.v4.base.WindowException;

public class PairManager<T extends Window,Q extends Window> {
    private T firstWindow;
    private Q secondWindow;

    public PairManager(T firstWindow, Q secondWindow) throws WindowException{
        setFirstWindow(firstWindow);
        setSecondWindow(secondWindow);
    }

    public T getFirstWindow() {
        return firstWindow;
    }

    public void setFirstWindow(T window) throws WindowException{
        if (window == null)
            throw new WindowException(WindowErrorCode.NULL_WINDOW);
        this.firstWindow = window;
    }

    public Q getSecondWindow() {
        return secondWindow;
    }

    public void setSecondWindow(Q window) throws WindowException{
        if (window == null)
            throw new WindowException(WindowErrorCode.NULL_WINDOW);
        this.secondWindow = window;
    }

    public boolean allWindowsFullyVisibleOnDesktop(PairManager<? extends Window,? extends Window> pairManager2, Desktop desktop){
        return  getFirstWindow().isFullyVisibleOnDesktop(desktop) &&
                getSecondWindow().isFullyVisibleOnDesktop(desktop) &&
                pairManager2.getFirstWindow().isFullyVisibleOnDesktop(desktop) &&
                pairManager2.getSecondWindow().isFullyVisibleOnDesktop(desktop);
    }

    public static boolean allWindowsFullyVisibleOnDesktop
            (PairManager<? extends Window,? extends Window> pairManager,PairManager<? extends Window,? extends Window> pairManager2, Desktop desktop){
        return pairManager.allWindowsFullyVisibleOnDesktop(pairManager2,desktop);
    }
}
