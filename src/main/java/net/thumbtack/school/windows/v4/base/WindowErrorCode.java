package net.thumbtack.school.windows.v4.base;

public enum WindowErrorCode {
    WRONG_STATE("WindowState: DESTROYED/null"),
    WRONG_INDEX("String[]: wrong index"),
    EMPTY_ARRAY("String[]: null"),
    NULL_WINDOW("Window is null");

    private String errorString;
    WindowErrorCode(String errorString){
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }
}
