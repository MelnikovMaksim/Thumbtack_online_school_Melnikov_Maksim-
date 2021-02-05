package net.thumbtack.school.windows.v4.base;

public enum WindowState {
    ACTIVE,INACTIVE,DESTROYED;

    public static WindowState fromString(String stateString) throws WindowException{
        try {
            valueOf(stateString);
            return valueOf(stateString);
        }
        catch (NullPointerException | IllegalArgumentException ex){
            throw new WindowException(WindowErrorCode.WRONG_STATE, ex);
        }
    }
}
