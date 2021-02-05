package net.thumbtack.school.ttschool;

public enum TrainingErrorCode {
    TRAINEE_WRONG_LASTNAME ("Last name is null or empty"),
    TRAINEE_WRONG_RATING ("Rating should be between 1 and 5"),
    TRAINEE_WRONG_FIRSTNAME ("First name is null or empty"),
    GROUP_WRONG_NAME ("Group name is empty of null"),
    GROUP_WRONG_ROOM ("Group room is empty or null"),
    TRAINEE_NOT_FOUND ("Trainee not found"),
    SCHOOL_WRONG_NAME ("School name is empty or null"),
    DUPLICATE_GROUP_NAME ("Group with this name is already exists"),
    GROUP_NOT_FOUND ("Group not found"),
    DUPLICATE_TRAINEE ("This trainee is already exists"),
    EMPTY_TRAINEE_QUEUE ("Trainee queue is empty");

    private String errorString;
    TrainingErrorCode(String errorString) {
        this.errorString = errorString;
    }
    public String getErrorString() {
        return errorString;
    }
}
