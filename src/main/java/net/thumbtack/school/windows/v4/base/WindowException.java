package net.thumbtack.school.windows.v4.base;

public class WindowException extends Exception {
    private WindowErrorCode errorString;

    public WindowException(WindowErrorCode errorCode){
        super(errorCode.getErrorString());
        this.errorString = errorCode;
    }

    public WindowException(WindowErrorCode errorString, Throwable cause){
        super(errorString.getErrorString(),cause);
        this.errorString = errorString;
    }

    public WindowErrorCode getErrorString() {
        return errorString;
    }

    public WindowErrorCode getWindowErrorCode(){
        return getErrorString();
    }
}
